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
    public void addView(final View child, final int index, ViewGroup.LayoutParams params) {
        super.addView(child, index, params);

        if(child != null && child instanceof CheckableView){

            child.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickCheckableView((TreatCheckView)child,index);
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
        checkView.setData(treatCheckable);
        addView(checkView);
        checkView.setChecked(treatCheckable.isChecked);
    }


    private void addChildCheckableView(TreatCheckable treatCheckable) {
        TreatChildCheckView checkView = new TreatChildCheckView(getContext());
        checkView.setData(treatCheckable);
        addView(checkView);
        checkView.setChecked(treatCheckable.isChecked);
    }



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


    private void clickCheckableView(TreatCheckView child, int index) {
        TreatCheckable tc = child.getTreatCheckable();

        for (int i = 0; i < getChildCount(); i++) {
            TreatCheckView treatCheckView = (TreatCheckView) getChildAt(i);
            TreatCheckable treatCheckable = treatCheckView.getTreatCheckable();

            if(tc.id != treatCheckable.id){
                //TODO 多选处理
                updateOtherCheckableView(child.isChecked(), tc, treatCheckView, treatCheckable);
            }
        }

    }


    private void updateOtherCheckableView(boolean isChecked, TreatCheckable tc, TreatCheckView treatCheckView, TreatCheckable treatCheckable) {

        if(isChecked){
            if(tc.is_child == 0 && treatCheckable.is_child == 1 && treatCheckable.parent_id == tc.id){
                //勾选的是父item,而你是它的子item
            }else if(tc.is_child == 1 && treatCheckable.is_child == 0 && tc.parent_id == treatCheckable.id){
                //勾选的是子item,而你是它父item
                treatCheckView.setChecked(true);
            }else{
                treatCheckView.setChecked(false);
            }
        }else{

            //去除勾选的是父item,他的所有子item去除勾选
            if(tc.is_child == 0 && treatCheckable.is_child == 1 && treatCheckable.parent_id == tc.id && treatCheckView.isChecked()){
                treatCheckView.setChecked(false);
            }
        }
    }

}

