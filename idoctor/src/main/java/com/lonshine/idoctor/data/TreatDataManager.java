package com.lonshine.idoctor.data;

import com.lonshine.idoctor.model.TreatCheckable;
import com.lonshine.idoctor.model.TreatProcess;
import com.lonshine.idoctor.model.TreatProject;

import java.util.ArrayList;

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


    public void updateWhileCheckChanged(TreatProject treatProject,TreatCheckable tc,boolean isCheck,int position){

        mTreatProject = treatProject;

        if(mTreatProject == null || mTreatProject.data == null || position > mTreatProject.data.size() - 1){
            return;
        }

        TreatProcess treatProcess = mTreatProject.data.get(position);

        if(treatProcess == null){
            return;
        }


        ArrayList<TreatCheckable> check_list = treatProcess.check_list;

        for (int i = 0; i < check_list.size(); i++) {

            TreatCheckable treatCheckable = check_list.get(i);

            if(isCheck){
                // 变化的子item
                if(tc.is_child > 0){
                    if(treatCheckable.id == tc.parent_id){
                        //父item跟着勾选
                        treatCheckable.isChecked = true;
                    }else{
                        // 其他item去除勾选
                        treatCheckable.isChecked = false;
                    }

                }else{
                    // 变化的是父item,则其他item去除勾选
                    treatCheckable.isChecked = false;
                }

            }else{
                // 变化的子item
                if(tc.is_child > 0){
                    //不做处理
                }else{
                    // 变化的是父item,则他的子item去除勾选
                    if(treatCheckable.parent_id == tc.id){
                        treatCheckable.isChecked = false;
                    }
                }
            }




        }




    }

}
