package com.pt365.common.http;

import android.app.Activity;

import com.pt365.common.AppSession;
import com.pt365.utils.StringUtil;

import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * 网络交互公共类
 * Created by Administrator on 2016/10/13.
 */

public class HttpUtil {

    public static void doPost(Activity activity, RequestParams params, HttpCallback callback) {
        if(StringUtil.isEmpty(AppSession.JSESSIONID )) {
            loginAgain();
        }
        x.http().post(params, callback);
    }

    public static void doGet(Activity activity, RequestParams params, HttpCallback callback) {
        if(StringUtil.isEmpty(AppSession.JSESSIONID )) {
            loginAgain();
        }
        x.http().get(params, callback);
    }

    private static void loginAgain() {

    }
}
