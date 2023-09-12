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
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.facebook.login.LoginManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static fourcodes.srsra.FuncoesMenuLateral.ClickMenuNav;
import static fourcodes.srsra.FuncoesMenuLateral.ClickMenuOpt;

public class Checklist extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checklist);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_checklist);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        this.setTitle(R.string.title_checklist);

        ListView lstChek = (ListView) findViewById(R.id.lstChek);
        ArrayList<String> Menus = preencherdados();
        ArrayAdapter<String> ArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Menus);
        lstChek.setAdapter(ArrayAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_checklist);
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
        getMenuInflater().inflate(R.menu.menu_lateral, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (ClickMenuOpt(item, this)){
            finish();
        } else {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if(ClickMenuNav(item, this)){
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.activity_checklist);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private ArrayList<String> preencherdados() {
        ArrayList<String> dados = new ArrayList<String>();
        dados.add("Um ano antes");
        dados.add("Des meses ates");
        dados.add("oito meses antes");
        dados.add("seis meses antes");
        dados.add("tres meses antes");
        dados.add("dois meses antes");
        dados.add("Um mes antes");
        dados.add("quinze dias antes");
        dados.add("uma semana antes");
        dados.add("dois dias antes");
        dados.add("Um dia antes");
        dados.add("o grande dia");
        dados.add("na volta da lua de meu");
        return dados;
    }
}