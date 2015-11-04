package com.lonshine.lib.view.dialog;

import android.app.Dialog;
import android.content.Context;

import com.lonshine.lib.R;

/**
 * 自定义主题的对话框
 * Created by lonshine on 15/11/4 下午11:44.
 */
public class CustomThemeDialog extends Dialog {
    protected int animResId = R.style.Animations_Dialog_Fade;

    public CustomThemeDialog(Context context) {
        this(context, R.style.CustomTheme_Dialog);
    }

    public CustomThemeDialog(Context context, boolean cancelable,
                             OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    public CustomThemeDialog(Context context, int theme) {
        super(context, theme);
        init();
    }

    private void init() {
		/*setCanceledOnTouchOutside(false);*/
		/*getWindow().setWindowAnimations(animResId);*/
    }
}
