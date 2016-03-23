package br.blog.fbastos.vetcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import layout.PartoFragment;

public class ParametrosClinicos2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametros_clinicos2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("VetCalc - Parâmetros clínicos");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.raiz, new PartoFragment())
                .addToBackStack(null)
                .commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
