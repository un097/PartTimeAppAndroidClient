package com.pt365.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * 设备系统工具类
 *
 * @author suncr
 */
public class DeviceUtil {

    /**
     * 获取设备IMEI号
     *
     * @param ctx
     * @return
     */
    public static String getIMEI(Context ctx) {
        if (ctx == null) {
            return "";
        }
        return ((TelephonyManager) ctx
                .getSystemService (Context.TELEPHONY_SERVICE)).getDeviceId ();
    }

    /**
     * 返回系统版本号
     *
     * @return
     */
    public static String getSysVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 隐藏键盘
     *
     * @param et 需要隐藏键盘对于的EditText
     */
    public void hideKeyboard(Context ctx, EditText et) {
        if (et == null) {
            return;
        }
        InputMethodManager imm = (InputMethodManager) ctx
                .getSystemService (Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow (et.getWindowToken (), 0);
    }
}
