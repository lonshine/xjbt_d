package com.lonshine.idoctor.treat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lonshine.idoctor.R;
import com.lonshine.idoctor.data.DataString;
import com.lonshine.idoctor.data.TreatDataManager;
import com.lonshine.idoctor.model.TreatCheckable;
import com.lonshine.idoctor.model.TreatProcess;
import com.lonshine.idoctor.model.TreatProject;
import com.lonshine.idoctor.model.TreatResultCode;
import com.lonshine.idoctor.widget.CheckViewGroup;
import com.lonshine.idoctor.widget.TreatCheckView;
import com.lonshine.lib.activity.BaseFragmentActivity;
import com.lonshine.lib.data.gson.GsonManager;
import com.lonshine.lib.view.checkbox.CheckableView;

import java.util.concurrent.Callable;

import bolts.Continuation;
import bolts.Task;
import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by lonshine on 15/11/11 下午9:52.
 */
public class TreatActivity extends BaseFragmentActivity {

    private final static String TAG = "TreatActivity";

    TreatProject mTreatProject;
    TrearFragmentAdapter mAdapter;


    @InjectView(R.id.vpTreat)
    ViewPager vpTreat;
    @InjectView(R.id.tvLeft)
    TextView tvLeft;
    @InjectView(R.id.tvRight)
    TextView tvRight;
    @InjectView(R.id.tvFinish)
    TextView tvFinish;
    @InjectView(R.id.rlBottomBtn)
    LinearLayout rlBottomBtn;
    private View lTest;


    public static void start(Context context) {
        Intent intent = new Intent(context, TreatActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat);
        ButterKnife.inject(this);
    }


    @Override
    protected void initData() {

    }


    @Override
    protected void initView() {
        ButterKnife.inject(this);

        mAdapter = new TrearFragmentAdapter(getSupportFragmentManager());
        vpTreat.setAdapter(mAdapter);
        initTestUI();

        Task.callInBackground(new Callable<TreatProject>() {
            @Override
            public TreatProject call() throws Exception {
                TreatProject treatProject = GsonManager.get().fromJson(DataString.JSON, TreatProject.class);
                return treatProject;
            }
        }).continueWithTask(new Continuation<TreatProject, Task<Object>>() {
            @Override
            public Task<Object> then(Task<TreatProject> task) throws Exception {

                if (task.isFaulted()) {
                    Log.e(TAG, "mTreatProject parse failed.");
                    return null;
                }

                mTreatProject = task.getResult();
                TreatDataManager.get().setTreatProject(mTreatProject);
                updateUI();

                return null;
            }
        }, Task.UI_THREAD_EXECUTOR);


    }

