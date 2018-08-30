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

public class Cadastrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);

        final EditText etFirstName = findViewById(R.id.etNome);
        final EditText etLastName = findViewById(R.id.etSobrenome);
        Button btnSalvar = findViewById(R.id.btnSalvar);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pessoas p1 = new Pessoas();
                p1.setFirstName(etFirstName.getText().toString());
                p1.setLastName(etLastName.getText().toString());
                Call<Pessoas> call = new RetrofitConfig().getModelService().createPessoa(p1);
                call.enqueue(new Callback<Pessoas>() {

                    @Override
                    public void onResponse(Call<Pessoas> call, Response<Pessoas> response) {
                        if (response.isSuccessful()) {
                            Toast t = Toast.makeText(Cadastrar.this, "Cadastrado!", Toast.LENGTH_LONG);
                            t.show();
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
                Intent intent = new Intent(Cadastrar.this, MainActivity.class);
                startActivity(intent);

            }
        });


    }
}
