package com.example.sande.retrofitdagger.di;

import com.example.sande.retrofitdagger.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class})
public interface MyComponent {

    void injectRetrofit(MainActivity mainActivity);
}
