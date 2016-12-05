package com.pt365.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * @author suncr
 * @version 1.0
 * @Descript 等待框
 * @date 2014-12-20
 */
public class DialogUtil {
    private static ProgressDialog dialog;
    private static Toast toast;
    private static AlertDialog.Builder alert;

    /**
     * 显示等待框
     *
     * @param context
     */
    public static void showLoading(Activity context) {
        if(dialog != null && dialog.isShowing()) {
            dismissLoading ();
        }
        dialog = new ProgressDialog(context);
//        dialog.setProgressStyle (ProgressDialog.STYLE_SPINNER);
        dialog.setTitle ("等待");
        dialog.setMessage ("加载中");
//        dialog.setIndeterminate (false);
        dialog.setCanceledOnTouchOutside (false);
//		dialog.setCancelable(false);
        dialog.show ();
    }

    /**
     * 显示等待框
     *
     * @param context
     */
    public static void showLoading(Activity context, String title, String mes) {
        if(dialog != null && dialog.isShowing()) {
            dismissLoading ();
        }
        dialog = new ProgressDialog(context);
//        dialog.setProgressStyle (ProgressDialog.STYLE_SPINNER);
//        dialog.setTitle (title);
//        dialog.setMessage (mes);
//        dialog.setIndeterminate (false);
        dialog.setCanceledOnTouchOutside (false);
//		dialog.setCancelable(false);
        dialog.show ();
    }

    /**
     * 等待框消失
     */
    public static void dismissLoading() {
        if (dialog != null && dialog.isShowing ()) {
            dialog.dismiss ();
        }
    }

    /**
     * 显示toast
     *
     * @param context
     * @param mes
     */
    public static void showToast(Context context, String mes) {
        if (toast == null) {
            toast = Toast.makeText (context, mes, Toast.LENGTH_SHORT);
        } else {
            toast.setText (mes);
            toast.setDuration (Toast.LENGTH_SHORT);
        }
        toast.show ();
    }

    public static void alertShow(Context context, String title, String mes, DialogInterface.OnClickListener listener) {
        alert = new AlertDialog.Builder(context);
        if(title != null) {
            alert.setTitle(title);
        }
        if(mes != null) {
            alert.setMessage(mes);
        }
        if(listener != null) {
            alert.setPositiveButton("确定",listener);
        }
        alert.setNegativeButton ("取消", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alert.show();
    }

}
