package com.zhao.ui_basic.ui.base;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.zhao.ui_basic.R;
import com.zhao.ui_basic.mvp.BasePresenter;
import com.zhao.ui_basic.mvp.BaseView;

public abstract class BaseActivity<V extends BaseView, P extends BasePresenter> extends AppCompatActivity implements BaseView  {

    private P mPresenter ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setContentView(getLayoutId());
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            View view = window.getDecorView();
            view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE|View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        if (mPresenter == null) {
            mPresenter = createPresenter();
            mPresenter.bindView(this);
        }
        initView();
        initData();
    }

    protected void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }


    protected String getEditText(EditText t){
        return t.getText().toString().trim();
    }

    public void startIntent(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }
    public void startIntent(Class<?> cls, boolean isFinish) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
        finish();
    }
    //abstract 为子类向父类运送
    public abstract boolean isRegister();

    public abstract int getLayoutId();

    public abstract void initView();

    public abstract void initData();

    public abstract P createPresenter();

    public P getmPersenter() {
        return mPresenter;
    }

}
