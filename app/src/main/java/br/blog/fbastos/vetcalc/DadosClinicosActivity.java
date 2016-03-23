package br.blog.fbastos.vetcalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class DadosClinicosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados_clinicos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("VetCalc - Parâmetros clínicos");

        final TextView txFc = (TextView) findViewById(R.id.textFC);
        final TextView txTemp = (TextView) findViewById(R.id.textTemp);
        final TextView txFr = (TextView) findViewById(R.id.textFR);
        final TextView txGestacao = (TextView) findViewById(R.id.textGestacao);

        final Spinner spinner = (Spinner) findViewById(R.id.spinnerEspecies);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.especies_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new EspeciesSpinnerActivity() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String nomeEspecie = spinner.getSelectedItem().toString();
                Animal especie = Config.getEspecies().get(nomeEspecie);
                if (especie == null) {
                    onNothingSelected(parent);
                    return;
                }
                txFc.setText(String.format("%1$.0f a %2$.0f BPM", especie.getFc().getMin(), especie.getFc().getMax()));
                txTemp.setText(String.format("%1$.1f a %2$.1f ºC", especie.getTemp().getMin(), especie.getTemp().getMax()));
                txFr.setText(String.format("%1$.0f a %2$.0f MPM", especie.getFr().getMin(), especie.getFr().getMax()));
                txGestacao.setText(String.format("%1$.0f a %2$.0f dias", especie.getGestacao().getMin(), especie.getGestacao().getMax()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String empty = "";
                txFc.setText(empty);
                txTemp.setText(empty);
                txFr.setText(empty);
                txGestacao.setText(empty);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        if (id == R.id.action_dosagem) {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_prenhez) {
            Intent i = new Intent(getApplicationContext(), PrenhezActivity.class);
            startActivity(i);
        }
        if (id == R.id.action_dadosClinicos) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
