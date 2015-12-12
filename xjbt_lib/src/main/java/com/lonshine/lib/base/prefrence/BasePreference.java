package com.lonshine.lib.base.prefrence;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by lonshine on 15/12/12 下午11:23.
 */
public class BasePreference {
    protected Context mContext;

    protected SharedPreferences mSharedPreferences;

    public BasePreference(Context context, String name) {
        this(context, name, Context.MODE_PRIVATE);
    }
    public BasePreference(Context context, String name, int mode) {
        mContext = context.getApplicationContext();
        mSharedPreferences = mContext.getSharedPreferences(name, mode);
    }
    SharedPreferences.Editor mEditor;

    public SharedPreferences.Editor edit() {
        if (mEditor == null) {
            mEditor = mSharedPreferences.edit();
        }
        return mEditor;
    }

    public void commit() {
        if (mEditor != null) {
            mEditor.apply();
            mEditor = null;
        }
    }

    public SharedPreferences getSharedPreferences() {
        return mSharedPreferences;
    }

    public void clear() {
        edit().clear().apply();
    }
}
