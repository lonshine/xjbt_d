package com.lonshine.idoctor.model;

import java.io.Serializable;

/**
 * Created by lonshine on 15/11/17 下午11:15.
 */
public class TreatProcessParent implements Serializable{

    public final static long serialVersionUID = 1l;
    public long id;
    public String name;
    public int checkable;
    public int multi_check;
    public String describe;

}
