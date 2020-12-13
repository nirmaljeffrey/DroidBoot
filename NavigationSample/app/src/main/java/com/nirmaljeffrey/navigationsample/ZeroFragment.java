package com.nirmaljeffrey.navigationsample;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nirmaljeffrey.navigationsample.databinding.FragmentZeroBinding;


public class ZeroFragment extends BaseFragment<NumberViewModel> {


    public ZeroFragment() {
        // Required empty public constructor
    }

    private NumberViewModel numberViewModel;
    private NavController navController;




    @Override
    public NumberViewModel getViewModel() {
        navController = Navigation.findNavController(requireActivity(), R.id.navHost);
        ViewModelStoreOwner storeOwner = navController.getViewModelStoreOwner(R.id.nav_graph);
        numberViewModel = new ViewModelProvider(storeOwner).get(NumberViewModel.class);
        return numberViewModel;
    }

    @Override
    public int getNavHostFragmentId() {
        return R.id.navHost;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentZeroBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_zero, container, false);
        binding.button.setOnClickListener(view -> {
            NavDestination navDestination = navController.getCurrentDestination();
            if(navDestination != null){
                numberViewModel.navigationToNextDestination(navDestination.getId());

            }
        });
        return binding.getRoot();
    }
}