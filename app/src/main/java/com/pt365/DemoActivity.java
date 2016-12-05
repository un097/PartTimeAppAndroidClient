package com.pt365;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.pt365.common.BaseActivity;
import com.pt365.common.http.HttpAddressValues;
import com.pt365.common.http.HttpCallback;
import com.pt365.common.http.HttpCommonParams;
import com.pt365.common.view.RefreshAndLoadListView;
import com.pt365.utils.DialogUtil;
import com.pt365.common.http.HttpUtil;
import com.strong.pt.delivery.R;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 *  示例activity  包含一些常用元素的使用
 */
@ContentView(R.layout.activity_demo)
public class DemoActivity extends BaseActivity {

    //刷新加载列表相关
    @ViewInject(R.id.swipeRefreshLayout)
    private RefreshAndLoadListView swipeRefreshLayout;
    @ViewInject(R.id.listview)
    private ListView listView;
    @ViewInject(R.id.textView)
    private TextView tv;

    private List<String> data;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
    }

    private void initView() {
        // TODO Auto-generated method stub
        data=new ArrayList<String>();
        for (int i = 1; i <= 50; i++) {
            data.add("我是测试item:" + i);
        }
        adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,data);
        listView.setAdapter(adapter);

        //设置卷内的颜色
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright, android.R.color.holo_green_light, android.R.color.holo_orange_light, android.R.color.holo_red_light);

        //设置下拉刷新监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                data.add(0, "添加新的item:" + new Random().nextInt());
                adapter.notifyDataSetChanged();
                //停止刷新动画
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        // 加载监听器
        swipeRefreshLayout.setOnLoadListener(new RefreshAndLoadListView.OnLoadListener() {
            @Override
            public void onLoad() {
                swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        data.add(new Date().toGMTString());
                        adapter.notifyDataSetChanged();
                        // 加载完后调用该方法
                        swipeRefreshLayout.setLoading(false);
                    }
                }, 1500);
            }
        });
    }


    /**
     * 使用@Event事件注解(@ContentView, @ViewInject等更多示例参考sample项目)
     * 1. 方法必须私有限定,
     * 2. 方法参数形式必须和type对应的Listener接口一致.
     * 3. 注解参数value支持数组: value={id1, id2, id3}
     **/
    @Event(value = R.id.button, type = View.OnClickListener.class/*可选参数, 默认是View.OnClickListener.class*/)
    private void onTestClick(View view) {
        //网络交互准备和地址参数
        HttpCommonParams params = new HttpCommonParams(HttpAddressValues.APP_INTERFACE_SERVER_ADDRESS +"queryEmployeeMsg.action");
        params.addBodyParameter("inputParameter", "{\"employee_id\":\"002669\"}");

        //如果需要显示等待框则调用该方法  关闭不需要处理
        DialogUtil.showLoading(this);

        //执行post方法  并实现回调，不要忘了调用super的公共方法
        HttpUtil.doPost(this, params, new HttpCallback(this) {
            //接口调用成功后的处理  不要忘了调用super方法
            @Override
            public void onSuccess(String result) {
                super.onSuccess(result);
                tv.setText(result);
            }
            //接口调用失败后的处理  不要忘了调用super方法
            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                super.onError(ex, isOnCallback);
            }
        });
    }
}
