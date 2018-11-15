package com.example.sande.retrofitdagger;

import android.app.Application;

import com.example.sande.retrofitdagger.di.ApiModule;
import com.example.sande.retrofitdagger.di.DaggerMyComponent;
import com.example.sande.retrofitdagger.di.MyComponent;


public class MyApplication extends Application {

    MyComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerMyComponent.builder()
                .apiModule(new ApiModule("http://rjtmobile.com"))
                .build();
    }

    public MyComponent getComponentInstance()
    {
        return component;
    }

}
