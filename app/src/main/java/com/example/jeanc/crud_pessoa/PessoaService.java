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

    @GET("pessoas")
    Call<List<Pessoas>> getAllPessoas();

    @GET("pessoas/{id}")
    Call<Pessoas> getPessoa(@Path("id") Long id);

    @POST("pessoas   ")
    Call<Pessoas> createPessoa(@Body Pessoas pessoas);

    @PUT("pessoas")
    Call<Pessoas> updatePessoa(@Path("id") Long id, Pessoas pessoas);

    @DELETE("pessoas")
    Call<Pessoas> deletePessoa(@Path("id") Long id);

}

