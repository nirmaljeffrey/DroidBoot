package com.nirmaljeffrey.navigationsample;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nirmaljeffrey.navigationsample.databinding.FragmentMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainFragment extends BaseFragment<NumberViewModel> implements MainRecyclerViewAdapter.MainClickListener {


    private ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
    private NavController navController;
    private NumberViewModel numberViewModel;

    public MainFragment() {
        // Required empty public constructor
    }



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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        MainRecyclerViewAdapter recyclerViewAdapter = new MainRecyclerViewAdapter();
        recyclerViewAdapter.setNumbers(numberList);
        recyclerViewAdapter.setClickListener(this);
        binding.recyclerView.setAdapter(recyclerViewAdapter);
        return binding.getRoot();
    }


    @Override
    public void onNumberClick(Integer number) {
        numberViewModel.navigationToStartDestination(number);
    }
}