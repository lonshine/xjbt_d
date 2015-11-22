package com.lonshine.idoctor.treat;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lonshine.idoctor.R;
import com.lonshine.idoctor.model.TreatCheckable;
import com.lonshine.idoctor.model.TreatProcess;
import com.lonshine.idoctor.model.TreatProject;
import com.lonshine.idoctor.widget.CheckViewGroup;
import com.lonshine.idoctor.widget.TreatCheckView;
import com.lonshine.lib.view.checkbox.CheckableView;

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

    public ViewPagerAdapter(Context context) {
        mContext = context;
    }


    public ViewPagerAdapter(Context context,TreatProject treatProject) {
        mContext = context;
        setTreatProject(treatProject);
    }


    public void setTreatProject(TreatProject treatProject) {
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
        if(mTreatProject == null || mList == null){
            return layout;
        }

        if(mViews.size() < mList.size()){
            mViews.add(layout);
        }
        ((ViewPager)container).addView(layout, 0);

        TextView tvProcessTitle = (TextView) layout.findViewById(R.id.tvProcessTitle);
        TextView tvProcessName = (TextView) layout.findViewById(R.id.tvProcessName);
        TextView tvProcessDescribe = (TextView) layout.findViewById(R.id.tvProcessDescribe);
        CheckViewGroup cvgItemProcess = (CheckViewGroup) layout.findViewById(R.id.cvgItemProcess);


        final TextView tvLeeHJ_main = (TextView) layout.findViewById(R.id.tvLeeHJ_main);
        final TextView tvLeeHJ = (TextView) layout.findViewById(R.id.tvLeeHJ);
        final TextView tvCostantiniM_ok = (TextView) layout.findViewById(R.id.tvCostantiniM_ok);
        final TextView tvCostantiniM = (TextView) layout.findViewById(R.id.tvCostantiniM);
        final TextView tvGokalpG_ok = (TextView) layout.findViewById(R.id.tvGokalpG_ok);
        final TextView tvGokalpG = (TextView) layout.findViewById(R.id.tvGokalpG);
        final TextView tvLvGuorong = (TextView) layout.findViewById(R.id.tvLvGuorong);


        TreatProcess treatProcess = mList.get(position);
        cvgItemProcess.setTreatProcess(treatProcess);
        if(treatProcess.is_child > 0){
            tvProcessTitle.setText(treatProcess.process_index + " - " + treatProcess.parent_name);
            tvProcessName.setText("(" + treatProcess.child_index + ")" + treatProcess.name);
            tvProcessName.setVisibility(View.VISIBLE);
        }else{
            tvProcessTitle.setText(treatProcess.process_index + " - " + treatProcess.name);
            tvProcessName.setVisibility(View.GONE);
        }


        if(TextUtils.isEmpty(treatProcess.describe)){
            tvProcessDescribe.setVisibility(View.GONE);
        }else{
            tvProcessDescribe.setText(treatProcess.describe);
        }

        cvgItemProcess.setOnCheckedChangeListener(new CheckViewGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CheckViewGroup group, CheckableView checkableView, boolean isCheck) {

                TreatCheckable tc = ((TreatCheckView)checkableView).getTreatCheckable();
                if(tc != null){
                    if(tc.treat_result_code.costanini_m > 0 && isCheck){
                        tvCostantiniM.setVisibility(View.VISIBLE);
                    }else{
                        tvCostantiniM.setVisibility(View.GONE);
                    }

                    if(tc.treat_result_code.costanini_m_ok > 0 && isCheck){
                        tvCostantiniM_ok.setVisibility(View.VISIBLE);
                    }else{
                        tvCostantiniM_ok.setVisibility(View.GONE);
                    }

                    if(tc.treat_result_code.lee_hj > 0 && isCheck){
                        tvLeeHJ.setVisibility(View.VISIBLE);
                    }else{
                        tvLeeHJ.setVisibility(View.GONE);
                    }


                    if(tc.treat_result_code.lee_hj_main > 0 && isCheck){
                        tvLeeHJ_main.setVisibility(View.VISIBLE);
                    }else{
                        tvLeeHJ_main.setVisibility(View.GONE);
                    }


                    if(tc.treat_result_code.gokalp_g > 0 && isCheck){
                        tvGokalpG.setVisibility(View.VISIBLE);
                    }else{
                        tvGokalpG.setVisibility(View.GONE);
                    }


                    if(tc.treat_result_code.gokalp_g_ok > 0 && isCheck){
                        tvGokalpG_ok.setVisibility(View.VISIBLE);
                    }else{
                        tvGokalpG_ok.setVisibility(View.GONE);
                    }


                    if(tc.treat_result_code.lvguorong > 0 && isCheck){
                        tvLvGuorong.setVisibility(View.VISIBLE);
                    }else{
                        tvLvGuorong.setVisibility(View.GONE);
                    }

                }

            }
        });



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
