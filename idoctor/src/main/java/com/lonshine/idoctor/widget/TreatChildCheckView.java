package com.lonshine.idoctor.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lonshine.idoctor.R;
import com.lonshine.lib.view.checkbox.CheckableView;

/**
 * Created by lonshine on 15/11/18 下午10:39.
 */
public class TreatChildCheckView extends CheckableView {

    TextView tvCheck;
    View vEmpty;

    public TreatChildCheckView(Context context) {
        super(context);
    }

    public TreatChildCheckView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.view_treatcheck,this,true);

        tvCheck = (TextView) findViewById(R.id.tvCheck);
        vEmpty = findViewById(R.id.vEmpty);
    }

    @Override
    public void refreshCheckableView(boolean checked) {
        if(checked){
            tvCheck.setTextColor(getResources().getColor(R.color.red));
        }else{
            tvCheck.setTextColor(getResources().getColor(R.color.black));
        }
    }


}
