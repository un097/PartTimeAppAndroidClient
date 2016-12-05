package com.pt365.common.http;

import android.content.Context;
import android.content.SharedPreferences;

import com.pt365.common.AppSession;

import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Administrator on 2016/10/13.
 */

public class HttpCommonParams extends RequestParams {
    public HttpCommonParams(String url){
        super(url);

        //登陆接口 和不需要CooKie的接口
        if (!"/auth/getDate".equals(url)&&!"/api/auth".equals(url)) {
            SharedPreferences sharedPreferences = x.app().getSharedPreferences(AppSession.SP_JSESSION_NAME, Context.MODE_PRIVATE);
            AppSession.JSESSIONID = sharedPreferences.getString("Cookie", "");
            addHeader("Cookie", "JSESSIONID="+AppSession.JSESSIONID);
            setUseCookie(false);
            addHeader("Content-Type", "application/json;charset=UTF-8");
        }else{
            setUseCookie(true);
        }
    }
}