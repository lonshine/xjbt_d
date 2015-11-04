package com.lonshine.lib.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.lonshine.lib.view.progressdialog.ProgressFrameDialog;

/**
 * 各种自定义对话框
 * Created by mantou on 15/5/8.
 */
public class CustomDialogHelper {
    protected Context mContext;

    public CustomDialogHelper(Context context) {
        mContext = context;
    }

    /**
     * 显示警告对话框。
     * 有标题，无Negative 按钮。
     */
    public Dialog showAlert(String title, String message,
                            String positiveText, View.OnClickListener positiveClickListener) {
        return showAlert(title, message, positiveText, positiveClickListener, null, null);
    }

    /**
     * 显示警告对话框
     *
     * @param positiveText 为null时不显示
     * @param negativeText 为null时不显示。
     */
    public Dialog showAlert(String title, String message,
                            String positiveText, View.OnClickListener positiveClickListener,
                            String negativeText, View.OnClickListener negativeClickListener) {
        CustomAlertDialog dialog = new CustomAlertDialog(mContext);
        dialog.setTitle(title);
        dialog.setMessage(message);

        if (positiveText != null) {
            dialog.setPositiveText(positiveText);
            dialog.setPositiveOnClickListener(positiveClickListener);
        } else {
            dialog.hidePositiveButton();
        }

        if (negativeText != null) {
            dialog.setNegativeText(negativeText);
            dialog.setNegativeOnClickListener(negativeClickListener);
        } else {
            dialog.hideNegativeButton();
        }
        dialog.show();
        return dialog;
    }

    /**
     * 无标题警告对话框。
     */
    public Dialog showNoTitleAlert(String message,
                                   String positiveText, View.OnClickListener positiveClickListener,
                                   String negativeText, View.OnClickListener negativeClickListener) {
        return showAlert(null, message, positiveText, positiveClickListener, negativeText, negativeClickListener);
    }

    public Dialog showLoading(CharSequence message) {
        return showLoading(message, true);
    }

    public Dialog showLoading(CharSequence message, boolean cancelable) {
        return showLoading(message, cancelable, null);
    }

    public Dialog showLoading(CharSequence message,
            boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        try {
            return ProgressFrameDialog.show(mContext, message, false, cancelable, cancelListener);
        } catch (Exception e) {
            return null;
        }
    }
}
