package com.rafilutfansyah.retrofitexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<InfoUser> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.196/laravel/public/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        findViewById(R.id.button_proses).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIService apiService = retrofit.create(APIService.class);
                Call<ResultUser> resultUserCall = apiService.getUserAPI();
                resultUserCall.enqueue(new Callback<ResultUser>() {
                    @Override
                    public void onResponse(Call<ResultUser> call, Response<ResultUser> response) {
                        List<InfoUser> user = response.body().getUser();
                        for(int i=0; i<user.size(); i++) {
                            Toast.makeText(MainActivity.this, user.get(i).getUsername(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResultUser> call, Throwable t) {

                    }
                });
            }
        });
    }
}
