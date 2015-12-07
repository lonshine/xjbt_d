package com.lonshine.idoctor.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lonshine on 15/11/15 上午12:57.
 */
public class TreatCheckable implements Serializable {

    public final static long serialVersionUID = 1l;

    public long id;
    public String name;

    public TreatResultCode treat_result_code;
    public int is_child;

    //parent
    public int child_count;
    public ArrayList<Long> child_id_list;

    //child
    public long parent_id;
    public String parent_name;


    public boolean isChecked;

    @Override
    public String toString() {
        return "TreatCheckable{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", treat_result_code=" + treat_result_code +
                ", is_child=" + is_child +
                ", child_count=" + child_count +
                ", child_id_list=" + child_id_list +
                ", parent_id=" + parent_id +
                ", parent_name='" + parent_name + '\'' +
                '}';
    }
}
