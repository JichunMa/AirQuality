package com.example.majichun.airquality;

import android.Manifest;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    MainActivityPermissionsDispatcher.getLocationWithPermissionCheck(MainActivity.this);
  }

  @NeedsPermission({Manifest.permission_group.LOCATION})
  public void getLocation(){
    LocationUtils.init(this);
    LocationUtils.startLocated();
  }

  @OnPermissionDenied({Manifest.permission_group.LOCATION})
  void showDeniedForCamera() {
    Toast.makeText(this, "Denied", Toast.LENGTH_SHORT).show();
    Log.d("act","Denied");
  }

  @OnNeverAskAgain({Manifest.permission_group.LOCATION})
  void showNeverAskForCamera() {
    Toast.makeText(this, "NeverAskFor", Toast.LENGTH_SHORT).show();
    Log.d("act","NeverAskFor");
  }

}
