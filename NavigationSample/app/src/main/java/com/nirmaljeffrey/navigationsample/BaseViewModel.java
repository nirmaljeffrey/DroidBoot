package com.nirmaljeffrey.navigationsample;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.navigation.NavDirections;

import hu.akarnokd.rxjava2.subjects.DispatchWorkSubject;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class BaseViewModel extends AndroidViewModel {

    private DispatchWorkSubject<NavigationCommand> navigationCommand = DispatchWorkSubject.create(AndroidSchedulers.mainThread());

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public Observable<NavigationCommand> getNavigationCommand() {
        return navigationCommand;
    }

    public void navigate(NavDirections navDirections) {
        navigationCommand.onNext(new NavigationCommand.To(navDirections));
    }

    public void navigate(int destination) {
        navigationCommand.onNext(new NavigationCommand.BackTo(destination));
    }

    public void navigateBack() {
        navigationCommand.onNext(NavigationCommand.Back.getInstance());
    }

    public void navigateToRoot() {
        navigationCommand.onNext(NavigationCommand.ToRoot.getInstance());

    }

    public void popBackStack(int destination, boolean inclusive) {
        navigationCommand.onNext(new NavigationCommand.PopBackStack(destination, inclusive));
    }

    public void navigate(int destination, Bundle bundle){
        navigationCommand.onNext(new NavigationCommand.NavigateWithBundle(destination,bundle));
    }
}