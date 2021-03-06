package com.phongbm.buoi8;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private LoginFragment fmLogin = new LoginFragment();
    private RegisterFragment fmRegister = new RegisterFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFragment(fmLogin);
//        initFragment();
//        showFragmentWithAdd(fmLogin);
    }

    private void initFragment(){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.panel, fmLogin);
        transaction.add(R.id.panel, fmRegister);
        transaction.commitAllowingStateLoss();
    }

    public void showFragmentWithAdd(Fragment fm){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);
        transaction.hide(fmLogin);
        transaction.hide(fmRegister);
        transaction.show(fm);
        transaction.commitAllowingStateLoss();
    }

    public void showFragment(Fragment fm){
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(android.R.anim.slide_in_left,
                android.R.anim.slide_out_right);
        transaction.replace(R.id.panel, fm);
        transaction.runOnCommit(new Runnable() {
            @Override
            public void run() {
                Log.e(getClass().getName(), "runOnCommit");
            }
        });
        transaction.commitAllowingStateLoss();
    }

    public LoginFragment getFmLogin() {
        return fmLogin;
    }

    public RegisterFragment getFmRegister() {
        return fmRegister;
    }
}
