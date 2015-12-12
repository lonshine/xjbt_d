package com.lonshine.lib.base.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by lonshine on 15/12/12 下午11:13.
 */
public class SingleFragmentActivity extends BaseFragmentActivity {

    public static final String EXTRA_FRAGMENT_NAME = "fragment_name";
    public static final String EXTRA_ARGS          = "args";

    /**
     * 不要在该方法内部为intent添加flag_new_task,否则startActivityForResult时收不到回调的数据.比如发布妆品编辑页，
     */
    public static Intent createStartIntent(Context context, Class<? extends Fragment> fragment, Bundle args) {
        Intent intent = new Intent(context, SingleFragmentActivity.class);
        intent.putExtra(EXTRA_FRAGMENT_NAME, fragment.getName());
        if (args != null) intent.putExtra(EXTRA_ARGS, args);
        return intent;
    }

    /**
     * 启动一个Activity，仅用来显示一个Fragment。
     * 使用java的反射原理显示， 要求Fragment必须有一个默认构造函数。
     *
     * @param fragment Fragment的类。
     * @param args     Fragment的参数。
     */
    public static void start(Context context, Class<? extends Fragment> fragment, Bundle args) {
        Intent intent = createStartIntent(context, fragment, args);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
    //支持获取结果。
    public static void startActivityForResult(Activity activity, Class<? extends Fragment> fragment, Bundle args, int requestCode) {
        activity.startActivityForResult(createStartIntent(activity, fragment, args), requestCode);
    }
    //支持获取结果。
    public static void startActivityForResult(Fragment fragment, Class<? extends Fragment> cls, Bundle args, int requestCode) {
        fragment.startActivityForResult(createStartIntent(fragment.getActivity(), cls, args), requestCode);
    }

    public static Bundle singleEntryBundle(String key, String value) {
        Bundle bundle = new Bundle();
        if (value != null) {
            bundle.putString(key, value);
        }
        return bundle;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(null);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, createFragment(getIntent()))
                .commitAllowingStateLoss();
    }
    private String mPageName;

    protected Fragment createFragment(Intent intent) {
        String fragment_name = intent.getStringExtra(EXTRA_FRAGMENT_NAME);
        try {
            Fragment fragment = (Fragment) Class.forName(fragment_name).newInstance();
            mPageName = fragment.getClass().getName();
            Bundle args = intent.getBundleExtra(EXTRA_ARGS);
            if (args != null) {
                fragment.setArguments(args);
            }
            //扩展支持Result回调。
            if (fragment instanceof BaseFragment) {
                //TODO
//                ((BaseFragment) fragment).setResultCallback(this);
            }
            return fragment;
        } catch (Exception e) {
            throw new RuntimeException("Can't newInstance of " + fragment_name);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        if (!DebugManager.get().isAllowUmeng()) {
//            return;
//        }
//        UmengPageStatsManager.getInstance().onLastPageEndAndPageStart(mPageName);
    }

    @Override
    protected void onPause() {
        super.onPause();
//        if (!DebugManager.get().isAllowUmeng()) {
//            return;
//        }
//        UmengPageStatsManager.getInstance().onMobPageEnd(mPageName);
    }
}