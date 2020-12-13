package com.nirmaljeffrey.statelayoutsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;

import android.os.Bundle;

import com.nirmaljeffrey.statelayoutsample.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        SampleViewModel viewModel = new ViewModelProvider(this).get(SampleViewModel.class);
        binding.setViewmodel(viewModel);
        binding.setLifecycleOwner(this);
    }
}