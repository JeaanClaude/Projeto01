package com.example.jeanc.crud_pessoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Deletar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar);

        final EditText etID = findViewById(R.id.etID);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Call<Pessoas> call = new RetrofitConfig().getModelService().deletePessoa(Long.valueOf(etID.getText().toString()));
                call.enqueue(new Callback<Pessoas>() {
                    @Override
                    public void onResponse(Call<Pessoas> call, Response<Pessoas> response) {
                        if(response.isSuccessful()){
                        Toast.makeText(Deletar.this, "Excluido!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Pessoas> call, Throwable t) {
                        Log.e("CrudService   ", "Erro:" + t.getMessage());
                    }
                });
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Deletar.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
