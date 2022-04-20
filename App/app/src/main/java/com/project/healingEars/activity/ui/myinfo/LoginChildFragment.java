package com.project.healingEars.activity.ui.myinfo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.app.databinding.FragmentLoginBinding;
import com.project.healingEars.activity.ui.introduce.IntroduceFragment;
import com.project.healingEars.activity.ui.activity.VmShareViewModel;

public class LoginChildFragment extends Fragment {
    private FragmentLoginBinding binding;
    IntroduceFragment introduceFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.setLifecycleOwner(this);
        binding.setVmShareViewModel(vmShareViewModel);

        binding.btnLogin.setOnClickListener(view -> { vmShareViewModel.Login(binding.edtUserId.getText().toString(), binding.edtUserPassword.getText().toString()); });
        binding.btnSignup.setOnClickListener(view -> { vmShareViewModel.Logout(); });
        binding.btnSession.setOnClickListener(view -> { vmShareViewModel.SessionInfo();});


        //Navigation.findNavController(root).navigate(R.id.action_nav_my_info_to_nav_introduce2);


        //.findNavController(requireView()).navigate(R.id.action_nav_my_info_to_nav_station);


        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false);
        return root;
    }
}