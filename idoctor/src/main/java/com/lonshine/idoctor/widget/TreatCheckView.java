package com.lonshine.idoctor.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
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
    ImageView ivRadio;


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
        ivRadio = (ImageView) findViewById(R.id.ivRadio);
        ivRadio.setVisibility(View.GONE);
    }


    @Override
    public void refreshCheckableView(boolean checked) {
        if(checked){
            tvCheck.setTextColor(getResources().getColor(R.color.red));
            tvCheck.setBackgroundResource(R.drawable.bg_item_treatcheck_p);
        }else{
            tvCheck.setTextColor(getResources().getColor(R.color.black));
            tvCheck.setBackgroundResource(R.drawable.bg_item_treatcheck_n);
        }

        Log.d("名称check - refresh","" + mTreatCheckable.name);
        Log.d("名称check - refresh ---","" + tvCheck.getText().toString());
    }


    public void setData(TreatCheckable treatCheckable){
        mTreatCheckable = treatCheckable;
        updateView();
    }

    private void updateView() {
        if(mTreatCheckable == null){
            return;
        }

        Log.d("名称check","" + mTreatCheckable.name);

        tvCheck.setText(mTreatCheckable.name);
    }


    public TreatCheckable getTreatCheckable() {
        return mTreatCheckable;
    }

}
