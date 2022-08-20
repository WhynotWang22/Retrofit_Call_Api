package com.whynotquang.quangndph14804_thi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.whynotquang.quangndph14804_thi.Adapter.Abum_Adapter;
import com.whynotquang.quangndph14804_thi.Model.Abum;
import com.whynotquang.quangndph14804_thi.Server.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView_api;
    Button btnTinhtrungbinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView_api = findViewById(R.id.recyclerview_api);
        btnTinhtrungbinh = findViewById(R.id.btnTinhtrungbinh);
        recyclerView_api.hasFixedSize();
        recyclerView_api.setLayoutManager(new LinearLayoutManager(this));

    GetlistApi();
    Chuyenman();
    }
    public void GetlistApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Data data = retrofit.create(Data.class);
        Call<List<Abum>> call = data.getPost();
        call.enqueue(new Callback<List<Abum>>() {
            @Override
            public void onResponse(Call<List<Abum>> call, Response<List<Abum>> response) {
                if (!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                List<Abum> abumList = response.body();
                Abum_Adapter abum_adapter = new Abum_Adapter(MainActivity.this,abumList);
                recyclerView_api.setAdapter(abum_adapter);
            }

            @Override
            public void onFailure(Call<List<Abum>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Chuyenman(){
        btnTinhtrungbinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,TinhtrungbinhActivity.class);
                startActivity(intent);
            }
        });
    }
}