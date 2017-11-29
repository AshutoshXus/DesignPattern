package com.example.ashutosh.dagger;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ashutosh on 18/2/16.
 */
@Singleton
@Component(modules = {ApplicationModule.class,NetModule.class})
public interface DaggerComponent {

    void inject(DaggerActivity mDaggeractivity);
}
