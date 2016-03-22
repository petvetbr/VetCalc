package br.blog.fbastos.vetcalc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Spinner spinner = (Spinner) findViewById(R.id.spinnerApresentacao);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.apresentacoes_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener();


        Button btnCalc = (Button) findViewById(R.id.buttonCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txPeso = (EditText) findViewById(R.id.editTextPeso);
                EditText txDose = (EditText) findViewById(R.id.editTextDose);
                TextView txResultado = (TextView) findViewById(R.id.textViewResultado);

                double peso = Double.parseDouble(txPeso.getText().toString());
                double dose = Double.parseDouble(txDose.getText().toString());
                double resultado = dose * peso;
                txResultado.setText(Double.toString(resultado));
                Spinner spinner = (Spinner) findViewById(R.id.spinnerApresentacao);
                int posItem = spinner.getSelectedItemPosition();
                if (posItem < 0) return;
                EditText txApresentacao = (EditText) findViewById(R.id.editTextApresentacao);
                TextView txResultadoApresentacao = (TextView) findViewById(R.id.textViewResultadoApresentacao);
                TextView txUnidadeResultadoApresentacao = (TextView) findViewById(R.id.textViewResultadoUnidadesApresentacao);
                String valorApresentacao = txApresentacao.getText().toString();

                if (valorApresentacao.length() == 0 || posItem < 0) {
                    txResultadoApresentacao.setText("");
                    return;
                }
                double apresentacao = Double.parseDouble(valorApresentacao);
                switch (posItem) {
                    case 0: {
                        double result = resultado / apresentacao;
                        txResultadoApresentacao.setText(Double.toString(result));
                        txUnidadeResultadoApresentacao.setText("Comprimido(s)");
                    }
                    break;
                    case 1: {
                        double result = resultado / apresentacao;
                        txResultadoApresentacao.setText(Double.toString(result));
                        txUnidadeResultadoApresentacao.setText("mL");
                    }
                    break;
                    case 2: {
                        double result = resultado / (apresentacao * 10);
                        txResultadoApresentacao.setText(Double.toString(result));
                        txUnidadeResultadoApresentacao.setText("mL");
                    }
                    break;
                }


            }
        });

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
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

//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        if (id == R.id.action_dosagem) {
            return true;
        }
        if (id == R.id.action_prenhez) {
            Intent i = new Intent(getApplicationContext(), PrenhezActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onPesoChange() {
        return false;
    }
}
