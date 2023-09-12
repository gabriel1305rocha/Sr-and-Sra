package fourcodes.srsra;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

public class Manual_Usuario extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_usuario);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.canShowOverflowMenu();
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(Manual_Usuario.this, Sobre.class));
                finish();
            }
        });
        webView = (WebView) findViewById(R.id.webViewManual);
        //webView.setWebViewClient(new Callback);
        //webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(getString(R.string.link_manualuser));

        this.setTitle(R.string.title_manual);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Sobre.class));
        finish();
    }
}
