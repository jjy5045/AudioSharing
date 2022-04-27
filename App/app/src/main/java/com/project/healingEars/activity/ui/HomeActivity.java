package com.project.healingEars.activity.ui;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.app.R;
import com.example.app.databinding.ActivityHomeBinding;
import com.example.app.databinding.NavHeaderHomeBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.project.healingEars.activity.ui.myInfo.MyInfoFragment;
import com.project.healingEars.activity.ui.station.StationViewModel;

public class HomeActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityHomeBinding binding;
    private NavHeaderHomeBinding navHeaderBinding;

    private MyInfoFragment myInfoFrament;


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putBoolean(IS_EDITING_KEY, isEditing);
        //outState.putString(RANDOM_GOOD_DEED_KEY, randomGoodDeed);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 싱글톤으로 보장받는 액티비티 View Mdoel 생성
        VmShareViewModel vmShareViewModel = new ViewModelProvider(this).get(VmShareViewModel.class);
        StationViewModel stationViewModel = new ViewModelProvider(this).get((StationViewModel.class));

        // 뷰 바인딩
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        // 홈뷰에 설정된 ViewModel 값이 변경될 때 마다 UI 업데이트
        binding.setLifecycleOwner(this);
        // ViewModel을 뷰에 넣어줌
        binding.setVmShareViewModel(vmShareViewModel);

        // 네비게이션 뷰
        navHeaderBinding = NavHeaderHomeBinding.bind(binding.navView.getHeaderView(0));
        navHeaderBinding.setLifecycleOwner(this);
        navHeaderBinding.setVmShareViewModel(vmShareViewModel);

        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarHome.toolbar);

        binding.appBarHome.fab.setOnClickListener(view ->
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_my_info, R.id.nav_announce, R.id.nav_station, R.id.nav_product, R.id.nav_board, R.id.nav_introduce)
                .setOpenableLayout(drawer)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //  android:onClick="@{() -> viewModel.buttonClick()}"
        //Toast.makeText(requireActivity(), "onDestroyView()", Toast.LENGTH_LONG).show();
        /*
        if(myInfoFrament == null) {
            myInfoFrament = new MyInfoFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_home1, myInfoFrament).commit();
        }
        if(myInfoFrament != null) getSupportFragmentManager().beginTransaction().show(myInfoFrament).commit();

         */

        /*
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_home1, loginChildFragment).commitAllowingStateLoss();

        vmShareViewModel.loginState.observe(this, s -> {
            if (s.equals("LOGOUT")) { getSupportFragmentManager().beginTransaction().replace(R.id.fragment_home1, loginChildFragment).commit(); }
            else if(s.equals("LOGIN")) getSupportFragmentManager().beginTransaction().replace(R.id.fragment_home1, blankFragment).commitAllowingStateLoss();
        });

         */



        /*
        vmShareViewModel.loginState.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if (s.equals("ON"))
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_home1, blankFragment).commitAllowingStateLoss();
            }
        });
         */




        /////////////////homeFragmentBinding = HomeLoginFragment.bind(binding.)



        /*
        vmShareViewModel.loginState.observe(this, new Observer<String>() {
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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);

        //menu.getItem(R.id.nav_board).setVisible(false);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_home);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}