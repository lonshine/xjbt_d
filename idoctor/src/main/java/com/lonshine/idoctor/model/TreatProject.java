package com.lonshine.idoctor.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lonshine on 15/11/15 下午2:52.
 */
public class TreatProject implements Serializable{

    public final static long serialVersionUID = 1l;

    public long id;
    public String name;
    public ArrayList<TreatProcess> data;




    public TreatResultCode getTreatResultCount(){
        TreatResultCode resultCount = new TreatResultCode();
        if(data != null && data.size() > 0){
            for (int i = 0; i < data.size(); i++) {
                TreatProcess treatProcess = data.get(i);

                if(treatProcess.treat_result_code != null){
                    resultCount.costanini_m += treatProcess.treat_result_code.costanini_m;
                    resultCount.costanini_m_ok += treatProcess.treat_result_code.costanini_m_ok;
                    resultCount.gokalp_g += treatProcess.treat_result_code.gokalp_g;
                    resultCount.gokalp_g_ok += treatProcess.treat_result_code.gokalp_g_ok;
                    resultCount.lee_hj += treatProcess.treat_result_code.lee_hj;
                    resultCount.lee_hj_main += treatProcess.treat_result_code.lee_hj_main;
                    resultCount.lvguorong += treatProcess.treat_result_code.lvguorong;
                }
            }
        }
        return resultCount;
    }





    @Override
    public String toString() {
        return "TreatProject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", treat_process_list=" + data +
                '}';
    }
}
