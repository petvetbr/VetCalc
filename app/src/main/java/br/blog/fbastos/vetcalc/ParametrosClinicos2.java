package br.blog.fbastos.vetcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import layout.DosagemFragment;
import layout.PartoFragment;

public class ParametrosClinicos2 extends AppCompatActivity {

    private int lastSelectedId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parametros_clinicos2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("VetCalc - Dosagem");

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.raiz, new DosagemFragment())
                .addToBackStack(null)
                .commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == lastSelectedId) {
            return true;
        }

        if (id == R.id.action_dosagem) {
            setTitle("VetCalc - Dosagem");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.raiz, new DosagemFragment())
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        if (id == R.id.action_prenhez) {
            setTitle("VetCalc - Data de parto");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.raiz, new PartoFragment())
                    .addToBackStack(null)
                    .commit();
        }
        if (id == R.id.action_dadosClinicos) {
            setTitle("VetCalc - Parâmetros clínicos");
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.raiz, new ParametrosClinicos2Fragment())
                    .addToBackStack(null)
                    .commit();
        }
        return super.onOptionsItemSelected(item);
    }

}
