package com.lonshine.idoctor.data;

import com.lonshine.idoctor.model.TreatProject;

/**
 * Created by lonshine on 15/11/29 下午10:27.
 */
public class TreatDataManager {

    private TreatDataManager(){

    }

    private  static TreatDataManager sManager = new TreatDataManager();

    public static TreatDataManager get(){
        return sManager;
    }

    TreatProject mTreatProject;

    public void setTreatProject(TreatProject treatProject){
        mTreatProject = treatProject;
    }

    public TreatProject getTreatProject(){
        return mTreatProject;
    }



}
