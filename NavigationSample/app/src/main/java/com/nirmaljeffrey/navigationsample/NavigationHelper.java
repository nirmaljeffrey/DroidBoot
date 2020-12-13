package com.nirmaljeffrey.navigationsample;

import androidx.annotation.NavigationRes;

public interface NavigationHelper<T> {

    int getStartDestination(T navigationInfo);
    int getNextDestination(int currentDestinationId);
}
