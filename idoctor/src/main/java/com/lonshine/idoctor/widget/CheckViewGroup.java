package com.lonshine.idoctor.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.lonshine.idoctor.model.TreatCheckable;
import com.lonshine.idoctor.model.TreatProcess;
import com.lonshine.lib.view.checkbox.CheckableView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lonshine on 15/11/4 下午9:51.
 */
public class CheckViewGroup extends LinearLayout {

    private  CheckedStateTracker mChildOnCheckedChangeListener;
    private CheckViewGroup.OnCheckedChangeListener mOnCheckedChangeListener;
    private int mLastChangedId = -1;

    HashMap<Long,Boolean> mCheckedList;

    TreatProcess mTreatProcess;


    public CheckViewGroup(Context context) {
        super(context);
        init();
    }

    public CheckViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CheckViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        mChildOnCheckedChangeListener = new CheckedStateTracker();
        mCheckedList = new HashMap<Long,Boolean>();
    }


    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);

        if(child != null && child instanceof CheckableView){

            child.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
            ((CheckableView) child).setOnCheckedChangeWidgetListener(
                    mChildOnCheckedChangeListener);

        }
    }


    /**
     * 关联流程对象
     * @param treatProcess
     */
    public void setTreatProcess(TreatProcess treatProcess){
        if(treatProcess == null){
            return;
        }

        mTreatProcess = treatProcess;

        if(mTreatProcess.check_list != null && mTreatProcess.check_list.size() > 0){
            addTreatCheckableView(mTreatProcess.check_list);
        }
    }


    public void addTreatCheckableView(List< TreatCheckable> list){
        for (int i = 0; i < list.size(); i++) {
            TreatCheckable treatCheckable = list.get(i);
            if(treatCheckable.is_child > 0){
                addChildCheckableView(treatCheckable);
            }else{
                addCheckableView(treatCheckable);
            }
        }
    }


    private void addCheckableView(TreatCheckable treatCheckable) {
        TreatCheckView checkView = new TreatCheckView(getContext());
        checkView.setTag(treatCheckable);
        checkView.setData(treatCheckable);
        addView(checkView);
    }


    private void addChildCheckableView(TreatCheckable treatCheckable) {
        TreatChildCheckView checkView = new TreatChildCheckView(getContext());
        checkView.setTag(treatCheckable);
        checkView.setData(treatCheckable);
        addView(checkView);
    }



//    private void setLastChangedView(CheckableView checkableView, boolean isCheck) {
//        if(checkableView == null){
//            return;
//        }
//        mLastChangedId = checkableView.getId();
//        if (mOnCheckedChangeListener != null) {
//            mOnCheckedChangeListener.onCheckedChanged(this, checkableView,isCheck);
//        }
//    }

    public void setCheckedStateForView(int viewId, boolean checked) {
        View checkedView = findViewById(viewId);
        if (checkedView != null && checkedView instanceof CheckableView) {
            ((CheckableView) checkedView).setChecked(checked);
        }
    }


    /**
     * 通过id获取RadioView对象
     * @param viewId
     * @return
     */
    public CheckableView findRadioViewById(int viewId){
        View checkedView = findViewById(viewId);
        if (checkedView != null && checkedView instanceof CheckableView) {
            return ((CheckableView) checkedView);
        }else{
            return null;
        }
    }



    public interface OnCheckedChangeListener {
        public void onCheckedChanged(CheckViewGroup group, CheckableView checkableView,boolean isCheck);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
        mOnCheckedChangeListener = listener;
    }


    private class CheckedStateTracker implements CheckableView.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CheckableView checkableView, boolean isChecked) {
            checkdStateTrackerChanged(checkableView, isChecked);
        }
    }

    /**
     * childView状态变化时
     */
    public void checkdStateTrackerChanged(CheckableView checkableView, boolean isChecked) {
        //TODO
        if(mOnCheckedChangeListener != null){
            mOnCheckedChangeListener.onCheckedChanged(this,checkableView,isChecked);
        }
    }

}

