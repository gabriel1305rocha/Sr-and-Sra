package fourcodes.srsra;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.facebook.login.LoginManager;

public class Configura extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configura);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_configura);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this.setTitle(R.string.title_configura);

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_configura);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
            startActivity(new Intent(this, MenuLateral.class));
            finish();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lateral, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }  else if (id == R.id.nav_sair) {
            LoginManager.getInstance().logOut();
            startActivity(new Intent(this, Inicio.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            startActivity(new Intent(this, MenuLateral.class));
            finish();
        } else if (id == R.id.nav_checklist) {

        } else if (id == R.id.nav_padrinho) {

        } else if (id == R.id.nav_convidado) {
            startActivity(new Intent(this, Convidados.class));
            finish();
        } else if (id == R.id.nav_despesas) {
            startActivity(new Intent(this, Despesas.class));
            finish();
        } else if (id == R.id.nav_fornecedor) {

        } else if (id == R.id.nav_configu) {

        } else if (id == R.id.nav_info) {
            startActivity(new Intent(this, Sobre.class));
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_configura);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
