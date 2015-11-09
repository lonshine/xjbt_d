package com.lonshine.idoctor.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lonshine.idoctor.R;

/**
 * Created by lonshine on 15/11/10 上午12:17.
 */
public class InfoFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, null);

        return view;
    }
}
