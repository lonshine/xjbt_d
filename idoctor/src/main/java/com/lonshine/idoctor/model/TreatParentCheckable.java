package com.lonshine.idoctor.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by lonshine on 15/11/15 上午12:57.
 */
public class TreatParentCheckable extends  TreatCheckable implements Serializable {

    public final static long serialVersionUID = 1l;

    public int child_count;
    public ArrayList<Long> child_id_list;

}
