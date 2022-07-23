package com.edu.pe.vista.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.edu.pe.R;
import com.edu.pe.adaptador.CitaAdapter;
import com.edu.pe.api.CitaApi;
import com.edu.pe.api.MedicoApi;
import com.edu.pe.conexion.ConexionAPI;
import com.edu.pe.modelo.Citas;
import com.edu.pe.modelo.Medico;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InicioFragment extends Fragment {
    RecyclerView recy1;
    CitaApi api;
    List<Citas> listaCitas;
    public InicioFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_inicio, container, false);
        recy1 = (RecyclerView) view.findViewById(R.id.recyview1);
        recy1.setLayoutManager(new LinearLayoutManager(getContext()));
        api= ConexionAPI.getConnection().create(CitaApi.class);
        CargarMisCitas();
        return view;
    }

    public void CargarMisCitas(){
        retrofit2.Call<List<Citas>> call = api.listarMisCitas("listarTodos",1);

        call.enqueue(new Callback<List<Citas>>() {
            @Override
            public void onResponse(retrofit2.Call call, Response response) {
                if(response.isSuccessful()){
                    //  Log.w("lista" , response.body().toString());
                     listaCitas = (List<Citas>) response.body();
                     CitaAdapter adapta = new CitaAdapter(listaCitas);
                     recy1.setAdapter(adapta);
                   Log.w("citas", ""+listaCitas);
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getContext().getApplicationContext(), "Correo y/o clave contraseña" , Toast.LENGTH_LONG).show();
            }
        });
    }
}