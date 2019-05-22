package com.example.myretrofitrxjavadagger2practice;

import android.app.Application;

import com.example.myretrofitrxjavadagger2practice.di.DaggerMyComponent;
import com.example.myretrofitrxjavadagger2practice.di.MyComponent;
import com.example.myretrofitrxjavadagger2practice.di.RetrofitModule;

public class MyApplication extends Application {

    private MyComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMyComponent.builder()
                .retrofitModule(new RetrofitModule("https://jsonplaceholder.typicode.com/"))
                .build();
    }
    public MyComponent getComponent(){
        return component;
    }

}


