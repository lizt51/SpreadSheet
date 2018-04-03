package com.example.hyde.spreadsheet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hyde.spreadsheet.adapter.NamaAdapter;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private RecyclerView recyclerView;
    private NamaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rec);
        //getData();


        ApiInterface apiInterface = ApiCall.getClient().create(ApiInterface.class);
        Call<Response> responseCall = apiInterface.ambilData();
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.body().user.size() > 0) {
                    adapter = new NamaAdapter(response.body().user);
                    //
                    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(mLayoutManager);
                    recyclerView.setItemAnimator(new DefaultItemAnimator());//
                    //adapter
                    recyclerView.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.i("autolog", "t: " + t.getMessage());
            }
        });

    }

    private void getData() {
        ApiInterface apiInterface = ApiCall.getClient().create(ApiInterface.class);
        Call<Response> responseCall = apiInterface.ambilData();
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.body().user.size() > 0) {
                    for (int i = 0; i < response.body().user.size(); i++) {
                        textView.setText(textView.getText().toString() + "\n" + response.body().user.get(i).nama);
                    }
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Log.i("autolog", "t: " + t.getMessage());
            }
        });

    }
}
