package com.edu.pe.vista.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.edu.pe.R;
import com.edu.pe.api.MedicoApi;
import com.edu.pe.api.PacienteApi;
import com.edu.pe.conexion.ConexionAPI;
import com.edu.pe.modelo.APIResponse;
import com.edu.pe.modelo.Medico;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservaCitaFragment extends Fragment
        implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Button btnRegistrar;
    MedicoApi apiMedico;
    List<Medico> listaMedicos;
    Spinner spinnMedicos;
    Spinner spinnTiposCitas;

    String dataTipos[] = { "Cognitivo conductual Aceptación y compromiso",
            "Terapia Breve Terapia positiva" ,
            "Psicodinámica Sistémica"};
    public ReservaCitaFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_reserva_cita, container, false);
        btnRegistrar = (Button) view.findViewById(R.id.btnRegistrar);
        spinnMedicos = (Spinner) view.findViewById(R.id.spMedicos);
        spinnTiposCitas = (Spinner) view.findViewById(R.id.spTiposCitas);
        btnRegistrar.setOnClickListener(this);
        spinnMedicos.setOnItemSelectedListener(this);
        spinnTiposCitas.setOnItemSelectedListener(this);
        apiMedico= ConexionAPI.getConnection().create(MedicoApi.class);

        ArrayAdapter adapta = new ArrayAdapter<String>(getContext() ,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item ,
                dataTipos);
        spinnTiposCitas.setAdapter(adapta);
        ListarMedicos();
        return view;
    }

    public void ListarMedicos(){
        Call<List<Medico>> call = apiMedico.listarMedicos("listarTodos");

        call.enqueue(new Callback<List<Medico>>() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    listaMedicos = (List<Medico>)response.body();
                    List<String> data = new ArrayList<>();
                    for(Medico m : listaMedicos){
                        data.add(m.getApem_medico()+" "+m.getApep_medico()+" , "+m.getNom_medico());
                    }

                    ArrayAdapter adapta2 = new ArrayAdapter<String>(getContext() ,
                            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item ,
                            data);
                    spinnMedicos.setAdapter(adapta2);

                }

            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Log.w("Error respuesta:" ,""+ t.toString());
                Toast.makeText(getContext() , "Error al listar los datos" , Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnRegistrar:
                RegistrarCita();
                break;
        }
    }

    public void RegistrarCita(){
        Toast.makeText(getContext(),"Cita Creada!!",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}