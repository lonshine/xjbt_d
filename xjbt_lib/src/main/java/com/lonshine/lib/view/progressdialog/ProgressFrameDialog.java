package com.lonshine.lib.view.progressdialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.lonshine.lib.R;

/**
 * 仿ios效果的进度对话框,帧动画自定义对话框
 * Created by lonshine on 15/11/4 下午11:18.
 */
public class ProgressFrameDialog extends Dialog {
    public ProgressFrameDialog(Context context) {
        super(context);
    }

    public ProgressFrameDialog(Context context, int theme) {
        super(context, theme);
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        ImageView imageView = (ImageView) findViewById(R.id.ivPfd);
        AnimationDrawable spinner = (AnimationDrawable) imageView.getBackground();
        spinner.start();
    }

    public void setMessage(CharSequence message) {
        if (message != null && message.length() > 0) {
            findViewById(R.id.tvPfd).setVisibility(View.VISIBLE);
            TextView txt = (TextView) findViewById(R.id.tvPfd);
            txt.setText(message);
            txt.invalidate();
        }
    }

    public static ProgressFrameDialog show(Context context, CharSequence message, boolean indeterminate, boolean cancelable,
                                   OnCancelListener cancelListener) {
        ProgressFrameDialog dialog = new ProgressFrameDialog(context, R.style.ProgressFrameDialog);
        dialog.setTitle("");
        dialog.setContentView(R.layout.layout_progress_frame_dialog);
        if (message == null || message.length() == 0) {
            dialog.findViewById(R.id.tvPfd).setVisibility(View.GONE);
        } else {
            TextView txt = (TextView) dialog.findViewById(R.id.tvPfd);
            txt.setText(message);
        }
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);
        dialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
        lp.dimAmount = 0.2f;
        dialog.getWindow().setAttributes(lp);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        dialog.show();
        return dialog;
    }
}
