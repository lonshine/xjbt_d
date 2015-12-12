package com.lonshine.idoctor.ui.main;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lonshine.idoctor.R;
import com.lonshine.idoctor.ui.treat.TreatActivity;
import com.lonshine.lib.base.activity.BaseFragment;

/**
 * Created by lonshine on 15/11/10 上午12:16.
 */
public class HomeFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);

        return view;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getBaseTitleBar().hiddenLeftTextView();
        getBaseTitleBar().setTitleText("主页");

        view.findViewById(R.id.tvRuxian).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TreatActivity.start(getActivity());
            }
        });

    }
}
