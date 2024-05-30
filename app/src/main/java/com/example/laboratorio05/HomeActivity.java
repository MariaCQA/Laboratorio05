package com.example.laboratorio05;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.laboratorio05.fragments.CuadrosFragment;
import com.example.laboratorio05.fragments.HomeFragment;
import com.example.laboratorio05.fragments.MapaFragment;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class HomeActivity extends AppCompatActivity {
private FragmentManager fragmentManager = null;
private FragmentTransaction fragmenTransaction= null;
private HomeFragment homeFragment = null;
private CuadrosFragment cuadrosFragment = null;
private MapaFragment mapaFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView welcomeText = findViewById(R.id.welcomeText);
        String username = getIntent().getStringExtra("username");

        // Utilizar el recurso de cadena con el marcador de posición
        String welcomeMessage = "Bienvenido {username}";
        welcomeText.setText(welcomeMessage);

        fragmentManager = getSupportFragmentManager();
        BottomNavigationView bottomNavigationItemView = findViewById((R.id.bottomNavigationView));
        bottomNavigationItemView.setSelectedItemId(R.id.menu_home);
        bottomNavigationItemView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.menu_home){
                    homeFragment =HomeFragment.newInstance("", "");
                    loadFragment(homeFragment);
                    return true;
                }else if(menuItem.getItemId()==R.id.menu_cuadros){
                    cuadrosFragment = CuadrosFragment.newInstance("", "");
                    loadFragment(cuadrosFragment);
                    return true;
                }else if(menuItem.getItemId()==R.id.menu_mapa){
                    mapaFragment =MapaFragment.newInstance("", "");
                    loadFragment(mapaFragment);
                    return true;
                }else{
                    return false;
                }


            }
        });
    }
    private void loadFragment(Fragment fragment){
        if(fragmentManager!=null){
            fragmenTransaction = fragmentManager.beginTransaction();
            fragmenTransaction.replace(R.id.fragmentContainerView, fragment);
            fragmenTransaction.commit();

        }
    }
}