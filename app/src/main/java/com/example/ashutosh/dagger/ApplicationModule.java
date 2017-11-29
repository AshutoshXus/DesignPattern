package com.example.ashutosh.dagger;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.ashutosh.MyApplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ashutosh on 18/2/16.
 */

@Module
public class ApplicationModule {

    private final MyApplication application;

    public ApplicationModule(MyApplication application)
    {
        this.application = application;
    }

    @Singleton
    @Provides @Named("first")
    SharedPreferences provideSharedPreference()
    {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Singleton
    @Provides @Named("second")
    SharedPreferences provideSecondSharedPreference()
    {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }


}
