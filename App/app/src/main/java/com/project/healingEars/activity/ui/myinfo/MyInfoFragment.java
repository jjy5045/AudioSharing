package com.project.healingEars.activity.ui.myinfo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.app.R;
import com.example.app.databinding.FragmentMyinfoBinding;
import com.project.healingEars.activity.ui.introduce.IntroduceFragment;
import com.project.healingEars.activity.ui.activity.VmShareViewModel;

public class MyInfoFragment extends Fragment {
    //private Context context;
    private FragmentMyinfoBinding binding;

    IntroduceFragment introduceFragment;
    LoginChildFragment loginChildFragment;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginChildFragment = new LoginChildFragment();
        getParentFragmentManager().beginTransaction().replace(R.id.fragment_home1, loginChildFragment).commit();

    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


        /*
        outState.putBoolean(IS_EDITING_KEY, isEditing);
        outState.putString(RANDOM_GOOD_DEED_KEY, randomGoodDeed);
         */
        //Toast.makeText(requireActivity(), "onSaveInstanceState()", Toast.LENGTH_LONG).show();
    }

    public void onStart() {
        super.onStart();
        //Toast.makeText(requireActivity(), "onStart()", Toast.LENGTH_LONG).show();
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 액티비티의 View Model 객체 생성(싱글톤)
        VmShareViewModel vmShareViewModel = new ViewModelProvider(requireActivity()).get(VmShareViewModel.class);

        // binding 생성
        binding = FragmentMyinfoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // 라이브 데이터를 보고 변경시 refresh 해줌, 이걸 호출했기때문에 viewModel이 변경되면 알아서 다시 그려지는 것임, xml에 반영
        binding.setLifecycleOwner(this);
        // 뷰 모델 객체를 binding에 꽂아줌, xml에 넣어주는 코드
        binding.setVmShareViewModel(vmShareViewModel);

        if((vmShareViewModel.loginState.getValue()).equals("LOGIN")) binding.fragmentHome1.setVisibility(View.GONE);
        //else if ((vmShareViewModel.loginState.getValue()).equals("LOGOUT")) binding.fragmentHome2.setVisibility(View.GONE);


        vmShareViewModel.mText.observe(requireActivity(), s -> {
            if(s.equals("로그인성공")) {
                vmShareViewModel.mText.setValue("로그인완료");
                //Navigation.findNavController(root).navigate(R.id.action_nav_my_info_to_nav_temp);
                Navigation.findNavController(root).navigate(R.id.action_nav_my_info_to_nav_login_my_info);

            }
        });



        //getParentFragmentManager().beginTransaction().replace(R.id.fragment_home1, blankFragment).commitAllowingStateLoss();

        //Navigation.findNavController(MyInfoFragment.this).navigate(R.id.action_nav_my_info_to_nav_introduce2);
        //Navigation.findNavController(require11111Activity()).navigate();
        // https://black-jin0427.tistory.com/118


        /*
        vmShareViewModel.loginState.observe(requireActivity(), s -> {
            if (s.equals("LOGIN")) { getParentFragmentManager().beginTransaction().replace(R.id.fragment_home1, blankFragment).commit(); }
            else if(s.equals("LOGOUT")) getParentFragmentManager().beginTransaction().replace(R.id.fragment_home1, loginChildFragment).commit();
        });

         */
        //getParentFragmentManager().beginTransaction().replace(R.id.fragment_home1, getParentFragmentManager().findFragmentByTag("Tag")).commit();
        /*
        vmShareViewModel.loginState.observe(requireActivity(), s -> {
            if(s.equals("LOGOUT")) getParentFragmentManager().beginTransaction().replace(R.id.fragment_home1, loginChildFragment).commitAllowingStateLoss();
        });
        */



        return root;
    }


    public void onResume() {
        super.onResume();
        //Toast.makeText(requireActivity(), "onResume()", Toast.LENGTH_LONG).show();
    }

    public void onStop() {
        super.onStop();
        //Toast.makeText(requireActivity(), "onStop()", Toast.LENGTH_LONG).show();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Toast.makeText(requireActivity(), "onDestroyView()", Toast.LENGTH_LONG).show();
        binding = null;
    }

}