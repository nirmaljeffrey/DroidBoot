package com.nirmaljeffrey.navigationsample;

import android.os.Bundle;

import androidx.navigation.NavDirections;

public class NavigationCommand {
    private NavigationCommand() {

    }

    public static final class To extends NavigationCommand {
        private final NavDirections directions;

        public To(NavDirections directions) {
            this.directions = directions;
        }

        public NavDirections getDirections() {
            return directions;
        }
    }

    public static final class Back extends NavigationCommand {
        private static final Back INSTANCE = new Back();

        private Back() {
        }

        public static Back getInstance() {
            return INSTANCE;
        }
    }

    public static final class ToRoot extends NavigationCommand {
        private static final ToRoot INSTANCE = new ToRoot();

        private ToRoot() {

        }

        public static ToRoot getInstance() {
            return INSTANCE;
        }
    }

    public static final class BackTo extends NavigationCommand {
        private final int destination;

        public BackTo(int destination) {
            this.destination = destination;
        }

        public int getDestination() {
            return destination;
        }
    }

    public static final class PopBackStack extends NavigationCommand {
        private final int destination;
        private boolean inclusive;

        public PopBackStack(int destination, boolean inclusive) {
            this.destination = destination;
            this.inclusive = inclusive;
        }

        public int getDestination() {
            return destination;
        }

        public boolean isInclusive() {
            return inclusive;
        }
    }

    public static final class NavigateWithBundle extends NavigationCommand {
        private final int destination;
        private Bundle bundle;

        public NavigateWithBundle(int destination, Bundle bundle) {
            this.destination = destination;
            this.bundle = bundle;
        }

        public int getDestination() {
            return destination;
        }

        public Bundle getBundle() {
            return bundle;
        }
    }


}