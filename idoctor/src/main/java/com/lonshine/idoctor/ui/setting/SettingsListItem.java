package com.lonshine.idoctor.ui.setting;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lonshine.idoctor.R;

/**
 * Created by lonshine on 15/12/12 下午11:00.
 */
public class SettingsListItem extends RelativeLayout {

    ImageView ivArrow;
    TextView tvTitle, tvSubTitle;
    Button btnBind;
    int    mExactlyHeight;

    public SettingsListItem(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.item_settings_list, this, true);
        ivArrow = (ImageView) findViewById(R.id.iconArrow);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvSubTitle = (TextView) findViewById(R.id.tvSubTitle);
        btnBind = (Button) findViewById(R.id.btnBind);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.SettingsListItem,
                0, 0);
        String title = typedArray.getString(R.styleable.SettingsListItem_si_title);
        String subTitle = typedArray.getString(R.styleable.SettingsListItem_si_sub_title);
        boolean show_arrow = typedArray.getBoolean(R.styleable.SettingsListItem_si_show_arrow, true);
        boolean show_btn = typedArray.getBoolean(R.styleable.SettingsListItem_si_show_btn, false);
        int paddingToRight = typedArray.getDimensionPixelSize(R.styleable.SettingsListItem_si_sub_title_paddingToRight, 0);

        setTitle(title);
        setSubTitle(subTitle);
        setTvSubTitlePaddingToRight(paddingToRight);

        if (!show_arrow) {
            //这里隐藏，采用一个像素隐藏，以使SubTitle继续有相对位置。
//            LayoutParams params = (LayoutParams) ivArrow.getLayoutParams();
//            params.width = 1;
//            params.height = 1;
            setIvArrowVisibility(GONE);
        }
        if (show_btn) {
            setBtnBindVisibility(VISIBLE);
            setIvArrowVisibility(GONE);
        }
        typedArray.recycle();

        int padding = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 10, getResources().getDisplayMetrics());
        setPadding(padding, 0, padding, 0); //左右10dp

        mExactlyHeight = getResources().getDimensionPixelSize(R.dimen.settings_item_height);
        setBackgroundResource(R.drawable.bg_item_treatcheck_n);
    }

    public void setTitle(int resId) {
        tvTitle.setText(resId);
    }

    public void setTitle(String title) {
        tvTitle.setText(title);
    }

    public void setSubTitle(int resId) {
        tvSubTitle.setText(resId);
    }

    public void setSubTitle(String title) {
        tvSubTitle.setText(title);
    }

    public void setIvArrowVisibility(int visibility) {
        ivArrow.setVisibility(visibility);
    }

    public void setBtnBindVisibility(int visibility) {
        btnBind.setVisibility(visibility);
    }

    public Button getBtnBind() {
        return btnBind;
    }

    public void setTvSubTitlePaddingToRight(int paddingToRight) {
        tvSubTitle.setPadding(0, 0, paddingToRight, 0);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //重载onMeasure， 限定高度。
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(mExactlyHeight, MeasureSpec.EXACTLY));
    }
}