    private void updateUI() {
        getBaseTitleBar().setTitleText("" + mTreatProject.name);

        mAdapter.setTreatProject(mTreatProject);
        mAdapter.setPagerAdapterItemCheckListener(new PagerAdapterItemCheckListener() {
            @Override
            public void onCheckedChanged(CheckViewGroup group, CheckableView checkableView, boolean isCheck, int position) {
                TreatCheckable tc = ((TreatCheckView) checkableView).getTreatCheckable();

                TreatProcess treatProcess = null;
                if (position < mTreatProject.data.size()) {
                    treatProcess = mTreatProject.data.get(position);
                }

                tc.isChecked = isCheck;
                updateData(isCheck, tc, treatProcess);
            }
        });


        vpTreat.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                resetTestUI();
                TreatProcess treatProcess = mTreatProject.data.get(position);
                updateTestResult(treatProcess.treat_result_code);


                if (position == 0) {
                    showOnlyRightBtn();
                } else if (position == mTreatProject.data.size() - 1) {
                    shoFinishBtn();
                } else {
                    showLeftRightBtn();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mAdapter.notifyDataSetChanged();


        showOnlyRightBtn();
        tvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int page = vpTreat.getCurrentItem() - 1 < 0 ? 0 : vpTreat.getCurrentItem() - 1;
                vpTreat.setCurrentItem(page);
            }
        });
        tvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int page = vpTreat.getCurrentItem() + 1 > mAdapter.getCount() - 1 ? mAdapter.getCount() - 1 : vpTreat.getCurrentItem() + 1;
                vpTreat.setCurrentItem(page);
            }
        });
        tvFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TreatResultActivity.start(TreatActivity.this,mTreatProject);
            }
        });


    }


    private void showLeftRightBtn(){
        tvLeft.setVisibility(View.VISIBLE);
        tvRight.setVisibility(View.VISIBLE);
        tvFinish.setVisibility(View.GONE);
    }

    private void showOnlyRightBtn(){
        tvLeft.setVisibility(View.GONE);
        tvRight.setVisibility(View.VISIBLE);
        tvFinish.setVisibility(View.GONE);
    }

    private void shoFinishBtn(){
        tvLeft.setVisibility(View.VISIBLE);
        tvRight.setVisibility(View.GONE);
        tvFinish.setVisibility(View.VISIBLE);
    }






    private void updateData(boolean isCheck, TreatCheckable tc, TreatProcess treatProcess) {
        if (tc != null && treatProcess != null) {
            if (isCheck) {
                treatProcess.treat_result_code.costanini_m += tc.treat_result_code.costanini_m;
            } else {
                if (treatProcess.treat_result_code.costanini_m > 0) {
                    treatProcess.treat_result_code.costanini_m -= tc.treat_result_code.costanini_m;
                }
            }

            if (isCheck) {
                treatProcess.treat_result_code.costanini_m_ok += tc.treat_result_code.costanini_m_ok;
            } else {
                if (treatProcess.treat_result_code.costanini_m_ok > 0) {
                    treatProcess.treat_result_code.costanini_m_ok -= tc.treat_result_code.costanini_m_ok;
                }
            }

            if (isCheck) {
                treatProcess.treat_result_code.lee_hj += tc.treat_result_code.lee_hj;
            } else {
                if (treatProcess.treat_result_code.lee_hj > 0) {
                    treatProcess.treat_result_code.lee_hj -= tc.treat_result_code.lee_hj;
                }
            }


            if (isCheck) {
                treatProcess.treat_result_code.lee_hj_main += tc.treat_result_code.lee_hj_main;
            } else {
                if (treatProcess.treat_result_code.lee_hj_main > 0) {
                    treatProcess.treat_result_code.lee_hj_main -= tc.treat_result_code.lee_hj_main;
                }
            }


            if (isCheck) {
                treatProcess.treat_result_code.gokalp_g += tc.treat_result_code.gokalp_g;
            } else {
                if (treatProcess.treat_result_code.gokalp_g > 0) {
                    treatProcess.treat_result_code.gokalp_g -= tc.treat_result_code.gokalp_g;
                }
            }


            if (isCheck) {
                treatProcess.treat_result_code.gokalp_g_ok += tc.treat_result_code.gokalp_g_ok;
            } else {
                if (treatProcess.treat_result_code.gokalp_g_ok > 0) {
                    treatProcess.treat_result_code.gokalp_g_ok -= tc.treat_result_code.gokalp_g_ok;
                }
            }


            if (isCheck) {
                treatProcess.treat_result_code.lvguorong += tc.treat_result_code.lvguorong;
            } else {
                if (treatProcess.treat_result_code.lvguorong > 0) {
                    treatProcess.treat_result_code.lvguorong -= tc.treat_result_code.lvguorong;
                }
            }
            mAdapter.notifyDataSetChanged();

            updateTestResult(treatProcess.treat_result_code);
        }
    }


    TextView tvLeeHJ_main;
    TextView tvLeeHJ;
    TextView tvCostantiniM_ok;
    TextView tvCostantiniM;
    TextView tvGokalpG_ok;
    TextView tvGokalpG;
    TextView tvLvGuorong;

    private void initTestUI() {
        findTestUI();
//        resetTestUI();

        lTest.setVisibility(View.GONE);
        getBaseTitleBar().getTitleTextView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (lTest.getVisibility() == View.VISIBLE) {
                    lTest.setVisibility(View.GONE);
                } else {
                    lTest.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
    }

    private void resetTestUI() {
        tvCostantiniM.setTextColor(getResources().getColor(R.color.black));
        tvCostantiniM_ok.setTextColor(getResources().getColor(R.color.black));
        tvLeeHJ.setTextColor(getResources().getColor(R.color.black));
        tvLeeHJ_main.setTextColor(getResources().getColor(R.color.black));
        tvGokalpG.setTextColor(getResources().getColor(R.color.black));
        tvGokalpG_ok.setTextColor(getResources().getColor(R.color.black));
        tvLvGuorong.setTextColor(getResources().getColor(R.color.black));
    }

    private void findTestUI() {
        lTest = findViewById(R.id.lTest);
        tvLeeHJ_main = (TextView) findViewById(R.id.tvLeeHJ_main);
        tvLeeHJ = (TextView) findViewById(R.id.tvLeeHJ);
        tvCostantiniM_ok = (TextView) findViewById(R.id.tvCostantiniM_ok);
        tvCostantiniM = (TextView) findViewById(R.id.tvCostantiniM);
        tvGokalpG_ok = (TextView) findViewById(R.id.tvGokalpG_ok);
        tvGokalpG = (TextView) findViewById(R.id.tvGokalpG);
        tvLvGuorong = (TextView) findViewById(R.id.tvLvGuorong);
    }

    public void updateTestResult(TreatResultCode resultCode) {

        if (resultCode.costanini_m > 0) {
            tvCostantiniM.setTextColor(getResources().getColor(R.color.red));
//            tvGokalpG_ok.setText("");
        } else {
            tvCostantiniM.setTextColor(getResources().getColor(R.color.black));
        }

        if (resultCode.costanini_m_ok > 0) {
            tvCostantiniM_ok.setTextColor(getResources().getColor(R.color.red));
//            tvGokalpG_ok.setText("");
        } else {
            tvCostantiniM_ok.setTextColor(getResources().getColor(R.color.black));
        }

        if (resultCode.lee_hj > 0) {
            tvLeeHJ.setTextColor(getResources().getColor(R.color.red));
//            tvGokalpG_ok.setText("");
        } else {
            tvLeeHJ.setTextColor(getResources().getColor(R.color.black));
        }


        if (resultCode.lee_hj_main > 0) {
            tvLeeHJ_main.setTextColor(getResources().getColor(R.color.red));
//            tvGokalpG_ok.setText("");
        } else {
            tvLeeHJ_main.setTextColor(getResources().getColor(R.color.black));
        }


        if (resultCode.gokalp_g > 0) {
            tvGokalpG.setTextColor(getResources().getColor(R.color.red));
//            tvGokalpG_ok.setText("");
        } else {
            tvGokalpG.setTextColor(getResources().getColor(R.color.black));
        }


        if (resultCode.gokalp_g_ok > 0) {
            tvGokalpG_ok.setTextColor(getResources().getColor(R.color.red));
//            tvGokalpG_ok.setText("");
        } else {
            tvGokalpG_ok.setTextColor(getResources().getColor(R.color.black));
        }


        if (resultCode.lvguorong > 0) {
            tvLvGuorong.setTextColor(getResources().getColor(R.color.red));
//            tvGokalpG_ok.setText("");

        } else {
            tvLvGuorong.setTextColor(getResources().getColor(R.color.black));
        }


    }


}
