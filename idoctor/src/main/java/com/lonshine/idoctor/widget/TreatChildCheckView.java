package com.lonshine.idoctor.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lonshine.idoctor.R;
import com.lonshine.idoctor.model.TreatCheckable;

/**
 * Created by lonshine on 15/11/18 下午10:39.
 */
public class TreatChildCheckView extends TreatCheckView {

    TextView tvCheck;
    View vEmpty;

    TreatCheckable mTreatCheckable;
    ImageView ivRadio;


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
        ivRadio = (ImageView) findViewById(R.id.ivRadio);
        ivRadio.setVisibility(View.VISIBLE);
    }

    @Override
    public void refreshCheckableView(boolean checked) {
        if(checked){
            tvCheck.setTextColor(getResources().getColor(R.color.pink));
            ivRadio.setImageResource(R.drawable.rb_child_check_p);
            tvCheck.setBackgroundResource(R.drawable.bg_item_treatcheck_p);
        }else{
            tvCheck.setTextColor(getResources().getColor(R.color.black));
            ivRadio.setImageResource(R.drawable.rb_child_check_n);
            tvCheck.setBackgroundResource(R.drawable.bg_item_treatcheck_n);
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
