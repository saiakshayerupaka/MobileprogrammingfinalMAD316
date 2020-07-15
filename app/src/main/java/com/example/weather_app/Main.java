package com.example.weather_app;

import android.os.Bundle;

import android.view.MenuItem;

import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.weatherapp.R;
import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class Main extends AppCompatActivity{

    private AppBarConfiguration mAppBarConfiguration;
    private  DrawerLayout drawer;
    private  NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        final NavigationView navigationView = findViewById(R.id.nav_view);

        MenuItem montreal = navigationView.getMenu().findItem(R.id.loc_montreal);
        navigationView.getMenu().performIdentifierAction(R.id.loc_montreal,0);
        montreal.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);

                Bundle bundle = new Bundle();
                bundle.putString("city","montreal");
                navController.navigate(R.id.nav_home, bundle);
                getSupportActionBar().setTitle("Montreal");
                return true;
            }
        });

        MenuItem newyork = navigationView.getMenu().findItem(R.id.loc_newyork);
        newyork.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);

                Bundle bundle = new Bundle();
                bundle.putString("city","newyork");
                navController.navigate(R.id.nav_home, bundle);
                getSupportActionBar().setTitle("Newyork");


                return true;
            }
        });

        MenuItem toronto = navigationView.getMenu().findItem(R.id.loc_toronto);
        toronto.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);

                Bundle bundle = new Bundle();
                bundle.putString("city","toronto");
                navController.navigate(R.id.nav_home, bundle);
                getSupportActionBar().setTitle("Toronto");

                return true;
            }
        });

        MenuItem vancouver = navigationView.getMenu().findItem(R.id.loc_vancouver);
        vancouver.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);

                Bundle bundle = new Bundle();
                bundle.putString("city","Vancouver");
                navController.navigate(R.id.nav_home, bundle);
                getSupportActionBar().setTitle("Vancouver");

                return true;
            }
        });

        MenuItem mumbai = navigationView.getMenu().findItem(R.id.loc_mumbai);
        mumbai.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);

                Bundle bundle = new Bundle();
                bundle.putString("city","Mumbai");
                navController.navigate(R.id.nav_home, bundle);
                getSupportActionBar().setTitle("Mumbai");

                return true;
            }
        });
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home)
                .setDrawerLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


}
