package com.pt365.thirdPartSDK;

import android.content.Context;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

/**
 * Created by Administrator on 2016/10/13.
 */
public class MapSDK {
    private Context context;

    //声明AMapLocationClient类对象
    public AMapLocationClient mLocationClient = null;
    //声明AMapLocationClientOption对象
    public AMapLocationClientOption mLocationOption = null;

    public MapSDK(Context context) {
        this.context = context;

    }

    private void initLocation() {
        //初始化AMapLocationClientOption对象
        mLocationOption = new AMapLocationClientOption();
        //设置高精度定位
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setInterval(2000);
        mLocationOption.setNeedAddress(true);
        //初始化定位
        mLocationClient = new AMapLocationClient(context);
        //设置定位回调监听
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                    //可在其中解析amapLocation获取相应内容。
                    }else {
                        //定位失败时，可通过ErrCode（错误码）信息来确定失败的原因，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError","location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());

//                        amapLocation.getLocationType();//获取当前定位结果来源，如网络定位结果，详见定位类型表
//                        amapLocation.getLatitude();//获取纬度
//                        amapLocation.getLongitude();//获取经度
//                        amapLocation.getAccuracy();//获取精度信息
//                        amapLocation.getAddress();//地址，如果option中设置isNeedAddress为false，则没有此结果，网络定位结果中会有地址信息，GPS定位不返回地址信息。
//                        amapLocation.getCountry();//国家信息
//                        amapLocation.getProvince();//省信息
//                        amapLocation.getCity();//城市信息
//                        amapLocation.getDistrict();//城区信息
//                        amapLocation.getStreet();//街道信息
//                        amapLocation.getStreetNum();//街道门牌号信息
//                        amapLocation.getCityCode();//城市编码
//                        amapLocation.getAdCode();//地区编码
//                        amapLocation.getAoiName();//获取当前定位点的AOI信息
                    }
                }
            }
        });

        mLocationClient.setLocationOption(mLocationOption);
    }

    public void startLocation() {
        if(mLocationClient == null) {
            initLocation();
        }
        mLocationClient.startLocation();
    }

    public void stopLocation() {
        mLocationClient.stopLocation();//停止定位后，本地定位服务并不会被销毁
    }

    public void destroyLocation() {
        mLocationClient.onDestroy();//销毁定位客户端，同时销毁本地定位服务。
    }
}
