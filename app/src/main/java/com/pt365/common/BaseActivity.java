package com.pt365.common;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.pt365.utils.ActivityUtil;

import org.xutils.x;

import java.io.Serializable;

/**
 * 所有activity的基类
 * Created by Administrator on 2016/10/12.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //页面管理类增加页面
        ActivityUtil.addActivity (this);
        //xutis注入机制初始化
        x.view().inject(this);
    }

    @Override
    public void finish() {
        super.finish ();
        ActivityUtil.removeActivity (this);
    }

    @Override
    protected void onDestroy() {
        ActivityUtil.removeActivity (this);
        super.onDestroy ();
    }

    /**
     * 从本页面跳转到另外一个页面
     * @param cls 需要跳转到的页面
     */
    protected void startActivity(Class<?> cls) {
        startActivity (cls, null);
    }

    /**
     * 带着数据，从本页面跳转到另外一个页面
     * @param cls 需要跳转到的页面
     * @param obj 传递给下个页面的数据
     */
    public void startActivity(Class<?> cls, Object obj) {
        Intent intent = new Intent(this, cls);
        if (obj != null) {
            intent.putExtra ("data", (Serializable) obj);
        }
        startActivity (intent);
//        overridePendingTransition (R.anim.push_right_in, R.anim.push_left_out);
    }

    /**
     * 根据string.xml中的id获取字符串
     * @param resId
     * @return
     */
    protected String getResString(int resId) {
        return getResources ().getString (resId);
    }

    /**
     * 退出程序
     */
    protected void exitApp() {
        ActivityUtil.finishAll();
    }
}
