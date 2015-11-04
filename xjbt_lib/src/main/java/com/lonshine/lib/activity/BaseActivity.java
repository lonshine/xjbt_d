package com.lonshine.lib.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import com.lonshine.lib.R;
import com.lonshine.lib.view.dialog.CustomDialogHelper;
import com.lonshine.lib.widget.TitleBar;

/**
 * Created by lonshine on 15/11/4 下午11:59.
 */
public abstract class BaseActivity extends Activity  {


    String mPageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        /* ButterKnife.inject(this); */
        initBaseTitleBar();
        initData();
        initView();
    }

    private TitleBar mTitleBar;

    private void initBaseTitleBar() {
        mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        if (mTitleBar != null) {
            mTitleBar.setOnClickTitleBarListener(new TitleBar.TitleBarListener() {
                @Override
                public void onClickTitle(View v) {
                }

                @Override
                public void onClickLeft(View v) {
                    BaseActivity.this.finish();
                }

                @Override
                public void onClickRight(View v) {
                }
            });
        }
    }

    /**
     * 使用之前必须确认，该界面含有R.id.title_bar
     *
     * @return
     */
    public TitleBar getBaseTitleBar() {
        if (mTitleBar != null) {
            return mTitleBar;
        }
        return null;
    }


    public void setPageName(String pageName) {
        mPageName = pageName;
    }

    private boolean mDisableUmeng = false;

    //禁用umeng统计当前页面。
    public void setDisableUmeng(boolean disableUmeng) {
        mDisableUmeng = disableUmeng;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //这样解决内存泄露问题，会键盘不能弹出的问题。
        //比如界面从注册界面，切换到登陆界面，以下方法会使InputMethodMenanger的mCurrentRootView = null, 从而引发各种奇怪问题。
        //具体原因应该与onDestroy的调用与onCreate的顺序之间的问题有关。
        //Reflector.fixInputMethodManager(getWindow().getDecorView());
        mLoadingDialog = null;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    protected void initData() {
    }

    protected void initView() {
    }

    protected void onReload() {
        //to be override
    }


    private Dialog mLoadingDialog;

    public void showProgressDialog(String str) {
        if (mLoadingDialog != null) {
            return;
        }
        mLoadingDialog = new CustomDialogHelper(this).showLoading(str);
    }

    public void hideProgressDialog() {
        if (mLoadingDialog != null && mLoadingDialog.isShowing()) {
            mLoadingDialog.dismiss();
            mLoadingDialog = null;
        }
    }


}