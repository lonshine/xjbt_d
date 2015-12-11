package com.lonshine.idoctor.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lonshine.idoctor.R;
import com.lonshine.lib.activity.BaseFragment;

/**
 * Created by lonshine on 15/11/10 上午12:17.
 */
public class InfoFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, null);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBaseTitleBar().hiddenLeftTextView();
        getBaseTitleBar().setTitleText("我的");
    }
}
