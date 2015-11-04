package com.lonshine.lib.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lonshine.lib.R;


/**
 * 自定义的通用AlertDialog
 * Created by mantou on 15/4/21.
 */
public class CustomAlertDialog extends CustomThemeDialog {

    public CustomAlertDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_custom_alert_dialog);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        findViews();
        setListeners();

        initViews();
    }

    protected void setContentLayout(int layoutId) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        llContent.removeAllViews();
        inflater.inflate(layoutId, llContent, true);
    }

    private void initViews() {
        if (isHideNegativeButton) {
            btnCancel.setVisibility(View.GONE);
        }
        if (isHidePositiveButton) {
            btnOK.setVisibility(View.GONE);
        }
        if (isHidePositiveButton || isHideNegativeButton) {
            vBottomButtonsDivider.setVisibility(View.GONE);
        }

        if (!TextUtils.isEmpty(mTitle)) {
            tvTitle.setText(mTitle);
        } else {
            tvTitle.setVisibility(View.GONE);
            vTitleDivider.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(mMessage)) {
            tvMessage.setText(mMessage);
        }
        if (!TextUtils.isEmpty(mPositiveText)) {
            btnOK.setText(mPositiveText);
        }
        if (!TextUtils.isEmpty(mNegativeText)) {
            btnCancel.setText(mNegativeText);
        }
    }

    protected void showTitle() {
        tvTitle.setVisibility(View.VISIBLE);
        vTitleDivider.setVisibility(View.VISIBLE);
    }
    protected TextView tvTitle, tvMessage;
    protected LinearLayout llContent;
    protected Button btnOK, btnCancel;
    protected View vBottomButtonsDivider, vTitleDivider;

    private void findViews() {
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvMessage = (TextView) findViewById(R.id.tvMessage);
        llContent = (LinearLayout) findViewById(R.id.llContent);

        btnOK = (Button) findViewById(R.id.btnOK);
        btnCancel = (Button) findViewById(R.id.btnCancel);
        vBottomButtonsDivider = findViewById(R.id.vBottomButtonsDivider);
        vTitleDivider = findViewById(R.id.vTitleDivider);
    }

    private void setListeners() {
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isDismissOnClickButton) dismiss();
                if (mPositiveOnClickListener != null) {
                    mPositiveOnClickListener.onClick(v);
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (isDismissOnClickButton) dismiss();
                if (mNegativeOnClickListener != null) {
                    mNegativeOnClickListener.onClick(v);
                }
            }
        });
    }

    View.OnClickListener mPositiveOnClickListener, mNegativeOnClickListener;

    public void setPositiveOnClickListener(View.OnClickListener listener) {
        mPositiveOnClickListener = listener;
    }

    public void setNegativeOnClickListener(View.OnClickListener listener) {
        mNegativeOnClickListener = listener;
    }

    boolean isDismissOnClickButton = true;

    public void setDismissOnClickButton(boolean dismiss) {
        isDismissOnClickButton = dismiss;
    }

    boolean isHidePositiveButton = false, isHideNegativeButton = false;

    public void hidePositiveButton() {
        if (btnOK == null) {
            isHidePositiveButton = true;
            return;
        }
        btnOK.setVisibility(View.GONE);
        if (btnCancel == null || vBottomButtonsDivider == null) {
            return;
        }
        if (btnCancel.getVisibility() == View.GONE) {
            vBottomButtonsDivider.setVisibility(View.GONE);
        }
    }

    public void hideNegativeButton() {
        if (btnCancel == null) {
            isHideNegativeButton = true;
            return;
        }
        btnCancel.setVisibility(View.GONE);
        if (btnOK == null || vBottomButtonsDivider == null) {
            return;
        }
        if (btnOK.getVisibility() == View.GONE) {
            vBottomButtonsDivider.setVisibility(View.GONE);
        }
    }

    String mMessage, mTitle;

    public void setMessage(String message) {
        if (tvMessage != null) {
            tvMessage.setText(message);
        } else {
            mMessage = message;
        }
    }

    public void setTitle(String title) {
        if (tvTitle != null) {
            tvTitle.setText(title);
        } else {
            mTitle = title;
        }
    }

    String mPositiveText, mNegativeText;

    public void setPositiveText(String positiveText) {
        if (btnOK != null) {
            btnOK.setText(positiveText);
        } else {
            mPositiveText = positiveText;
        }
    }

    public void setNegativeText(String negativeText) {
        if (btnCancel != null) {
            btnCancel.setText(negativeText);
        } else {
            mNegativeText = negativeText;
        }
    }
}
