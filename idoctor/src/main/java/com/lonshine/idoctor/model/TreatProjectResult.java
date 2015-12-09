package com.lonshine.idoctor.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 */
public class TreatProjectResult implements Serializable{

    public final static long serialVersionUID = 1l;

    public long id;
    public String name;
    public ArrayList<TreatProcess> data;

    public TreatResultCode treatResultCount = new TreatResultCode();



    @Override
    public String toString() {
        return "TreatProject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", treat_process_list=" + data +
                '}';
    }
}
