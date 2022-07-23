package com.edu.pe.vista;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.edu.pe.MainActivity;
import com.edu.pe.R;
import com.edu.pe.vista.fragmentos.InicioFragment;
import com.edu.pe.vista.fragmentos.ReservaCitaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainMenuPrincipal extends AppCompatActivity {
    InicioFragment inicioFrag = new InicioFragment();
    ReservaCitaFragment reservaCitaFrag = new ReservaCitaFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        BottomNavigationView navigation = findViewById(R.id.bottomNavigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(reservaCitaFrag);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch(item.getItemId()){
                case R.id.nuevaCitaFragment:
                    loadFragment(reservaCitaFrag);
                    break;
                case R.id.misCitasFragment:
                    loadFragment(inicioFrag);
                    break;
                case R.id.logoutFragment:
                    Logout();
                    break;
            }
            return false;
        }
    };
    public void loadFragment(Fragment fragmento){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer, fragmento);
        transaction.commit();
    }

    public void Logout(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}