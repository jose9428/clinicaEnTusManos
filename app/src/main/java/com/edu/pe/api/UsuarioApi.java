package com.edu.pe.api;

import com.edu.pe.modelo.Usuario;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UsuarioApi {
    @GET("UsuarioController.php")
    public Call<Usuario> Login(@Query("correo") String correo,@Query("pass") String pass,@Query("accion") String accion);

}
