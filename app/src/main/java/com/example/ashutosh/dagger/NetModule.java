package com.example.ashutosh.dagger;

import android.app.Application;

import com.example.ashutosh.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ashutosh on 18/2/16.
 */

@Module
public class NetModule {

    private final MyApplication application;

    public NetModule(MyApplication application)
    {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

}
