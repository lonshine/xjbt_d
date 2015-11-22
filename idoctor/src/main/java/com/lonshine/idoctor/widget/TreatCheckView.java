package com.lonshine.idoctor.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.lonshine.idoctor.R;
import com.lonshine.idoctor.model.TreatCheckable;
import com.lonshine.lib.view.checkbox.CheckableView;

/**
 * Created by lonshine on 15/11/18 下午10:39.
 */
public class TreatCheckView extends CheckableView {
    TextView tvCheck;
    View vEmpty;

    TreatCheckable mTreatCheckable;


    public TreatCheckView(Context context) {
        super(context);
    }

    public TreatCheckView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.view_treatcheck,this,true);

        tvCheck = (TextView) findViewById(R.id.tvCheck);
        vEmpty = findViewById(R.id.vEmpty);
        vEmpty.setVisibility(View.GONE);
    }


    @Override
    public void refreshCheckableView(boolean checked) {
        if(checked){
            tvCheck.setTextColor(getResources().getColor(R.color.red));
        }else{
            tvCheck.setTextColor(getResources().getColor(R.color.black));
        }
    }


    public void setData(TreatCheckable treatCheckable){
        mTreatCheckable = treatCheckable;
        updateView();
    }

    private void updateView() {
        if(mTreatCheckable == null){
            return;
        }
        tvCheck.setText(mTreatCheckable.name);
    }


    public TreatCheckable getTreatCheckable() {
        return mTreatCheckable;
    }

}
