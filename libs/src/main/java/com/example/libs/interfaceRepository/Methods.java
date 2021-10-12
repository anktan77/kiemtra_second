package com.example.libs.interfaceRepository;

import com.example.libs.models.Content;
import com.example.libs.models.PostData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Methods {
    @GET("article/18dthd6_TheQueenTeam1/")
    Call<Content> getContents();

    @PUT("article/{Id}/")
    Call<Content.Data> putContent(@Path("Id") String id,
                                  @Body Content.Data data);

    @DELETE("article/{id}/")
    Call<Content.Data> deleteContent(@Path("id") String id);

    @POST("article/")
    Call<Content> postContent(@Body PostData postData);
}
