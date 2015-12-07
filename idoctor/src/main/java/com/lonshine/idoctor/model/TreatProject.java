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

    @Override
    public String toString() {
        return "TreatProject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", treat_process_list=" + data +
                '}';
    }
}
