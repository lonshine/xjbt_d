package com.lonshine.lib.activity;

/**
 * Created by lonshine on 15/11/4 下午10:05.
 */

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.lonshine.lib.R;
import com.lonshine.lib.view.dialog.CustomDialogHelper;
import com.lonshine.lib.widget.TitleBar;


public abstract class BaseFragmentActivity extends FragmentActivity {


    public TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    String mPageName;

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        /*ButterKnife.inject(this);*/
        initTitleBar();
        initData();
        initView();
    }
    public void setPageName(String pageName) {
        mPageName = pageName;
    }

    private boolean mDisableUmeng = true; //fragment activity 页面，默认不统计，有可能有多个fragment.

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
        //	Reflector.fixInputMethodManager(getWindow().getDecorView());
        //移除所有Observer，防止内存泄露。
        mLoadingDialog = null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void initTitleBar() {
        mTitleBar = (TitleBar) findViewById(R.id.title_bar);
        if (mTitleBar != null) {
            mTitleBar.setOnClickTitleBarListener(new TitleBar.TitleBarListener() {
                @Override
                public void onClickTitle(View v) {
                }

                @Override
                public void onClickLeft(View v) {
                    BaseFragmentActivity.this.finish();
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


    protected void initView() {
    }

    ;

    protected void initData() {
    }

    /**
     * 处理内嵌Child Fragment的回退问题。
     * http://stackoverflow.com/questions/13418436/android-4-2-back-stack-behaviour-with-nested-fragments
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


    public void showFragmentAndAddToStack(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.in_from_right, R.anim.out_to_left, R.anim.in_from_left, R.anim.out_to_right)
                .add(android.R.id.content, fragment)
                .addToBackStack(null)
                .commitAllowingStateLoss();
    }

}
