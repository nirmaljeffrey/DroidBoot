package com.nirmaljeffrey.navigationsample;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class NineFragment extends BaseFragment<NumberViewModel> {


    public NineFragment() {
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nine, container, false);
    }
}