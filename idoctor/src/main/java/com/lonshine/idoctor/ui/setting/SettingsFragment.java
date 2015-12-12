package com.lonshine.idoctor.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.lonshine.idoctor.R;
import com.lonshine.lib.base.activity.BaseFragment;
import com.lonshine.lib.base.activity.SingleFragmentActivity;
import com.lonshine.lib.view.dialog.CustomDialogHelper;

import java.lang.ref.WeakReference;

/**
 * Created by lonshine on 15/12/12 下午10:56.
 */
public class SettingsFragment extends BaseFragment{

    //TODO
    public static final int REQUEST_CODE_VIDEO_QUALITY = 9001;

    private SettingsPreference mSettingsPreference;

    private SettingsListItem liClearCache, liAbout, liFeedback;
    private SettingsListToggleItem tiAutoPlay;

    private Button btnLogout;
    private View vContentView;


    public static void startAsActivity(Context context) {
        SingleFragmentActivity.start(context, SettingsFragment.class, null);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LayoutInflater factory = LayoutInflater.from(getActivity());
        vContentView = factory.inflate(R.layout.fragment_settings_test, container, false);
        return vContentView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findViews();
        setListeners();

        tiAutoPlay.setOn(mSettingsPreference.isAutoPlayWhenWiFi());
        refreshToggleViewsFromServer();

        refreshUserViewsVisibility();
        getBaseTitleBar().hiddenLeftTextView();
        getBaseTitleBar().setTitleText("设置");
    }

    private void initData() {
        mSettingsPreference = new SettingsPreference(getActivity());
    }

    private void refreshUserViewsVisibility() {
        //控制UI是否显示
    }


    void findViews() {
        View content = vContentView;

        liClearCache = (SettingsListItem) content.findViewById(R.id.liClearCache);
        liAbout = (SettingsListItem) content.findViewById(R.id.liAbout);
        liFeedback = (SettingsListItem) content.findViewById(R.id.liFeedback);

        tiAutoPlay = (SettingsListToggleItem) content.findViewById(R.id.tiAutoPlay);

        btnLogout = (Button) content.findViewById(R.id.btnLogout);
    }

    void setListeners() {

        liFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "dianji", Toast.LENGTH_SHORT).show();
            }
        });


        liClearCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        liAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getActivity(), AboutActivity.class));
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomDialogHelper dialogHelper = new CustomDialogHelper(getActivity());
                dialogHelper.showNoTitleAlert("是否退出登录?", "确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onClickLogout();
                    }
                }, "取消", null);
            }
        });

//        tiAutoPlay.setOnSwitchStateChangeListener(new ShSwitchView.OnSwitchStateChangeListener() {
//            @Override
//            public void onSwitchStateChange(boolean isOn) {
//                mSettingsPreference.setAutoPlayWhenWiFi(isOn);
//            }
//        });

    }

    public void refreshUserInfoFromServer() {
    }


    void refreshToggleViewsFromServer() {
    }



    private void onClickLogout() {

//        EventBus.getDefault().post(new LogoutEvent());
//
//        DeviceManager.getInstance()
//                .unregister()
//                .continueWith(new Continuation<Object, Object>() {
//                    @Override
//                    public Object then(Task<Object> task) throws Exception {
//                        AccountManager.getInstance().logout();
//                        return null;
//                    }
//                }, Task.UI_THREAD_EXECUTOR);
//
//        //取消签到提醒通知
//        SignInAlarmHelper.getHelper().setIsSignInAlarm(getActivity().getApplicationContext(), false);
//
//        makeSureLoginInfoCleared();
//        UserConfigurationManager.getInstance(getActivity()).resetPushConfigs();
//        getActivity().onBackPressed();
    }

    private void makeSureLoginInfoCleared() {
//        //添加延迟处理，保证登录信息被清除。
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                AccountManager.getInstance().logout();
//
//                //清除新浪微博授权
//                ShareCore.get().clearAuthWeibo(null);
//                //    refreshUserViewsVisibility();
//            }
//        }, 1000);
    }

    static class UpdateUiRunnable implements Runnable {
        WeakReference<SettingsListItem> mClearCacheItem;
        String                          mSize;

        UpdateUiRunnable(SettingsListItem mlClearCache, String size) {
            mClearCacheItem = new WeakReference<SettingsListItem>(mlClearCache);
            mSize = size;
        }

        @Override
        public void run() {
            SettingsListItem mlClearCache = mClearCacheItem.get();
            if (mlClearCache != null)
                mlClearCache.setSubTitle(mSize);
        }
    }



}
