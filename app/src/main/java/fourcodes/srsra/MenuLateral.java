package fourcodes.srsra;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import static fourcodes.srsra.FuncoesMenuLateral.ClickMenuOpt;

public class MenuLateral extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static Menu mOptionsMenu;
    static int Position = 0;
    static int OptionValue = 0;
    static boolean Option = false;
    protected Toolbar toolbar;
    int MenuPos = 0;
    NavigationView navigationView;
    Context context = this;
    Intent intent = getIntent();

    static void OptionsSet(Menu menu) {
        if (Option) {
            menu.getItem(0).setVisible(false);
            menu.getItem(1).setVisible(false);
            menu.getItem(2).setVisible(false);
            menu.getItem(3).setVisible(false);
            menu.getItem(4).setVisible(false);
            menu.getItem(5).setVisible(false);
            menu.getItem(6).setVisible(false);
            menu.getItem(7).setVisible(false);
            menu.getItem(8).setVisible(false);
        }

        switch (OptionValue) {
            case 1:
                menu.getItem(5).setVisible(true);
                break;
            case 10:
                menu.getItem(5).setVisible(true);
                menu.getItem(4).setVisible(true);
                break;
            case 3:
                menu.getItem(0).setVisible(true);
                break;
            case 4:
                menu.getItem(3).setVisible(true);
                break;
            case 5:
                menu.getItem(1).setVisible(true);
                break;
            case 50:
                menu.getItem(8).setVisible(true);
                break;
            case 6:
                menu.getItem(2).setVisible(true);
                break;
            case 7:
                menu.getItem(6).setVisible(true);
                menu.getItem(7).setVisible(true);
                break;
        }
    }

    public static void setPosition(int position) {
        Position = position;
    }

    public static void setOptionValue(int optionValue) {
        OptionValue = optionValue;
        OptionsSet(mOptionsMenu);
    }

    /**
     * Position Values
     * 0 = Inicio
     * 1 = Despesas
     * 2 = Checklist
     * 3 = Padrinhos
     * 4 = Convidados
     * 5 = Fornecedores
     * 6 = Daminha
     * 7 = Presente
     * 8 = Configurações
     * 9 = Sobre
     */

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

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(Position).setChecked(true);

        SetTela(Position);
    }

    private void SetTela(int pos) {
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setVisibility(View.GONE);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        frameLayout.setVisibility(View.VISIBLE);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setVisibility(View.GONE);
        switch (pos) {
            case 0:
                this.setTitle(R.string.title_Inicio);
                MenuPos = 0;
                Contagem Fragment1 = new Contagem();
                FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
                transaction1.replace(R.id.frameLayout, Fragment1, getString(R.string.title_Inicio));
                transaction1.commit();
                break;
            case 1:
                this.setTitle(R.string.title_despesas);
                MenuPos = 2;
                TabBar(0);
                break;
            case 2:
                this.setTitle(R.string.title_checklist);
                MenuPos = 1;
                Checklist Fragment3 = new Checklist();
                FragmentTransaction transaction3 = getSupportFragmentManager().beginTransaction();
                transaction3.replace(R.id.frameLayout, Fragment3, getString(R.string.title_checklist));
                transaction3.commit();
                break;
            case 3:
                this.setTitle(R.string.title_padrinhos);
                MenuPos = 4;
                Padrinhos Fragment4 = new Padrinhos();
                FragmentTransaction transaction4 = getSupportFragmentManager().beginTransaction();
                transaction4.replace(R.id.frameLayout, Fragment4, getString(R.string.title_padrinhos));
                transaction4.commit();
                break;
            case 4:
                this.setTitle(R.string.title_convidados);
                MenuPos = 3;
                TabBar(1);
                break;
            case 5:
                this.setTitle(R.string.title_fornecedor);
                MenuPos = 6;
                TabBar(2);
                break;
            case 6:
                this.setTitle(R.string.title_daminha);
                MenuPos = 5;
                Daminha Fragment7 = new Daminha();
                FragmentTransaction transaction7 = getSupportFragmentManager().beginTransaction();
                transaction7.replace(R.id.frameLayout, Fragment7, getString(R.string.title_daminha));
                transaction7.commit();
                break;
            case 7:
                this.setTitle(R.string.title_lista_presente);
                MenuPos = 7;
                ListaPresente Fragment8 = new ListaPresente();
                FragmentTransaction transaction8 = getSupportFragmentManager().beginTransaction();
                transaction8.replace(R.id.frameLayout, Fragment8, getString(R.string.title_lista_presente));
                transaction8.commit();
                break;
            case 8:
                this.setTitle(R.string.title_configura);
                MenuPos = 8;
                Configura Fragment9 = new Configura();
                FragmentTransaction transaction9 = getSupportFragmentManager().beginTransaction();
                transaction9.replace(R.id.frameLayout, Fragment9, getString(R.string.title_configura));
                transaction9.commit();
                break;
            case 9:
                this.setTitle(R.string.title_sobre);
                MenuPos = 9;
                Sobre Fragment10 = new Sobre();
                FragmentTransaction transaction10 = getSupportFragmentManager().beginTransaction();
                transaction10.replace(R.id.frameLayout, Fragment10, getString(R.string.title_sobre));
                transaction10.commit();
                break;
            default:
                this.setTitle("");
                break;
        }
        SetChecked();
        setOptionValue(pos);
    }

    private void TabBar(int Num) {
        final FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        frameLayout.setVisibility(View.GONE);
        viewPager.setVisibility(View.VISIBLE);
        tabLayout.setVisibility(View.VISIBLE);
        tabLayout.removeAllTabs();
        switch (Num) {
            case 0:

                tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_Geral));
                tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_Mensal));
                tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_Item));
                tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

                final PageAdapterDes adapter = new PageAdapterDes
                        (getSupportFragmentManager(), tabLayout.getTabCount());
                viewPager.setAdapter(adapter);
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                        if (tab.getPosition() == 2) {
                            setOptionValue(10);
                        }
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        if (tab.getPosition() == 2) {
                            setOptionValue(1);
                        }
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
                break;
            case 1:

                tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_Resumo));
                tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_Todos));
                tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_Convites));
                tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

                final PageAdapterConv ConvAdapter = new PageAdapterConv
                        (getSupportFragmentManager(), tabLayout.getTabCount());
                viewPager.setAdapter(ConvAdapter);
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
                break;
            case 2:

                tabLayout.addTab(tabLayout.newTab().setText("Meus Fornecedores"));
                tabLayout.addTab(tabLayout.newTab().setText("Fornecedores"));
                tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

                final PageAdapterForn ForAdapter = new PageAdapterForn
                        (getSupportFragmentManager(), tabLayout.getTabCount());
                viewPager.setAdapter(ForAdapter);
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewPager.setCurrentItem(tab.getPosition());
                        if(tab.getPosition() == 1){
                            setOptionValue(50);
                        }else
                            setOptionValue(5);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
                break;
            default:
                break;
        }
    }

    private void SetChecked() {
        navigationView.getMenu().getItem(MenuPos).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (Position == 0) {
                super.onBackPressed();
            } else {
                Position = 0;
                SetTela(Position);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lateral, menu);
        mOptionsMenu = menu;
        menu.getItem(0).setVisible(false);
        menu.getItem(1).setVisible(false);
        menu.getItem(2).setVisible(false);
        menu.getItem(3).setVisible(false);
        menu.getItem(4).setVisible(false);
        menu.getItem(5).setVisible(false);
        menu.getItem(6).setVisible(false);
        menu.getItem(7).setVisible(false);
        menu.getItem(8).setVisible(false);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (ClickMenuOpt(item, this)) {
            finish();
        } else {
            return false;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        item.setChecked(true);
        Option = true;
        //onNavigationItemSelected(navigationView.getMenu().getItem(0));

        //Check to see which item was being clicked and perform appropriate action
        switch (item.getItemId()) {
            case R.id.nav_inicio:
                Position = 0;
                break;
            case R.id.nav_despesas:
                Position = 1;
                break;
            case R.id.nav_checklist:
                Position = 2;
                break;
            case R.id.nav_padrinho:
                Position = 3;
                break;
            case R.id.nav_convidado:
                Position = 4;
                break;
            case R.id.nav_fornecedor:
                Position = 5;
                break;
            case R.id.nav_daminhas:
                Position = 6;
                break;
            case R.id.nav_presente:
                Position = 7;
                break;
            case R.id.nav_configu:
                Position = 8;
                break;
            case R.id.nav_info:
                Position = 9;
                break;
            default:
                break;
        }
        SetTela(Position);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if (Option) {
            menu.getItem(0).setVisible(false);
            menu.getItem(1).setVisible(false);
            menu.getItem(2).setVisible(false);
            menu.getItem(3).setVisible(false);
            menu.getItem(4).setVisible(false);
            menu.getItem(5).setVisible(false);
            menu.getItem(6).setVisible(false);
            menu.getItem(7).setVisible(false);
        }

        switch (OptionValue) {
            case 1:
                menu.getItem(5).setVisible(true);
                break;
            case 10:
                menu.getItem(5).setVisible(true);
                menu.getItem(4).setVisible(true);
                break;
            case 3:
                menu.getItem(0).setVisible(true);
                break;
            case 4:
                menu.getItem(3).setVisible(true);
                break;
            case 5:
                menu.getItem(1).setVisible(true);
                break;
            case 6:
                menu.getItem(2).setVisible(true);
                break;
            case 7:
                menu.getItem(6).setVisible(true);
                menu.getItem(7).setVisible(true);
                break;
        }
        return true;
    }
}