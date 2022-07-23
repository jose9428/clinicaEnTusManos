package com.edu.pe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainRegistraCuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registra_cuenta);
    }

    public void RegistrarCuenta(View v){
        Intent intent = new Intent(this , MainRegistraCuenta.class);
        startActivity(intent);
    }

    public void IniciarSesion(View v){
        Intent intent = new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}