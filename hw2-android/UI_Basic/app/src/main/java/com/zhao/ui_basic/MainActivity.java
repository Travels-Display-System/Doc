package com.zhao.ui_basic;

import android.util.Log;

import com.zhao.ui_basic.main.Presenter.MainPresenter;
import com.zhao.ui_basic.main.View.MainView;
import com.zhao.ui_basic.ui.base.BaseActivity;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView{
    @Override
    public boolean isRegister() {
        return true;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
    }

    @Override
    public void initData() {
    }

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }


    @Override
    public void setData(Object o) {

    }

    @Override
    public void error(String e) {
        Log.e("error:", e);
    }
}
