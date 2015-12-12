package com.lonshine.lib.base.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.lonshine.lib.R;
import com.lonshine.lib.widget.TitleBar;

/**
 * Created by lonshine on 15/11/5 上午12:04.
 */
public class BaseFragment extends Fragment  {

    public static final int RESULT_FAILED = -2;
    public static final int RESULT_OK = Activity.RESULT_OK;
    public static final int RESULT_CANCELED = Activity.RESULT_CANCELED;

    public static final String KEY_FAIL_MSG = "fail_msg";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initBaseTitleBar();
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
                    getActivity().onBackPressed();
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


    public View findViewById(int id) {
        View content = getView();
        if (content != null) {
            return content.findViewById(id);
        }
        return null;
    }

    public void showProgressDialog(String str) {
        Activity activity = getActivity();
        if (activity instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) activity).showProgressDialog(str);
        }
    }

    public void hideProgressDialog() {
        Activity activity = getActivity();
        if (activity != null && activity instanceof BaseFragmentActivity) {
            ((BaseFragmentActivity) activity).hideProgressDialog();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        hideProgressDialog();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    protected Intent singleEntry(String key, String value) {
        Intent intent = new Intent();
        if (value != null) {
            intent.putExtra(key, value);
        }
        return intent;
    }

    protected void runInBackground(Runnable runnable) {
        new Thread(runnable).start();
    }

    protected void runOnUiThread(Runnable runnable) {
        //http://www.umeng.com/apps/2c500093da5c89dfea191f45/error_types/55e05b82498e5d5774f7bb79
        Activity activity = getActivity();
        if (activity != null && !activity.isFinishing())
            activity.runOnUiThread(runnable);
    }


    public BaseFragmentActivity getParentActivity() {
        return (BaseFragmentActivity) getActivity();
    }
}
