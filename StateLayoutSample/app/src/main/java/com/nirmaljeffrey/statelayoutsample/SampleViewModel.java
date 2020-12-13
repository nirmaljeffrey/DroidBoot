package com.nirmaljeffrey.statelayoutsample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SampleViewModel  extends ViewModel {

    private final MutableLiveData<Integer> stateLiveData = new MutableLiveData<>();

    public MutableLiveData<Integer> getStateLiveData() {
        return stateLiveData;
    }

    public void onEmptyClick(){
        stateLiveData.setValue(StateFulLayout.EMPTY);
    }

    public void onErrorClick(){
        stateLiveData.setValue(StateFulLayout.ERROR);
    }

    public void onContentClick(){
        stateLiveData.setValue(StateFulLayout.SUCCESS);
    }

    public void onLoadingClick(){
        stateLiveData.setValue(StateFulLayout.LOADING);
    }

    public void onOfflineClick(){
        stateLiveData.setValue(StateFulLayout.OFFLINE);
    }
}
