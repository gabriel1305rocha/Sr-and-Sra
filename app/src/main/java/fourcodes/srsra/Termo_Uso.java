package fourcodes.srsra;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.support.v7.widget.Toolbar;

public class Termo_Uso extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termo_uso);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.canShowOverflowMenu();
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Termo_Uso.this, Sobre.class));
                finish();
            }
        });

        webView = (WebView) findViewById(R.id.webViewTermo);
        //webView.setWebViewClient(new Callback);
        //webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(getString(R.string.link_termouso));

        this.setTitle(R.string.title_termo);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Sobre.class));
        finish();
    }
}

