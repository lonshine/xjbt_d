package com.lonshine.idoctor.model;

import java.util.ArrayList;

/**
 * Created by lonshine on 15/11/15 下午1:27.
 */
public class TreatProcess {

    public long id;
    public String name;
    public int checkable;
    public int multi_check;
    public int is_child;

    public String describe;
    public long parent_id;
    public String parent_name;

    public TreatProcessParent parent;

    public ArrayList<TreatCheckable> check_list;
//    public ArrayList<TreatCheckable> check_result_list;

    public TreatResultCode treat_result_code;


    @Override
    public String toString() {
        return "TreatProcess{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", checkable=" + checkable +
                ", multi_check=" + multi_check +
                ", is_child=" + is_child +
                ", describe='" + describe + '\'' +
                ", parent_id=" + parent_id +
                ", parent_name='" + parent_name + '\'' +
                ", parent=" + parent +
                ", check_list=" + check_list +
                ", treat_result_code=" + treat_result_code +
                '}';
    }
}
