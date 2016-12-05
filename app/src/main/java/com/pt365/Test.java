package com.pt365;

import android.os.Bundle;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.pt365.common.BaseActivity;
import com.strong.pt.delivery.R;

import org.xutils.view.annotation.ContentView;

/**
 * Created by Administrator on 2016/10/13.
 */

@ContentView(R.layout.test)
public class Test extends BaseActivity {

    private  MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);// 此方法必须重写
        AMap aMap = mapView.getMap();
    }
}
