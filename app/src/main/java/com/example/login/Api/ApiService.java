package com.example.login.Api;
import com.example.login.Respon.Photos;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("photos")
    Call<List<Photos>> getPhotos();
}
