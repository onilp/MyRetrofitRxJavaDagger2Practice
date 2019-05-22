package com.example.myretrofitrxjavadagger2practice.network;

import com.example.myretrofitrxjavadagger2practice.model.TodoResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiInterface {

    //https://jsonplaceholder.typicode.com/todos/1

    @GET("todos/")
    Observable<List<TodoResponse>> getTodos();
}
