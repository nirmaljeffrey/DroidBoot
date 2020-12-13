package com.nirmaljeffrey.navigationsample;

import java.security.PublicKey;

public class NavigationHelperImpl implements NavigationHelper<NavigationInformation> {

    @Override
    public int getStartDestination(NavigationInformation navigationInfo) {
        int selectedNumber = navigationInfo.getSelectedNumber();
        switch (selectedNumber){
            case 0:
                return R.id.zeroFragment;
            case 1:
                return R.id.oneFragment;
            case 2:
                return R.id.twoFragment;
            case 3:
                return R.id.threeFragment;
            case 4:
                return R.id.fourFragment;
            case 5:
                return R.id.fiveFragment;
            case 6:
                return R.id.sixFragment;
            case 7:
                return R.id.sevenFragment;
            case 8:
                return R.id.eightFragment;
            case 9:
                return R.id.nineFragment;
            default:
                throw new IllegalStateException("Invalid navigation");

        }
    }

    @Override
    public int getNextDestination(int currentDestinationId) {
        if (currentDestinationId == R.id.zeroFragment) {
            return R.id.oneFragment;
        } else if (currentDestinationId == R.id.oneFragment) {
            return R.id.twoFragment;
        } else if (currentDestinationId == R.id.twoFragment) {
            return R.id.threeFragment;
        } else if (currentDestinationId == R.id.threeFragment) {
            return R.id.fourFragment;
        } else if (currentDestinationId == R.id.fourFragment) {
            return R.id.fiveFragment;
        } else if (currentDestinationId == R.id.fiveFragment) {
            return R.id.sixFragment;
        } else if (currentDestinationId == R.id.sixFragment) {
            return R.id.sevenFragment;
        } else if (currentDestinationId == R.id.sevenFragment) {
            return R.id.eightFragment;
        } else if (currentDestinationId == R.id.eightFragment) {
            return R.id.nineFragment;
        }
        throw new IllegalStateException("Invalid navigation");
    }
}
