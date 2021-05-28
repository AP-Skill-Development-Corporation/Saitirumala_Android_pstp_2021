package com.example.retrofittest;

import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BookService {

  @GET("books/v1/volumes")
    Call<String> getresponse(@Query("q") String name);
}
