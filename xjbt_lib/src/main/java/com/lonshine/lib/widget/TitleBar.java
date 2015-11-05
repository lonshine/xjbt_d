package com.lonshine.lib.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lonshine.lib.R;

/**
 * Created by lonshine on 15/11/4 下午10:40.
 */
public class TitleBar extends RelativeLayout implements View.OnClickListener {

    private TextView mTitleTv;
    private TextView mLeftTv;
    private TextView mRightTv;

    private ImageView mDivideLine;

    private TitleBarListener mTitleBarListener;

    public TitleBar(Context context) {
        this(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.view_titlebar, this);
        initView();
        setListener();
        initAttrs(context, attrs);
    }

    private void initView() {
        mTitleTv = (TextView) findViewById(R.id.titlebar_title);
        mLeftTv = (TextView) findViewById(R.id.titlebar_left);
        mRightTv = (TextView) findViewById(R.id.titlebar_right);
        mDivideLine = (ImageView) findViewById(R.id.titlebar_divideline);
    }

    private void setListener() {
        mTitleTv.setOnClickListener(this);
        mLeftTv.setOnClickListener(this);
        mRightTv.setOnClickListener(this);
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
        final int N = typedArray.getIndexCount();
        for (int i = 0; i < N; i++) {
            initAttr(typedArray.getIndex(i), typedArray);
        }
        typedArray.recycle();
    }

