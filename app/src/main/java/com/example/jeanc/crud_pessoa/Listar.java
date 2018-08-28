package com.example.jeanc.crud_pessoa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Listar extends AppCompatActivity {

    private List<Pessoas> pessoas = new ArrayList();
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);


        listView = (ListView) findViewById(R.id.list_pessoas);

        Call<List<Pessoas>> call = new RetrofitConfig().getModelService().getAllPessoas();

        call.enqueue(new Callback<List<Pessoas>>() {
            @Override
            public void onResponse(Call<List<Pessoas>> call, Response<List<Pessoas>> response) {
                if(response.isSuccessful()){
                    pessoas = response.body();
                    listView.setAdapter(new AdaptadorP(Listar.this, R.layout.activity_listar, pessoas));
                }
            }

            @Override
            public void onFailure(Call<List<Pessoas>> call, Throwable t) {
            }
        });
    }
}
