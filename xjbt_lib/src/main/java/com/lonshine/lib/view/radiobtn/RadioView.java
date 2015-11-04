package com.lonshine.lib.view.radiobtn;

/**
 * Created by lonshine on 15/11/4 下午9:50.
 */

import android.content.Context;
import android.util.AttributeSet;

import com.lonshine.lib.view.checkbox.CheckableView;

/**
 * Created by lonshine on 15/10/8 下午3:13.
 */
public class RadioView extends CheckableView {
    public RadioView(Context context) {
        super(context);
    }

    public RadioView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void toggle() {
        if (!mChecked) {
            super.toggle();
        }
    }
}
