package com.project.healingEars.activity.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.app.R;
import com.example.app.databinding.FragmentHomeLoginBinding;
import com.project.healingEars.activity.VmShareViewModel;

public class HomeLoginFragment extends HomeFragment {
    private FragmentHomeLoginBinding binding;
    private View view;
    private Bundle savedInstanceState;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);

        binding = FragmentHomeLoginBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.setLifecycleOwner(this);
        binding.setVmShareModel((vmShareViewModel));

        binding.btnLogin.setOnClickListener(view -> { vmShareViewModel.Login(binding.edtUserId.getText().toString(), binding.edtUserPassword.getText().toString()); });
        binding.btnSignup.setOnClickListener(view -> { vmShareViewModel.Logout();});
        //binding.btnSession.setOnClickListener(view -> { vmShareViewModel.SessionInfo();});

        /*
        vmShareViewModel.loginState.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(s.equals("ON")) {
                    //getSupportFragmentManager  는 FragmentActivity 의 메소드입니다.
                    //
                    //Fragment에서 부르시니 모르는 함수라고 오류가 날수 밖에 없습니다.
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.fragment_container, ExampleFragment.class, null)
                            .setReorderingAllowed(true)
                            .addToBackStack("name") // name can be null
                            .commit();
                }
            }
        });

         */


        return root;

    }
}
