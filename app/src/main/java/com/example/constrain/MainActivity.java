package com.example.constrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.WindowManager;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class MainActivity extends AppCompatActivity {
    ChipNavigationBar chipNavigationBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        chipNavigationBar = findViewById(R.id.bottom_menu);
        chipNavigationBar.setItemSelected(R.id.home,true);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_bar,new Home_frag()).commit();
        bottomMenu();
    }

    private void bottomMenu(){

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.home:
                        fragment = new Home_frag();
                        break;
                    case R.id.orders:
                        fragment = new Orders_frag();
                        break;
                    case R.id.profile:
                        fragment = new Profile_frag();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_bar,fragment).commit();
                }
        });
    }
}