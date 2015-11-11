package com.lonshine.idoctor.treat;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lonshine.idoctor.R;

import java.util.ArrayList;

/**
 * Created by lonshine on 15/11/11 下午10:26.
 */
public class ViewPagerAdapter extends PagerAdapter{

    ArrayList<Object> mList;
    ArrayList<View> mViews = new ArrayList<View>();
    Context mContext;


    public ViewPagerAdapter() {
    }


    public ViewPagerAdapter(Context context,ArrayList<Object> list) {
        mContext = context;
        mList = list;
    }




    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View layout = LayoutInflater.from(mContext).inflate(R.layout.item_pager, null);
        if(mViews.size() < mList.size()){
            mViews.add(layout);
        }

        ((ViewPager)container).addView(layout, 0);

        TextView tv = (TextView) layout.findViewById(R.id.tvItemVpager);
        tv.setText(position + "");

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
