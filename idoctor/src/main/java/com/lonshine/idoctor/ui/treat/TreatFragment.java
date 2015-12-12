package com.lonshine.idoctor.ui.treat;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lonshine.idoctor.R;
import com.lonshine.idoctor.model.TreatProcess;
import com.lonshine.idoctor.widget.CheckViewGroup;
import com.lonshine.lib.base.activity.BaseFragment;
import com.lonshine.lib.view.checkbox.CheckableView;

/**
 * Created by lonshine on 15/12/7 下午11:17.
 */
public class TreatFragment extends BaseFragment {

    public final static String EXTRA_INDEX = "EXTRA_INDEX";
    public final static String EXTRA_PROCESS = "EXTRA_PROCESS";

    TextView tvProcessTitle;
    TextView tvProcessName;
    TextView tvProcessDescribe;
    CheckViewGroup cvgItemProcess;


    private int mIndex;
    private TreatProcess mTreatProcess;
    private PagerAdapterItemCheckListener mPagerAdapterItemCheckListener;

    public static TreatFragment newInstance(int index,TreatProcess treatProcess){
        TreatFragment treatFragment = new TreatFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(EXTRA_INDEX, index);
        bundle.putSerializable(EXTRA_PROCESS,treatProcess);
        treatFragment.setArguments(bundle);
        return treatFragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        if(bundle != null){
            mIndex = bundle.getInt(EXTRA_INDEX);
            mTreatProcess = (TreatProcess) bundle.getSerializable(EXTRA_PROCESS);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.item_layout_treat_process, null);

        tvProcessTitle = (TextView) layout.findViewById(R.id.tvProcessTitle);
        tvProcessName = (TextView) layout.findViewById(R.id.tvProcessName);
        tvProcessDescribe = (TextView) layout.findViewById(R.id.tvProcessDescribe);
        cvgItemProcess = (CheckViewGroup) layout.findViewById(R.id.cvgItemProcess);


        return layout;
    }


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if(mTreatProcess == null){
            return;
        }

        setView();

    }

    private void setView() {

        cvgItemProcess.setTreatProcess(mTreatProcess);
        if (mTreatProcess.is_child > 0) {
            tvProcessTitle.setText(mTreatProcess.process_index + " - " + mTreatProcess.parent_name);
            tvProcessName.setText("(" + mTreatProcess.child_index + ")" + mTreatProcess.name);
            tvProcessName.setVisibility(View.VISIBLE);
        } else {
            tvProcessTitle.setText(mTreatProcess.process_index + " - " + mTreatProcess.name);
            tvProcessName.setVisibility(View.GONE);
        }

        if (TextUtils.isEmpty(mTreatProcess.describe)) {
            tvProcessDescribe.setVisibility(View.GONE);
        } else {
            tvProcessDescribe.setText(mTreatProcess.describe);
        }

        cvgItemProcess.setOnCheckedChangeListener(new CheckViewGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CheckViewGroup group, CheckableView checkableView, boolean isCheck) {
                if(mPagerAdapterItemCheckListener != null){
                    mPagerAdapterItemCheckListener.onCheckedChanged(group,checkableView,isCheck,mIndex);
                }
            }
        });
    }


    public void setPagerAdapterItemCheckListener(PagerAdapterItemCheckListener l) {
        mPagerAdapterItemCheckListener = l;
    }


}
