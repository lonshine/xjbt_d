package com.lonshine.idoctor.ui.setting;

import android.content.Context;

import com.lonshine.lib.base.prefrence.BasePreference;

/**
 * Created by lonshine on 15/12/12 下午11:20.
 */
public class SettingsPreference extends BasePreference {

    public static final String KEY_WIFI_AUTO_PLAY = "wifi_auto_play";

    public SettingsPreference(Context context) {
        super(context, "settings");
    }

    public boolean isAutoPlayWhenWiFi() {
        return mSharedPreferences.getBoolean(KEY_WIFI_AUTO_PLAY, true);
    }

    public void setAutoPlayWhenWiFi(boolean autoPlayWhenWiFi) {
        edit().putBoolean(KEY_WIFI_AUTO_PLAY, autoPlayWhenWiFi);
        commit();
    }


    /**
     * DNS
     */
//    public static final String KEY_STATIC_PREFIX = "static_prefix";
//
//    public String getStaticPrefix() {
//        return mSharedPreferences.getString(KEY_STATIC_PREFIX, Global.Url.getDefaultStaticUrlPrefix());
//    }
//
//    public void setStaticPrefix(String static_prefix) {
//        edit().putString(KEY_STATIC_PREFIX, static_prefix).commit();
//    }
//
//    public static final String KEY_DNS_SERVER = "dns_server";
//
//    public String getDnsServer() {
//        return mSharedPreferences.getString(KEY_DNS_SERVER, "223.5.5.5");
//    }
//
//    public void setDnsServer(String dns_server) {
//        edit().putString(KEY_DNS_SERVER, dns_server).commit();
//    }
//
//    public static final HashSet<String> DEFAULT_DEV_CDN_HOSTS = new HashSet<String>();
//    public static final HashSet<String> DEFAULT_RELEASE_CDN_HOSTS = new HashSet<String>();
//
//    static {
//        DEFAULT_DEV_CDN_HOSTS.add("st-up.lonshine.cn");
//        DEFAULT_DEV_CDN_HOSTS.add("lonshine-dev.qiniudn.com");
//        DEFAULT_DEV_CDN_HOSTS.add("st-tx.lonshine.cn");
//
//        DEFAULT_RELEASE_CDN_HOSTS.add("st-up.lonshine.com");
//        DEFAULT_RELEASE_CDN_HOSTS.add("7sbl0l.com2.z0.glb.qiniucdn.com");
//        DEFAULT_RELEASE_CDN_HOSTS.add("st-tx.lonshine.com");
//    }
//
//    public static HashSet<String> getDefaultCDNHosts() {
//        if (Global.Url.isDebug) {
//            return DEFAULT_DEV_CDN_HOSTS;
//        } else {
//            return DEFAULT_RELEASE_CDN_HOSTS;
//        }
//    }
//
//    public static final String KEY_CDN_HOSTS = "cdn_hosts";
//
//    public void setCDNHosts(Set<String> hosts) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//            edit().putStringSet(KEY_CDN_HOSTS, hosts).commit();
//        }
//    }
//
//    public Set<String> geCDNHosts() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
//            return mSharedPreferences.getStringSet(KEY_CDN_HOSTS, getDefaultCDNHosts());
//        } else {
//            return null;
//        }
//    }
}