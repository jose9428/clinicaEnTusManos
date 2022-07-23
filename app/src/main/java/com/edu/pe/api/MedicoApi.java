package com.edu.pe.api;

import com.edu.pe.modelo.Medico;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MedicoApi {
    @GET("MedicoController.php")
    public Call<List<Medico>> listarMedicos( @Query("accion") String accion);
}
