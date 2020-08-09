package com.pritkathrotiya.thenews45;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public class BloggerAccessAPI {

    public static final String key = "AIzaSyAv_JQp9CUgL3vw32_EU7hwWiqE5WfiHjI";
    public static final String url = "https://www.googleapis.com/blogger/v3/blogs/6283037476563940325/posts/";

    public static PostServices postServices = null;

    public static PostServices getServices() {

        if (postServices == null) {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postServices = retrofit.create(PostServices.class);
        }
        return postServices;
    }

    public interface PostServices {

        @GET
        Call<PostList> getPostList(@Url String url);
    }
}
