package com.example.myretrofitrxjavadagger2practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.myretrofitrxjavadagger2practice.model.TodoResponse;
import com.example.myretrofitrxjavadagger2practice.network.ApiInterface;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApplication)getApplication()).getComponent().injectRetrofit(this);

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Observable<List<TodoResponse>> observable = apiInterface.getTodos();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults,this::handleError);
    }

    private void handleResults(List<TodoResponse> todoResponse) {
        Log.e(TAG,"response-- " + todoResponse.toString());

    }

    private void handleError(Throwable throwable) {
        Log.e(TAG,"error-- " + throwable.getMessage());
    }


}
