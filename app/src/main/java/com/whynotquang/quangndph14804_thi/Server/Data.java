package com.whynotquang.quangndph14804_thi.Server;

import com.whynotquang.quangndph14804_thi.Model.Abum;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Data {

    @GET("posts")
    Call<List<Abum>> getPost();
}
