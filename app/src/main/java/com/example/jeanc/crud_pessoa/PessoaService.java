package com.example.jeanc.crud_pessoa;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

interface PessoaService {

    @GET("persons")
    Call<List<Pessoas>> getAllPessoas();

    @GET("persons/{id}")
    Call<Pessoas> getPessoa(@Path("id") Long id);

    @POST("persons")
    Call<Pessoas> createPessoa(@Body Pessoas pessoas);

    @PUT("persons/{id}")
    Call<Pessoas> updatePessoa(@Path("id") Long id,@Body Pessoas pessoas);

    @DELETE("persons/{id}")
    Call<Pessoas> deletePessoa(@Path("id") Long id);

}

