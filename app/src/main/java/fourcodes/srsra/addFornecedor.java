package fourcodes.srsra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class addFornecedor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_fornecedor);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Fornecedor.class));
        finish();
    }
}