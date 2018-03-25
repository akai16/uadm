package com.example.saint.ultimoaplicativodomundo.views;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.saint.ultimoaplicativodomundo.R;
import com.example.saint.ultimoaplicativodomundo.fragments.BoquetitosGifsFragment;
import com.example.saint.ultimoaplicativodomundo.fragments.DanielGifsFragment;
import com.example.saint.ultimoaplicativodomundo.fragments.OutrosGifsFragment;
import com.example.saint.ultimoaplicativodomundo.fragments.RogerinhoGifsFragment;
import com.example.saint.ultimoaplicativodomundo.fragments.ViceConsulFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass = null;

        if (id == R.id.nav_daniel) {
            fragmentClass = DanielGifsFragment.class;
        } else if (id == R.id.nav_vice_consul) {
            fragmentClass = ViceConsulFragment.class;
        } else if (id == R.id.nav_rogerinho) {
            fragmentClass = RogerinhoGifsFragment.class;
        } else if (id == R.id.nav_boquetitos) {
            fragmentClass = BoquetitosGifsFragment.class;
        } else if (id == R.id.nav_outros) {
            fragmentClass = OutrosGifsFragment.class;
        } else if (id == R.id.nav_daniel_sounds) {
            //fragmentClass = DanielSoundsFragment.class;
        } else if (id == R.id.nav_vice_consul_sounds) {
            //fragmentClass = ViceConsulSoundsFragment.class;
        } else if (id == R.id.nav_rogerinho_sounds) {
            //fragmentClass = ViceConsulSoundsFragment.class;
        } else if (id == R.id.nav_boquetitos_sounds){
            //fragmentClass = BoquetitosSoundsFragment.class;
        } else if (id == R.id.nav_outros_sounds){
            //fragmentClass = OutrosSoundsFragment.class;
        }

        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.frame_content, fragment).commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
