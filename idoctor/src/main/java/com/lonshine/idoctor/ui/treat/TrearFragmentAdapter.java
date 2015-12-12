package com.lonshine.idoctor.ui.treat;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.lonshine.idoctor.model.TreatProcess;
import com.lonshine.idoctor.model.TreatProject;

import java.util.ArrayList;

/**
 * Created by lonshine on 15/12/7 下午11:44.
 */
public class TrearFragmentAdapter extends FragmentPagerAdapter {

    ArrayList<TreatProcess> mList;
    TreatProject mTreatProject;
    private PagerAdapterItemCheckListener mPagerAdapterItemCheckListener;

    public TrearFragmentAdapter(FragmentManager fm) {
        super(fm);
    }


    public void setTreatProject(TreatProject treatProject) {
        mTreatProject = treatProject;
        if (mTreatProject != null && mTreatProject.data != null && mTreatProject.data.size() > 0) {
            mList = mTreatProject.data;
        } else {
            mList = new ArrayList<TreatProcess>();
        }
    }


    @Override
    public Fragment getItem(int position) {
        if (mTreatProject != null && mTreatProject.data != null && position < mTreatProject.data.size()) {
            TreatFragment treatFragment = TreatFragment.newInstance(position,mTreatProject.data.get(position));
            treatFragment.setPagerAdapterItemCheckListener(mPagerAdapterItemCheckListener);
            return treatFragment;
        }
        return new TreatFragment();
    }

    @Override
    public int getCount() {
        if (mTreatProject != null && mTreatProject.data != null && mTreatProject.data.size() > 0) {
            return mTreatProject.data.size();
        }
        return 0;
    }

    public void setPagerAdapterItemCheckListener(PagerAdapterItemCheckListener l) {
        mPagerAdapterItemCheckListener = l;
    }


}
