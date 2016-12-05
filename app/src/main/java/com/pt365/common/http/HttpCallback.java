package com.pt365.common.http;

import android.content.Context;

import com.pt365.utils.DialogUtil;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.cookie.DbCookieStore;

import java.net.HttpCookie;
import java.util.List;

/**
 * 公共网络回调
 * Created by Administrator on 2016/10/13.
 */

public class HttpCallback implements Callback.CommonCallback<String> {

    private Context context;

    public HttpCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onSuccess(String result) {
        //cookie的值
        DbCookieStore instance = DbCookieStore.INSTANCE;
        List<HttpCookie> cookies = instance.getCookies();
        for (HttpCookie cookie:cookies){
            String name =   cookie.getName();
            String value =   cookie.getValue();
            if("JSESSIONID".equals(name)){
                DialogUtil.showToast(context, "sessionid:"+value);
                break;
            }
        }
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        if (ex instanceof HttpException) { // 网络错误
            HttpException httpEx = (HttpException) ex;
            int responseCode = httpEx.getCode();
            String responseMsg = httpEx.getMessage();
            String errorResult = httpEx.getResult();
            DialogUtil.showToast(context, "code:"+responseCode+";错误信息:"+responseMsg+ ";错误结果:"+errorResult);
        } else {
            DialogUtil.showToast(context, "错误:非正规错误"+ex.getStackTrace());
        }
    }

    @Override
    public void onCancelled(CancelledException cex) {

    }

    @Override
    public void onFinished() {
        DialogUtil.dismissLoading();
    }
}
