package com.edu.pe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.pe.api.UsuarioApi;
import com.edu.pe.conexion.ConexionAPI;
import com.edu.pe.modelo.Usuario;
import com.edu.pe.vista.MainMenuPrincipal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    EditText txtCorreo , txtPass;
    UsuarioApi api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCorreo=(EditText) findViewById(R.id.lbCorreo);
        txtPass=(EditText) findViewById(R.id.lbPassword);
        txtCorreo.setText("manuel2@gmail.com");
        txtPass.setText("123456");
        api = ConexionAPI.getConnection().create(UsuarioApi.class);
    }

    public void IniciarSesion(View view){
        Usuario objUser = new Usuario();
        objUser.setCorreo(txtCorreo.getText().toString());
        objUser.setPass(txtPass.getText().toString());

        Call call = api.Login(objUser.getCorreo(), objUser.getPass(), "login");

        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if( response.body() != null){
                    IngresarMenuPrincipal();
                    Toast.makeText(getApplicationContext() , "Sesión Iniciada de forma correcta" , Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext() , "Correo y/o contraseña incorrecto" , Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext() , "Correo y/o clave contraseña" , Toast.LENGTH_LONG).show();
            }
        });
    }
    public void IngresarMenuPrincipal(){
        Intent intent = new Intent(this , MainMenuPrincipal.class);
        startActivity(intent);
    }
    public void RegistrarCuenta(View v){
        Intent intent = new Intent(this , MainRegistraCuenta.class);
        startActivity(intent);
    }
}