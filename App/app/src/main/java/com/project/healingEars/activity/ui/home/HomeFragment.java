package com.project.healingEars.activity.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.app.databinding.FragmentHomeBinding;
import com.project.healingEars.activity.VmShareViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // binding 생성
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        /*
        // 라이브 데이터를 보고 변경시 refresh 해줌, 이걸 호출했기때문에 viewModel이 변경되면 알아서 다시 그려지는 것임, xml에 반영
        binding.setLifecycleOwner(this);

        // 뷰 모델 객체 생성
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);


        // 뷰 모델 객체를 binding에 꽂아줌, xml에 넣어주는 코드
        binding.setHomeViewModel(homeViewModel);


        binding.btnLogin.setOnClickListener( view -> { homeViewModel.Login(binding.edtUserId.getText().toString(), binding.edtUserPassword.getText().toString()); });
        */

        binding.setLifecycleOwner(this);

        VmShareViewModel homeViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);

        binding.btnLogin.setOnClickListener( view -> {
            homeViewModel.Login(binding.edtUserId.getText().toString(), binding.edtUserPassword.getText().toString());
        });

        homeViewModel.mText.observe(requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                binding.textHome.setText(s);
            }
        });




        /*
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        */
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}