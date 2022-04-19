package com.project.healingEars.activity.ui.myinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.app.databinding.FragmentHomeBinding;
import com.example.app.databinding.FragmentLoginBinding;
import com.project.healingEars.activity.BlankFragment;
import com.project.healingEars.activity.VmShareViewModel;

public class MyInfoFragment extends Fragment {
    //private Context context;
    private FragmentHomeBinding binding;
    private FragmentLoginBinding fraLoginBinding;
    private View view;
    private Bundle savedInstanceState;

    BlankFragment blankFragment = new BlankFragment();
    LoginChildFragment loginChildFragment = new LoginChildFragment();


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Toast.makeText(requireActivity(), "onCreate()", Toast.LENGTH_LONG).show();
    }

    public void onStart() {
        super.onStart();
        //Toast.makeText(requireActivity(), "onStart()", Toast.LENGTH_LONG).show();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 액티비티의 View Model 객체 생성(싱글톤)
        VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);

        // binding 생성
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 라이브 데이터를 보고 변경시 refresh 해줌, 이걸 호출했기때문에 viewModel이 변경되면 알아서 다시 그려지는 것임, xml에 반영
        binding.setLifecycleOwner(this);
        // 뷰 모델 객체를 binding에 꽂아줌, xml에 넣어주는 코드
        binding.setVmShareViewModel(vmShareViewModel);

        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //Toast.makeText(requireActivity(), "onViewCreated()", Toast.LENGTH_LONG).show();


    }


    public void onResume() {
        super.onResume();
        //Toast.makeText(requireActivity(), "onResume()", Toast.LENGTH_LONG).show();
    }

    public void onStop() {
        super.onStop();
        //Toast.makeText(requireActivity(), "onStop()", Toast.LENGTH_LONG).show();
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        //Toast.makeText(requireActivity(), "onSaveInstanceState()", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Toast.makeText(requireActivity(), "onDestroyView()", Toast.LENGTH_LONG).show();
        binding = null;
    }

}