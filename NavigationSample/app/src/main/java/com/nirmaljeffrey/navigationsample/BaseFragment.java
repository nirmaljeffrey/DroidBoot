package com.nirmaljeffrey.navigationsample;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseFragment<T extends BaseViewModel> extends Fragment {
    private T viewModel;
    private int navHostFragmentId;
    private final CompositeDisposable disposable = new CompositeDisposable();
    public static final int  NO_HOST_FRAGMENT = -1;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = getViewModel();
        navHostFragmentId = getNavHostFragmentId();
    }

    public abstract T getViewModel();

    public abstract int getNavHostFragmentId();

    @Override
    public void onStart() {
        super.onStart();
        if(viewModel != null & navHostFragmentId != NO_HOST_FRAGMENT) {
            NavController navController = Navigation.findNavController(requireActivity(),navHostFragmentId);
            disposable.add(viewModel.getNavigationCommand()
                    .subscribe(navigationCommand -> {
                        if (navigationCommand instanceof NavigationCommand.To) {
                            navController.navigate(((NavigationCommand.To) navigationCommand).getDirections());
                        } else if (navigationCommand instanceof NavigationCommand.BackTo) {
                            navController.navigate(((NavigationCommand.BackTo) navigationCommand).getDestination());
                        } else if (navigationCommand instanceof NavigationCommand.Back) {
                            requireActivity().onBackPressed();
                        } else if (navigationCommand instanceof NavigationCommand.PopBackStack) {
                            NavigationCommand.PopBackStack popBackStack = (NavigationCommand.PopBackStack) navigationCommand;
                            navController.popBackStack(popBackStack.getDestination(), popBackStack.isInclusive());
                        } else if (navigationCommand instanceof NavigationCommand.NavigateWithBundle) {
                            NavigationCommand.NavigateWithBundle navigateWithBundle = (NavigationCommand.NavigateWithBundle) navigationCommand;
                            navController.navigate(navigateWithBundle.getDestination(), navigateWithBundle.getBundle());
                        }
                    }));

        }

    }

    @Override
    public void onStop() {
        disposable.clear();
        super.onStop();
    }
}