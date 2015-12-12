package com.lonshine.idoctor.ui.treat;

import com.lonshine.idoctor.widget.CheckViewGroup;
import com.lonshine.lib.view.checkbox.CheckableView;

/**
 * Created by lonshine on 15/11/28 上午12:12.
 */
public interface PagerAdapterItemCheckListener {

     public void onCheckedChanged(CheckViewGroup group, CheckableView checkableView, boolean isCheck,int position);

}
