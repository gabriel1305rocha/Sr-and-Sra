package fourcodes.srsra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.login.LoginManager;

import static fourcodes.srsra.Splash.*;

public class MenuLateral extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_lateral);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ViewStub stub = (ViewStub) findViewById(R.id.view_stub);
        stub.setLayoutResource(R.layout.activity_contagem);
        View inflated = stub.inflate();
        this.setTitle(R.string.title_Inicio);

        Atualiza();
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
        getMenuInflater().inflate(R.menu.menu_lateral, menu);
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
            /*ViewStub stub = (ViewStub) findViewById(R.id.view_stub);
            stub.setLayoutResource(R.layout.activity_contagem);
            View inflated = stub.inflate();
            this.setTitle("Contagem");*/
            // Handle the inicio action
        } else if (id == R.id.nav_checklist) {

        } else if (id == R.id.nav_padrinho) {

        } else if (id == R.id.nav_convidado) {

        } else if (id == R.id.nav_despesas) {

        } else if (id == R.id.nav_fornecedor) {

        } else if (id == R.id.nav_configu) {

        } else if (id == R.id.nav_info) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void Atualiza(){
        String NomeParceiro = "Lucinda";
        Integer dia = 350;

        TextView nomeSr = (TextView) findViewById(R.id.lblNomeNoivo);
        TextView nomeSra = (TextView) findViewById(R.id.lblNomeNoiva);
        TextView diaResta = (TextView) findViewById(R.id.lblDiaRestaNum);
        ProgressBar barraDia = (ProgressBar) findViewById(R.id.progressBar);

        if(SexoUser == "male") {
            nomeSr.setText("Sr. " + NomeUser);
            nomeSra.setText("Sra. " + NomeParceiro);
        }else{
            nomeSra.setText("Sra. " + NomeUser);
            nomeSr.setText("Sr. " + NomeParceiro);
        }
        diaResta.setText(" "+dia+" ");
    }
}
