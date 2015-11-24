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
import com.lonshine.idoctor.model.TreatResultCode;
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


        tvLeeHJ_main = (TextView) layout.findViewById(R.id.tvLeeHJ_main);
        tvLeeHJ = (TextView) layout.findViewById(R.id.tvLeeHJ);
        tvCostantiniM_ok = (TextView) layout.findViewById(R.id.tvCostantiniM_ok);
        tvCostantiniM = (TextView) layout.findViewById(R.id.tvCostantiniM);
        tvGokalpG_ok = (TextView) layout.findViewById(R.id.tvGokalpG_ok);
        tvGokalpG = (TextView) layout.findViewById(R.id.tvGokalpG);
        tvLvGuorong = (TextView) layout.findViewById(R.id.tvLvGuorong);


        final TreatProcess treatProcess = mList.get(position);
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




            tvCostantiniM.setVisibility(View.GONE);
            tvCostantiniM_ok.setVisibility(View.GONE);
            tvLeeHJ.setVisibility(View.GONE);
            tvLeeHJ_main.setVisibility(View.GONE);
            tvGokalpG.setVisibility(View.GONE);
            tvGokalpG_ok.setVisibility(View.GONE);
            tvLvGuorong.setVisibility(View.GONE);





        cvgItemProcess.setOnCheckedChangeListener(new CheckViewGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CheckViewGroup group, CheckableView checkableView, boolean isCheck) {

                TreatCheckable tc = ((TreatCheckView)checkableView).getTreatCheckable();
                if(tc != null){
                    if(isCheck){
                        treatProcess.treat_result_code.costanini_m += tc.treat_result_code.costanini_m;
                    }else{
                        if(treatProcess.treat_result_code.costanini_m > 0){
                            treatProcess.treat_result_code.costanini_m -= tc.treat_result_code.costanini_m;
                        }
                    }

                    if(isCheck){
                        treatProcess.treat_result_code.costanini_m_ok += tc.treat_result_code.costanini_m_ok;
                    }else{
                        if(treatProcess.treat_result_code.costanini_m_ok > 0){
                            treatProcess.treat_result_code.costanini_m_ok -= tc.treat_result_code.costanini_m_ok;
                        }
                    }

                    if(isCheck){
                        treatProcess.treat_result_code.lee_hj += tc.treat_result_code.lee_hj;
                    }else{
                        if(treatProcess.treat_result_code.lee_hj > 0){
                            treatProcess.treat_result_code.lee_hj -= tc.treat_result_code.lee_hj;
                        }
                    }


                    if(isCheck){
                        treatProcess.treat_result_code.lee_hj_main += tc.treat_result_code.lee_hj_main;
                    }else{
                        if(treatProcess.treat_result_code.lee_hj_main > 0){
                            treatProcess.treat_result_code.lee_hj_main -= tc.treat_result_code.lee_hj_main;
                        }
                    }


                    if(isCheck){
                        treatProcess.treat_result_code.gokalp_g += tc.treat_result_code.gokalp_g;
                    }else{
                        if(treatProcess.treat_result_code.gokalp_g > 0){
                            treatProcess.treat_result_code.gokalp_g -= tc.treat_result_code.gokalp_g;
                        }
                    }


                    if(isCheck){
                        treatProcess.treat_result_code.gokalp_g_ok += tc.treat_result_code.gokalp_g_ok;
                    }else{
                        if(treatProcess.treat_result_code.gokalp_g_ok > 0){
                            treatProcess.treat_result_code.gokalp_g_ok -= tc.treat_result_code.gokalp_g_ok;
                        }
                    }


                    if(isCheck){
                        treatProcess.treat_result_code.lvguorong += tc.treat_result_code.lvguorong;
                    }else{
                        if(treatProcess.treat_result_code.lvguorong > 0){
                            treatProcess.treat_result_code.lvguorong -= tc.treat_result_code.lvguorong;
                        }
                    }

                }

                updateTestResult(treatProcess.treat_result_code);
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




     TextView tvLeeHJ_main;
     TextView tvLeeHJ;
     TextView tvCostantiniM_ok;
     TextView tvCostantiniM;
     TextView tvGokalpG_ok;
     TextView tvGokalpG;
     TextView tvLvGuorong;
    public void updateTestResult(TreatResultCode resultCode){

        if(resultCode.costanini_m > 0){
            tvCostantiniM.setVisibility(View.VISIBLE);
        }else{
            tvCostantiniM.setVisibility(View.GONE);
        }

        if(resultCode.costanini_m_ok > 0){
            tvCostantiniM_ok.setVisibility(View.VISIBLE);
        }else{
            tvCostantiniM_ok.setVisibility(View.GONE);
        }

        if(resultCode.lee_hj > 0){
            tvLeeHJ.setVisibility(View.VISIBLE);
        }else{
            tvLeeHJ.setVisibility(View.GONE);
        }


        if(resultCode.lee_hj_main > 0){
            tvLeeHJ_main.setVisibility(View.VISIBLE);
        }else{
            tvLeeHJ_main.setVisibility(View.GONE);
        }


        if(resultCode.gokalp_g > 0){
            tvGokalpG.setVisibility(View.VISIBLE);
        }else{
            tvGokalpG.setVisibility(View.GONE);
        }


        if(resultCode.gokalp_g_ok > 0){
            tvGokalpG_ok.setVisibility(View.VISIBLE);
        }else{
            tvGokalpG_ok.setVisibility(View.GONE);
        }


        if(resultCode.lvguorong > 0){
            tvLvGuorong.setVisibility(View.VISIBLE);
        }else{
            tvLvGuorong.setVisibility(View.GONE);
        }

        notifyDataSetChanged();

    }





}
