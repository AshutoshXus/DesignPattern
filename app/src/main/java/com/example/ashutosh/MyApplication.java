package com.example.ashutosh;

import android.app.Application;

import com.example.ashutosh.dagger.ApplicationModule;
import com.example.ashutosh.dagger.DaggerComponent;
import com.example.ashutosh.dagger.DaggerDaggerComponent;
import com.example.ashutosh.dagger.NetModule;


/**
 * Created by ashutosh on 18/2/16.
 */
public class MyApplication extends Application {

    DaggerComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

       component = DaggerDaggerComponent
               .builder()
               .applicationModule(new ApplicationModule(this))
               .netModule(new NetModule(this))
               .build();
    }

    public DaggerComponent getComponent() {
        return component;
    }
}
