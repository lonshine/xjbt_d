package com.lonshine.idoctor.model;

import java.io.Serializable;

/**
 * Created by lonshine on 15/11/15 上午1:07.
 */
public class TreatResultCode implements Serializable {

    public final static long serialVersionUID = 1l;

    public int lee_hj;
    public int lee_hj_main;
    public int costanini_m;
    public int gokalp_g;
    public int lvguorong;
    public int gokalp_g_ok;
    public int costanini_m_ok;


    @Override
    public String toString() {
        return "TreatResultCode{" +
                "lee_hj=" + lee_hj +
                ", lee_hj_main=" + lee_hj_main +
                ", costanini_m=" + costanini_m +
                ", gokalp_g=" + gokalp_g +
                ", lvguorong=" + lvguorong +
                ", gokalp_g_ok=" + gokalp_g_ok +
                ", costanini_m_ok=" + costanini_m_ok +
                '}';
    }
}
