package com.edu.pe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.pe.api.PacienteApi;
import com.edu.pe.api.UsuarioApi;
import com.edu.pe.conexion.ConexionAPI;
import com.edu.pe.modelo.APIResponse;
import com.edu.pe.modelo.Paciente;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainRegistraCuenta extends AppCompatActivity {
    EditText txtCorreo , txtPass, txtDni , txtFechaNac , txtNombres, txtApellidos;

    PacienteApi api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra_cuenta);
        txtApellidos=(EditText) findViewById(R.id.lbApellidos);
        txtDni=(EditText) findViewById(R.id.lbDNI);
        txtFechaNac=(EditText) findViewById(R.id.lbFechaNac);
        txtNombres=(EditText) findViewById(R.id.lbNombres);
        txtCorreo=(EditText) findViewById(R.id.lbCorreo);
        txtPass=(EditText) findViewById(R.id.lbPassword);

        api = ConexionAPI.getConnection().create(PacienteApi.class);
    }

    public void RegistrarCuenta(View v){
        Paciente obj = new Paciente();
        obj.setFecha_Nacimiento(txtFechaNac.getText().toString());
        obj.setCorreo(txtCorreo.getText().toString());
        obj.setPass(txtPass.getText().toString());
        obj.setNombres(txtNombres.getText().toString());
        obj.setApellidos(txtApellidos.getText().toString());
        obj.setDni(txtDni.getText().toString());

        Call<APIResponse> call = api.Registrar(obj.getCorreo(), obj.getPass(), obj.getFecha_Nacimiento(),
                obj.getDni(),obj.getNombres(),obj.getApellidos(),"registro");

        call.enqueue(new Callback<APIResponse>() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    APIResponse resp = (APIResponse)response.body();

                    if(resp.getResultado().equals("1")){
                        LimpiarCasillas();
                        Toast.makeText(getApplicationContext() , "Cuenta creada de forma correcta", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext() , "No se ha podido crear cuenta", Toast.LENGTH_LONG).show();
                    }
                }

            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Log.w("Error respuesta:" ,""+ t.toString());
                Toast.makeText(getApplicationContext() , "Error al procesar los datos" , Toast.LENGTH_LONG).show();
            }
        });
    }

    public void LimpiarCasillas(){
        txtPass.setText("");
        txtCorreo.setText("");
        txtApellidos.setText("");
        txtNombres.setText("");
        txtDni.setText("");
        txtFechaNac.setText("");
    }

    public void IniciarSesion(View v){
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}