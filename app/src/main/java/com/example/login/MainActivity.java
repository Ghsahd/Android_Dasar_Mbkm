package com.example.login;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import com.example.login.RecycleView.PhotoAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.login.Respon.Photos;
import com.example.login.Api.ApiService;
import com.example.login.Api.ApiClient;
import com.example.login.databinding.ActivityMainBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PhotoAdapter adapter;
    private List<Photos> photoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        photoList = new ArrayList<>();
        adapter = new PhotoAdapter(this, photoList);
        recyclerView.setAdapter(adapter);

        fetchDataFromApi();
    }

    private void fetchDataFromApi() {
        ApiService api = ApiClient.getClient().create(ApiService.class);
        Call<List<Photos>> call = api.getPhotos();
        call.enqueue(new Callback<List<Photos>>() {
            @Override
            public void onResponse(Call<List<Photos>> call, Response<List<Photos>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    photoList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<Photos>> call, Throwable t) {
                // Tangani kesalahan saat gagal mengambil data
            }
        });
    }
}