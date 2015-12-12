package com.lonshine.lib.app;

import android.text.TextUtils;

import com.lonshine.lib.BuildConfig;

import java.lang.reflect.Field;

/**
 * Created by lonshine on 15/12/12 下午11:26.
 */
public class Global {

    public static final int     MAX_SCREEN_COUNT   = 3;
    //是否只打印错误日志，并上传到服务器
    public static       boolean FLAG_UPLOAD_LOG    = !BuildConfig.DEBUG;
    //调试新鸽推送服务
    public static final boolean FLAG_DEBUG_XG_PUSH = BuildConfig.DEBUG;

    public static class FileOrDir {
        public static String ROOT      = Config.PACKAGE_NAME;
//        public static String CACHE_DIR = CacheManager.OLD_IMAGE_CACHE_DIR;
    }

    public static class Action {
        public static final String ALARM_ALERT = Config.PACKAGE_NAME + ".intent.action.ALARM_ALERT";
    }

    public static class Prefer {
        @Deprecated
        public static final String IS_FIRST_SETUP = "is_first_setup"; // 是否是第一次安装配置标记
        @Deprecated
        public static final String USER_ID        = "user_id"; // token
        @Deprecated
        public static final String LOGIN_PLATFORM = "login_platform"; //登录使用的平台， 新浪微博 & 微信
    }

    public static class Config {
        public static final String PACKAGE_NAME = "com.lonshine.lib";
        public static final String APP_NAME     = "iDoctor";
    }


    public static class Url {

        public static boolean isDebug          = false/*BuildConfig.DEBUG*/;
        public static String  sCustomWWWPrefix = null; //自定义网页前缀。

        static {
            //在发布环境中，根据BuildConfig配置url试用测试地址还是发布地址。
            //!!注意这段代码一定要在 isDebug初始化之后，请不要修改顺序。
            if (!BuildConfig.DEBUG) {
                try {
                    Field field = BuildConfig.class.getField("URL_DEBUG");
                    Url.isDebug = field.getBoolean(null);
                } catch (Exception e) {
                }
            }
        }

        public static String getPrefixV1() {
            if (isDebug) {
                return "http://api.lonshine.cn/v1/";  //测试
            } else {
                return "http://api.lonshine.com/v1/";  //正式
            }
        }

        public static String getPrefix() {
            if (isDebug) {
                return "http://api.lonshine.cn/";  //测试
            } else {
                return "http://api.lonshine.com/";  //正式
            }
        }
        public static String getDefaultStaticUrlPrefix() {
            if (isDebug) {
                return "http://st-up.lonshine.cn";
            } else {
                return "http://st-up.lonshine.com";
            }
        }

        private static String getDefaultWwwUrlPrefix() {
            //支持使用自定义网页前缀。
            if (!TextUtils.isEmpty(sCustomWWWPrefix)) {
                return sCustomWWWPrefix;
            }
            if (isDebug) {
                return "http://www.lonshine.cn";
            } else {
                return "http://www.lonshine.com";
            }
        }

        public static String STATIC_URL_PREFIX;
        public static String WWW_URL_PREFIX;
        public static String URL;

        public static String VERSION;

        //发送验证短信
        public static String VERIFY_SMS;

        public static String GET_TOKENS;
        public static String GET_TOKENS_DETAIL;
        public static String GET_QINIU_UP_TOKEN;

        public static String GET_OPEN_TOKEN;
        public static String PUT_RESET_PASSWORD;



        /**
         * !!!!!! 为支持URL应用内切换， 修改URL结构。!!!!!
         * 添加URL步骤：
         * 1. 添加变量， public static 类型，不能是final类型
         * 2. 在initUrlByFlag里面，添加初始化url的方法。
         */
        static {
            initUrlsByFlag();
        }

        //刷新各个URL
        public static void initUrlsByFlag() {

            STATIC_URL_PREFIX = getDefaultStaticUrlPrefix();
            WWW_URL_PREFIX = getDefaultWwwUrlPrefix();
            URL = getPrefixV1(); // Api接口前缀

            VERSION = URL + "versions/latest";// 版本更新信息

            GET_TOKENS = URL + "tokens";
            GET_TOKENS_DETAIL = URL + "tokens/{id}";
            GET_QINIU_UP_TOKEN = URL + "qiniu-up-tokens/android";

            GET_OPEN_TOKEN = URL + "open-tokens"; //第三方登录token
            PUT_RESET_PASSWORD = URL + "tokens/0"; //修改密码

            VERIFY_SMS = URL + "verify-sms";
        }
    }

    public static class Error {
        public static String HTTP_ERROR = "httpError";// http请求出错
        //and more ....
    }

    /**
     * 错误定义，都转移到
     */
    @Deprecated
    public static class Code {
        //正值，表示客户端自定义的错误。
        //>1000, 为http Status Code 错误。
        public static String HTTP_DATA_EMPTY       = "1";//空数据错误编码
        public static String HTTP_REQUEST_FAILED   = "2";//业务请求的失败编码
        public static String HTTP_NETWORK_ERROR    = "3";//网络错误
        public static String HTTP_JSON_PARSE_ERROR = "4";//json解析错误
        public static String HTTP_REQUEST_IS_NULL  = "5";//请求为空
        public static String COMPRESS_IMAGE_ERROR  = "6"; //压缩图片错误。

        public static String CANCELED = "7"; //请求已取消。

        //and more ....
    }

    public static class RequestCoder {
        public static final int GET_IMAGE_BY_TAKE_PHOTO = 10050;
    }
}
