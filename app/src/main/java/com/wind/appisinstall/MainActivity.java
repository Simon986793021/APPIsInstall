package com.wind.appisinstall;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boolean is=isAppInstalled(this,"com.wind.appisinstal");
        Toast.makeText(this,is+"",Toast.LENGTH_SHORT).show();
    }
    /**
    * check the app is installed
    */
    private boolean isAppInstalled(Context context, String packagename)
    {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(packagename, 0);
        }catch (PackageManager.NameNotFoundException e) {
            packageInfo = null;
            e.printStackTrace();
        }
        if(packageInfo ==null){
            Log.i(">>>>>>>>","没有安装");
            return false;
        }else{
            Log.i(">>>>>>>>","安装");
            return true;
        }
    }

}
