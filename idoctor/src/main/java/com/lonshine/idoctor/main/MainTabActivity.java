package com.lonshine.idoctor.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.lonshine.idoctor.R;
import com.lonshine.lib.activity.BaseFragmentActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lonshine on 15/11/8 下午9:41.
 */
public class MainTabActivity extends BaseFragmentActivity implements RadioGroup.OnCheckedChangeListener {

    @InjectView(R.id.vpMainTab)
    ViewPager vpMainTab;
    @InjectView(R.id.rbHome)
    RadioButton rbHome;
    @InjectView(R.id.rbInfo)
    RadioButton rbInfo;
    @InjectView(R.id.rgMainTab)
    RadioGroup rgMainTab;


    private TabPagerAdapter mTabPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tab);

    }


    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
        ButterKnife.inject(this);

        vpMainTab.setOffscreenPageLimit(TabPagerAdapter.TAB_COUNT);
        rgMainTab.setOnCheckedChangeListener(this);

        mTabPagerAdapter = new TabPagerAdapter(getSupportFragmentManager());
        mTabPagerAdapter.setDiscoverInitTab(TabPagerAdapter.TAB_HOME);
        vpMainTab.setAdapter(mTabPagerAdapter);

        vpMainTab.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (!((RadioButton) rgMainTab.getChildAt(position)).isChecked()) {
                    ((RadioButton) rgMainTab.getChildAt(position)).setChecked(true);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rbHome:
                setPagerCurrentItem(TabPagerAdapter.TAB_HOME);
                break;
            case R.id.rbInfo:
                setPagerCurrentItem(TabPagerAdapter.TAB_ME);

                break;
    }
}

    private void setPagerCurrentItem(int index){
        //目前先对vpPager做判断，防止onNewIntent()调用时，出现NullPointerException而崩溃，
        // 主要在vivo的手机上会出现这个问题
        if (vpMainTab == null) {
            Log.e("","setPagerCurrentItem: vpPager == null.");
            return;
        }


        if(vpMainTab.getCurrentItem() != index){
            vpMainTab.setCurrentItem(index, true);
            Fragment fragment = mTabPagerAdapter.getItem(index);
            if (fragment == null) {
                Log.e("","setPagerCurrentItem: fragment == null.");
                return;
            }
        }
//        BaseFragment.checkAndInvokeOnPageStart(fragment);
    }
    }

