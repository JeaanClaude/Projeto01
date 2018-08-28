package com.example.jeanc.crud_pessoa;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder()

                .baseUrl("http://192.168.0.103:8080/api/v1.0/")

                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public PessoaService getModelService() {
        return this.retrofit.create(PessoaService.class);
    }

}
