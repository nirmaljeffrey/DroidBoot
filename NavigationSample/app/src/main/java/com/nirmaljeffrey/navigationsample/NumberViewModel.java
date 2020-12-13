package com.nirmaljeffrey.navigationsample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;

public class NumberViewModel extends BaseViewModel {
    private  NavigationInformation navigationInformation;
    private  NavigationHelperImpl navigationHelper;



    public NumberViewModel(@NonNull Application application) {
        super(application);
        navigationInformation = new NavigationInformation();
        navigationHelper = new NavigationHelperImpl();
    }


    public void navigationToStartDestination(int selectedNumber) {
        navigationInformation.setSelectedNumber(selectedNumber);
        navigate(navigationHelper.getStartDestination(navigationInformation));
    }
    public void navigationToNextDestination(int currentDestinationId) {
        navigate(navigationHelper.getNextDestination(currentDestinationId));
    }
}
