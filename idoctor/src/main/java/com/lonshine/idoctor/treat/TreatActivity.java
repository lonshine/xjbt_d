package com.lonshine.idoctor.treat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.lonshine.idoctor.R;
import com.lonshine.idoctor.data.DataString;
import com.lonshine.idoctor.model.TreatProject;
import com.lonshine.lib.activity.BaseFragmentActivity;
import com.lonshine.lib.data.gson.GsonManager;

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
    ViewPagerAdapter mAdapter;



    @InjectView(R.id.vpTreat)
    ViewPager vpTreat;


    public static void start(Context context) {
        Intent intent = new Intent(context, TreatActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat);
    }


    @Override
    protected void initData() {

    }


    @Override
    protected void initView() {
        ButterKnife.inject(this);

        mAdapter = new ViewPagerAdapter(TreatActivity.this);
        vpTreat.setAdapter(mAdapter);


        Task.callInBackground(new Callable<TreatProject>() {
            @Override
            public TreatProject call() throws Exception {
                TreatProject treatProject = GsonManager.get().fromJson(DataString.JSON, TreatProject.class);
                return treatProject;
            }
        }).continueWithTask(new Continuation<TreatProject, Task<Object>>() {
            @Override
            public Task<Object> then(Task<TreatProject> task) throws Exception {

                if(task.isFaulted()){
                    Log.e(TAG,"mTreatProject parse failed.");
                    return null;
                }

                mTreatProject = task.getResult();
                updateUI();

                return null;
            }
        },Task.UI_THREAD_EXECUTOR);
    }

    private void updateUI() {
        getBaseTitleBar().setTitleText("" + mTreatProject.name);
        mAdapter.setTreatProject(mTreatProject);
        mAdapter.notifyDataSetChanged();
    }
}
