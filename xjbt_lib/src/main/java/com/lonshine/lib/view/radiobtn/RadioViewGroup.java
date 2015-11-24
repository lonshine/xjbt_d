package com.lonshine.lib.view.radiobtn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lonshine.lib.view.checkbox.CheckableView;

/**
 * Created by lonshine on 15/11/4 下午9:51.
 */
public class RadioViewGroup extends LinearLayout {

    private  CheckedStateTracker mChildOnCheckedChangeListener;
    private RadioViewGroup.OnCheckedChangeListener mOnCheckedChangeListener;
    private int mCheckedId = -1;

    public RadioViewGroup(Context context) {
        super(context);
        init();
    }

    public RadioViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RadioViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mChildOnCheckedChangeListener = new CheckedStateTracker();
    }


    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);

        if(child != null && child instanceof RadioView){

            child.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            ((RadioView) child).setOnCheckedChangeWidgetListener(
                    mChildOnCheckedChangeListener);

            if(((RadioView) child).isChecked()){
                if(mCheckedId != -1){
                    setCheckedStateForView(mCheckedId,false);
                }
                setCheckedId(child.getId());
            }
        }

    }

    public int getCheckedId(){
        return mCheckedId;
    }


    private void setCheckedId(int id) {
        mCheckedId = id;
        if (mOnCheckedChangeListener != null) {
            mOnCheckedChangeListener.onCheckedChanged(this, mCheckedId);
        }
    }

    private void setCheckedStateForView(int viewId, boolean checked) {
        View checkedView = findViewById(viewId);
        if (checkedView != null && checkedView instanceof RadioView) {
            ((RadioView) checkedView).setChecked(checked);
        }
    }


    /**
     * 通过id获取RadioView对象
     * @param viewId
     * @return
     */
    public RadioView findRadioViewById(int viewId){
        View checkedView = findViewById(viewId);
        if (checkedView != null && checkedView instanceof RadioView) {
            return ((RadioView) checkedView);
        }else{
            return null;
        }
    }



    public interface OnCheckedChangeListener {
        public void onCheckedChanged(RadioViewGroup group, int checkedId);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }


    private class CheckedStateTracker implements RadioView.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CheckableView checkableView, boolean isChecked) {
            if (mCheckedId != -1) {
                setCheckedStateForView(mCheckedId, false);
            }
            int id = checkableView.getId();
            if(isChecked){
                setCheckedId(id);
            }
        }
    }

}

