package com.example.majichun.airquality;

import android.content.Context;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;

/**
 * Created by jichunma
 * on 2017/11/28.
 * <p>
 * describe:定位坐标
 */

public class LocationUtils {

  static String TAG = "LocationUtils";

  public static AMapLocationClient mLocationClient = null;
  //声明定位回调监听器
  public static AMapLocationListener mLocationListener;

  public static AMapLocationClientOption mLocationOption = null;



  public static void init(Context context) {
    mLocationListener = new AMapLocationListener() {
      @Override
      public void onLocationChanged(AMapLocation aMapLocation) {
        Log.d(TAG, "onLocationChanged: " + aMapLocation.getLatitude()+", "+aMapLocation.getLongitude());
      }
    };

  //初始化定位
    mLocationClient = new AMapLocationClient(context.getApplicationContext());
  //设置定位回调监听
    mLocationClient.setLocationListener(mLocationListener);

    //声明AMapLocationClientOption对象
    //初始化AMapLocationClientOption对象
    mLocationOption = new AMapLocationClientOption();
    //设置定位模式为AMapLocationMode.Hight_Accuracy，高精度模式。
    mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);

    //获取一次定位结果：
//该方法默认为false。
    mLocationOption.setOnceLocation(true);
    mLocationClient.setLocationOption(mLocationOption);


  }

  public static void startLocated(){

    mLocationClient.startLocation();
  }
}
