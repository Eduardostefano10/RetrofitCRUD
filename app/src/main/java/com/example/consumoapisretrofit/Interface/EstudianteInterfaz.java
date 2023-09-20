package com.example.consumoapisretrofit.Interface;

import com.example.consumoapisretrofit.Dto.EstudianteDto;
import com.example.consumoapisretrofit.Model.Estudiante;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface EstudianteInterfaz {
    @GET("listar")
    Call<List<Estudiante>> getAll();
    @POST("agregar")
    Call<Estudiante> create(@Body EstudianteDto dto);
    @PUT("{/id}")
    Call<Estudiante> edit(@Path("id") int id, @Body EstudianteDto dto);
    @DELETE("/{id}")
    Call<Estudiante> delete(@Path("id") int id);

}
