package com.edu.pe.api;

import com.edu.pe.modelo.APIResponse;
import com.edu.pe.modelo.Usuario;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PacienteApi {
    @GET("UsuarioController.php")
    public Call<APIResponse> Registrar(@Query("correo") String correo,
                                       @Query("pass") String pass,
                                       @Query("fechaNac") String fechaNac,
                                       @Query("dni") String dni,
                                       @Query("nombres") String nombres,
                                       @Query("apellidos") String apellidos,
                                       @Query("accion") String accion);

}
