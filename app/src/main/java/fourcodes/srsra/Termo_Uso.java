package fourcodes.srsra;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;

import static fourcodes.srsra.Volta.VoltaTela;

public class Termo_Uso extends AppCompatActivity {

    Context context = this;
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
                Voltar();
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
        Voltar();
    }

    private void Voltar() {
        if (VoltaTela(context, 9)) {
            finish();
        }
    }
}

