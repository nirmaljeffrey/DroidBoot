package com.nirmaljeffrey.statelayoutsample;

import androidx.databinding.BindingAdapter;

import com.facebook.shimmer.ShimmerFrameLayout;

public class BindingAdapters {
    @BindingAdapter("shimmerState")
    public static void setShimmerState(ShimmerFrameLayout shimmerFrameLayout, @StateFulLayout.State int shimmerState){
        if(shimmerFrameLayout != null) {
            if (shimmerState == StateFulLayout.LOADING) {
                shimmerFrameLayout.startShimmer();
            } else {
                shimmerFrameLayout.stopShimmer();
            }
        }
    }
}
