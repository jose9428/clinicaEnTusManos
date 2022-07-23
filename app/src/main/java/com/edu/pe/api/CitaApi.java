package com.edu.pe.api;

import com.edu.pe.modelo.Citas;
import com.edu.pe.modelo.Medico;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CitaApi {
    @GET("CitaController.php")
    public Call<List<Citas>> listarMisCitas(@Query("accion") String accion,@Query("idPac") int idPac);
}
