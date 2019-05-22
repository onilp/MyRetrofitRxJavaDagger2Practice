package com.example.myretrofitrxjavadagger2practice.di;

import com.example.myretrofitrxjavadagger2practice.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = RetrofitModule.class)
public interface MyComponent {

    void injectRetrofit(MainActivity activity);
}
