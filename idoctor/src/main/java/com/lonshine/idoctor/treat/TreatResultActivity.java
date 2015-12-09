package com.lonshine.idoctor.treat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.lonshine.idoctor.R;
import com.lonshine.idoctor.model.TreatProject;
import com.lonshine.idoctor.model.TreatResultCode;
import com.lonshine.lib.activity.BaseFragmentActivity;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lonshine on 15/12/9 下午9:01.
 */
public class TreatResultActivity extends BaseFragmentActivity {

    private final static String EXTRA_TREAT_RESULT_TP = "EXTRA_TREAT_RESULT_TP";
    @InjectView(R.id.tvLeeHJ)
    TextView tvLeeHJ;
    @InjectView(R.id.tvCostantiniM)
    TextView tvCostantiniM;
    @InjectView(R.id.tvGokalpG)
    TextView tvGokalpG;
    @InjectView(R.id.tvLvGuorong)
    TextView tvLvGuorong;


    private TreatProject mTreatProject;


    public static void start(Activity activity, TreatProject treatProject) {
        Intent intent = new Intent(activity, TreatResultActivity.class);
        intent.putExtra(EXTRA_TREAT_RESULT_TP, treatProject);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
//        activity.overridePendingTransition(R.anim.in_from_bottom,0);
    }


    @Override
    public void finish() {
//        overridePendingTransition(0, R.anim.out_to_bottom);
        super.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat_result);
        ButterKnife.inject(this);
        setDataView();
    }


    @Override
    protected void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mTreatProject = (TreatProject) intent.getSerializableExtra(EXTRA_TREAT_RESULT_TP);
        }
    }

    @Override
    protected void initView() {
        getBaseTitleBar().setTitleText("检查结果");
        getBaseTitleBar().hiddenLeftTextView();
    }

    private void setDataView() {
        if(mTreatProject == null){
            return;
        }

        TreatResultCode treatResultCount = mTreatProject.getTreatResultCount();


        if(treatResultCount.lee_hj_main >= 2){
            tvLeeHJ.setText("BI-RADS5类: ≥2主要征象");
            tvLeeHJ.setTextColor(getResources().getColor(R.color.red));
        }else if(treatResultCount.lee_hj_main >= 1){
            tvLeeHJ.setText("BI-RADS4类: (C) ≥1主要征象");
            tvLeeHJ.setTextColor(getResources().getColor(R.color.red));
        }else if(treatResultCount.lee_hj >= 3){
            tvLeeHJ.setText("BI-RADS4类: (B) ≥3次要征象");
            tvLeeHJ.setTextColor(getResources().getColor(R.color.pink));
        }else if(treatResultCount.lee_hj >= 1){
            tvLeeHJ.setText("BI-RADS4类: (A) ≤2次要征象");
            tvLeeHJ.setTextColor(getResources().getColor(R.color.pink));
        }else{
            tvLeeHJ.setText("没有可疑征象");
            tvLeeHJ.setTextColor(getResources().getColor(R.color.gray));
        }

        int c = treatResultCount.costanini_m + treatResultCount.costanini_m_ok;
        if(c >= 3){
            tvCostantiniM.setText("BI-RADS5类: ≥3项");
            tvCostantiniM.setTextColor(getResources().getColor(R.color.red));
        }else{
            tvCostantiniM.setText("BI-RADS4类: ≤2项");
            tvCostantiniM.setTextColor(getResources().getColor(R.color.pink));
        }


        int g = treatResultCount.gokalp_g + treatResultCount.gokalp_g_ok;
        if(g >= 2){
            tvGokalpG.setText("BI-RADS5类: ≥2项");
            tvGokalpG.setTextColor(getResources().getColor(R.color.red));
        }else if(g >= 1){
            tvGokalpG.setText("BI-RADS4类: 1项");
            tvGokalpG.setTextColor(getResources().getColor(R.color.pink));
        }else{
            tvGokalpG.setText("BI-RADS3类: 无恶性征象");
            tvGokalpG.setTextColor(getResources().getColor(R.color.gray));
        }



        if(treatResultCount.lvguorong > 3){
            tvLvGuorong.setText("BI-RADS5类: >3项");
            tvLvGuorong.setTextColor(getResources().getColor(R.color.red));
        }else if(treatResultCount.lvguorong == 3){
            tvLvGuorong.setText("BI-RADS4类: (C) 3项");
            tvLvGuorong.setTextColor(getResources().getColor(R.color.red));
        }else if(treatResultCount.lvguorong == 2){
            tvLvGuorong.setText("BI-RADS4类: (B) 2项");
            tvLvGuorong.setTextColor(getResources().getColor(R.color.pink));
        }else if(treatResultCount.lvguorong == 1){
            tvLvGuorong.setText("BI-RADS4类: (A) 1项");
            tvLvGuorong.setTextColor(getResources().getColor(R.color.pink));
        }else{
            tvLvGuorong.setText("没有可疑征象");
            tvLvGuorong.setTextColor(getResources().getColor(R.color.gray));
        }

    }
}
