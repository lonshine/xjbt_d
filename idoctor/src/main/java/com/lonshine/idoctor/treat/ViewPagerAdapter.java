package com.lonshine.idoctor.treat;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lonshine.idoctor.R;
import com.lonshine.idoctor.model.TreatProcess;
import com.lonshine.idoctor.model.TreatProject;
import com.lonshine.idoctor.widget.CheckViewGroup;

import java.util.ArrayList;

/**
 * Created by lonshine on 15/11/11 下午10:26.
 */
public class ViewPagerAdapter extends PagerAdapter{

    ArrayList<TreatProcess> mList;
    ArrayList<View> mViews = new ArrayList<View>();
    Context mContext;
    TreatProject mTreatProject;

    private ViewPagerAdapter() {
    }


    public ViewPagerAdapter(Context context,TreatProject treatProject) {
        mContext = context;
        mTreatProject = treatProject;

        if(mTreatProject.data != null && mTreatProject.data.size() > 0){
            mList = mTreatProject.data;
        }else{
            mList = new ArrayList<TreatProcess>();
        }
    }




    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View layout = LayoutInflater.from(mContext).inflate(R.layout.item_layout_treat_process, null);
        if(mViews.size() < mList.size()){
            mViews.add(layout);
        }

        ((ViewPager)container).addView(layout, 0);

        TextView tv = (TextView) layout.findViewById(R.id.tvProcessTitle);
        tv.setText(position + "");

        CheckViewGroup cvgItemProcess = (CheckViewGroup) layout.findViewById(R.id.cvgItemProcess);

        TreatProcess treatProcess = mList.get(position);
        cvgItemProcess.setTreatProcess(treatProcess);

        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position));
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public int getCount() {
        if(mList != null && mList.size() > 0){
            return mList.size();
        }
        return 0;
    }



}
