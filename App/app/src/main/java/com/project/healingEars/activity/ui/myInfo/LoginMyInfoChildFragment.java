package com.project.healingEars.activity.ui.myInfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.R;
import com.example.app.databinding.FragmentLoginMyInfoChildBinding;
import com.project.healingEars.activity.ui.VmShareViewModel;


public class LoginMyInfoChildFragment extends Fragment {
    private FragmentLoginMyInfoChildBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);


        binding = FragmentLoginMyInfoChildBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.setLifecycleOwner(this);
        binding.setVmShareViewModel(vmShareViewModel);

        binding.buttonLogout.setOnClickListener(view -> { vmShareViewModel.Logout(); });





        // Inflate the layout for this fragment
        return root;
    }

/*
    public static LoginMyInfoChildFragment newInstance() {
        LoginMyInfoChildFragment fragment = new LoginMyInfoChildFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

 */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Toast.makeText(requireActivity(), "onDestroyView()", Toast.LENGTH_LONG).show();
        binding = null;
    }
}