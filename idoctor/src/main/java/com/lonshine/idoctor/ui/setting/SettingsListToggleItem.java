package com.lonshine.idoctor.ui.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lonshine.idoctor.R;
import com.sevenheaven.iosswitch.ShSwitchView;

/**
 * Created by lonshine on 15/12/12 下午11:01.
 */
public class SettingsListToggleItem extends RelativeLayout {

    TextView tvTitle;
    ShSwitchView svToggle;
    int          mExactlyHeight;

    public SettingsListToggleItem(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.item_settings_list_toggle, this, true);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        svToggle = (ShSwitchView) findViewById(R.id.svToggle);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.SettingsListItem,
                0, 0);
        String title = typedArray.getString(R.styleable.SettingsListItem_si_title);
        setTitle(title);
        typedArray.recycle();

        int padding = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        setPadding(padding, 0, padding, 0); //左右10dp

        mExactlyHeight = getResources().getDimensionPixelSize(R.dimen.settings_item_height);
        setBackgroundResource(R.drawable.bg_btn_rectangle_mid);
    }

    public void setTitle(int resId) {
        tvTitle.setText(resId);
    }
    public void setTitle(String title) {
        tvTitle.setText(title);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //重载onMeasure， 限定高度。
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(mExactlyHeight, MeasureSpec.EXACTLY));
    }

    public void setOnSwitchStateChangeListener(ShSwitchView.OnSwitchStateChangeListener onSwitchStateChangeListener) {
        svToggle.setOnSwitchStateChangeListener(onSwitchStateChangeListener);
    }

    public void setOn(boolean isOn) {
        svToggle.setOn(isOn);
    }

    public void setOn(boolean isOn, boolean animate) {
        svToggle.setOn(isOn, animate);
    }
}