    protected void initAttr(int attr, TypedArray typedArray) {

        if(attr == R.styleable.TitleBar_titlebar_leftText){
            setLeftText(typedArray.getText(attr));
        }
        if(attr == R.styleable.TitleBar_titlebar_leftText){
            setTitleText(typedArray.getText(attr));
        }
        if(attr == R.styleable.TitleBar_titlebar_rightText){
            setRightText(typedArray.getText(attr));
        }

        if(attr == R.styleable.TitleBar_titlebar_leftDrawable){
            setLeftDrawable(typedArray.getDrawable(attr));
        }

        if(attr == R.styleable.TitleBar_titlebar_titleDrawable){
            setTitleDrawable(typedArray.getDrawable(attr));
        }

        if(attr == R.styleable.TitleBar_titlebar_rightDrawable){
            setRightDrawable(typedArray.getDrawable(attr));
        }

        if(attr == R.styleable.TitleBar_titlebar_leftAndRightTextSize){
            int textSize = typedArray.getDimensionPixelSize(attr, sp2px(getContext(), 12));
            mLeftTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
            mRightTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        }

        if(attr == R.styleable.TitleBar_titlebar_titleTextSize){
            mTitleTv.setTextSize(TypedValue.COMPLEX_UNIT_PX, typedArray.getDimensionPixelSize(attr, sp2px(getContext(), 16)));
        }

        if(attr == R.styleable.TitleBar_titlebar_leftAndRightTextColor){
            mLeftTv.setTextColor(typedArray.getColorStateList(attr));
            mRightTv.setTextColor(typedArray.getColorStateList(attr));
        }

        if(attr == R.styleable.TitleBar_titlebar_titleTextColor){
            mTitleTv.setTextColor(typedArray.getColorStateList(attr));
        }

        if(attr == R.styleable.TitleBar_titlebar_titleDrawablePadding){
            mTitleTv.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 5)));
        }

        if(attr == R.styleable.TitleBar_titlebar_leftDrawablePadding){
            mLeftTv.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 5)));
        }

        if(attr == R.styleable.TitleBar_titlebar_rightDrawablePadding){
            mRightTv.setCompoundDrawablePadding(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 5)));
        }

        if(attr == R.styleable.TitleBar_titlebar_leftAndRightPadding){
            int leftAndRightPadding = typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 10));
            mLeftTv.setPadding(leftAndRightPadding, 0, leftAndRightPadding, 0);
            mRightTv.setPadding(leftAndRightPadding, 0, leftAndRightPadding, 0);
        }

        if(attr == R.styleable.TitleBar_titlebar_leftMaxWidth){
            setLefttvMaxWidth(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 100)));
        }

        if(attr == R.styleable.TitleBar_titlebar_rightMaxWidth){
            setRighttvMaxWidth(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 120)));
        }

        if(attr == R.styleable.TitleBar_titlebar_titleMaxWidth){
            setTitletvMaxWidth(typedArray.getDimensionPixelSize(attr, dp2px(getContext(), 144)));
        }

        if(attr == R.styleable.TitleBar_titlebar_isTitleTextBold){
            mTitleTv.getPaint().setFakeBoldText(typedArray.getBoolean(attr, true));
        }

        if(attr == R.styleable.TitleBar_titlebar_isLeftTextBold){
            mLeftTv.getPaint().setFakeBoldText(typedArray.getBoolean(attr, false));
        }

        if(attr == R.styleable.TitleBar_titlebar_isRightTextBold){
            mRightTv.getPaint().setFakeBoldText(typedArray.getBoolean(attr, false));
        }

        if(attr == R.styleable.TitleBar_titlebar_isRightEnable){
            setRightTextViewEnable(typedArray.getBoolean(attr, true));
        }
    }

    public void setRightTextViewEnable(boolean isEnable) {
        mRightTv.setEnabled(isEnable);
    }

    public void setLefttvMaxWidth(int maxWidth) {
        mLeftTv.setMaxWidth(maxWidth);
    }

    public void setRighttvMaxWidth(int maxWidth) {
        mRightTv.setMaxWidth(maxWidth);
    }

    public void setTitletvMaxWidth(int maxWidth) {
        mTitleTv.setMaxWidth(maxWidth);
    }

    public void hiddenLeftTextView() {
        mLeftTv.setVisibility(GONE);
    }

    public void showLeftTextView() {
        mLeftTv.setVisibility(VISIBLE);
    }

    public void setLeftText(@StringRes int resid) {
        setLeftText(getResources().getString(resid));
    }

    public void setLeftText(CharSequence text) {
        mLeftTv.setText(text);
        showLeftTextView();
    }

    public void setLeftDrawable(Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        mLeftTv.setCompoundDrawables(drawable, null, null, null);
        showLeftTextView();
    }

    public void setLeftDrawablePadding(int padding) {
        mLeftTv.setCompoundDrawablePadding(padding);
    }

    public void hiddenTitleTextView() {
        mTitleTv.setVisibility(GONE);
    }

    public void showTitleTextView() {
        mTitleTv.setVisibility(VISIBLE);
    }

    public String getTitleText() {
        if (mTitleTv == null) return "";
        return mTitleTv.getText().toString();
    }

    public void setTitleText(CharSequence text) {
        mTitleTv.setText(text);
        showTitleTextView();
    }

    public void setTitleText(@StringRes int resid) {
        setTitleText(getResources().getString(resid));
    }

    public void setTitleDrawable(Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        mTitleTv.setCompoundDrawables(null, null, drawable, null);
        showTitleTextView();
    }

    public void setTitleDrawablePadding(int padding) {
        mTitleTv.setCompoundDrawablePadding(padding);
    }

    public void hiddenRightTextView() {
        mRightTv.setVisibility(GONE);
    }

    public void showRightTextView() {
        mRightTv.setVisibility(VISIBLE);
    }

    public void hiddenDivideLine() {
        mDivideLine.setVisibility(GONE);
    }

    public void showDivideLine() {
        mDivideLine.setVisibility(VISIBLE);
    }

    public void setDivideLineColor(int color) {
        mDivideLine.setBackgroundColor(color);
    }

    public void setRightText(CharSequence text) {
        mRightTv.setText(text);
        showRightTextView();
    }

    public void setRightText(@StringRes int resid) {
        setRightText(getResources().getString(resid));
    }

    public void setRightDrawable(Drawable drawable) {
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        mRightTv.setCompoundDrawables(null, null, drawable, null);
        showRightTextView();
    }

    public void setRightDrawablePadding(int padding) {
        mRightTv.setCompoundDrawablePadding(padding);
    }

    public void setRightTextColor(int color) {
        mRightTv.setTextColor(color);
    }

    public void setRightTextSize(int size) {
        mRightTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public void setTitleTextSize(int size) {
        mTitleTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public void setLeftTextSize(int size) {
        mLeftTv.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
    }

    public TextView getLeftTextView() {
        return mLeftTv;
    }

    public TextView getRightTextView() {
        return mRightTv;
    }

    public TextView getTitleTextView() {
        return mTitleTv;
    }

    public void setOnClickTitleBarListener(TitleBarListener titleBarListener) {
        this.mTitleBarListener = titleBarListener;
    }

    @Override
    public void onClick(View v) {
        if (mTitleBarListener != null) {
            if(v.getId() == R.id.titlebar_title){
                mTitleBarListener.onClickTitle(v);
            }else if(v.getId() == R.id.titlebar_left){
                mTitleBarListener.onClickLeft(v);
            }else if(v.getId() == R.id.titlebar_right){
                mTitleBarListener.onClickRight(v);
            }
        }
    }

    public static int dp2px(Context context, float dpValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
    }

    public static int sp2px(Context context, float spValue) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spValue, context.getResources().getDisplayMetrics());
    }

    public interface TitleBarListener {
        public void onClickTitle(View v);

        public void onClickLeft(View v);

        public void onClickRight(View v);
    }
}
