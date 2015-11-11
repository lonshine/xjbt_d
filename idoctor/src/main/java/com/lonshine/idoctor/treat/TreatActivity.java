package com.lonshine.idoctor.treat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.lonshine.idoctor.R;
import com.lonshine.lib.activity.BaseFragmentActivity;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lonshine on 15/11/11 下午9:52.
 */
public class TreatActivity extends BaseFragmentActivity {

    ArrayList<Object> mDataList;


    @InjectView(R.id.vpTreat)
    ViewPager vpTreat;


    public static void start(Context context){
        Intent intent = new Intent(context,TreatActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat);
    }


    @Override
    protected void initData() {

        mDataList = new ArrayList<Object>();
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");
        mDataList.add("");

    }


    @Override
    protected void initView() {
        ButterKnife.inject(this);
        ViewPagerAdapter mAdapter = new ViewPagerAdapter(this,mDataList);
        vpTreat.setAdapter(mAdapter);
    }
}
