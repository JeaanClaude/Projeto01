package com.example.jeanc.crud_pessoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Consultar extends AppCompatActivity {

    private Pessoas pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        final EditText etFirstName = findViewById(R.id.etNome);
        final EditText etLastName = findViewById(R.id.etSobrenome);
        Button btnConsulta = findViewById(R.id.btnConsulta);
        Button btnVoltar = findViewById(R.id.btnVoltar);
        Button btnAtualizar = findViewById(R.id.btnAtualizar);
        final EditText etID = findViewById(R.id.etID);

        btnConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Call<Pessoas> call = new RetrofitConfig().getModelService().getPessoa(Long.valueOf(etID.getText().toString()));
                call.enqueue(new Callback<Pessoas>() {
                    @Override
                    public void onResponse(Call<Pessoas> call, Response<Pessoas> response) {
                        if(response.isSuccessful()){
                            pessoa = response.body();
                            etFirstName.setText(pessoa.getFirstName());
                            etLastName.setText(pessoa.getLastName());
                        }
                    }
                    @Override
                    public void onFailure(Call<Pessoas> call, Throwable t) {

                    }
                });
            }
        });



        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setFirstName(etFirstName.getText().toString());
                pessoa.setLastName(etLastName.getText().toString());
                Call<Pessoas> call = new RetrofitConfig().getModelService().updatePessoa(pessoa.getID(),pessoa);

                call.enqueue(new Callback<Pessoas>() {
                    @Override
                    public void onResponse(Call<Pessoas> call, Response<Pessoas> response) {
                        Toast t = Toast.makeText(Consultar.this,"Atualizado!", Toast.LENGTH_LONG);
                        t.show();
                    }

                    @Override
                    public void onFailure(Call<Pessoas> call, Throwable t) {

                    }
                });

            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Consultar.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
