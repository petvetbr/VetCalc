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
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class PrenhezActivity extends AppCompatActivity {

    public static java.util.Calendar getCalendarFromDatePicker(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prenhez);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("VetCalc - Data parto");

        Spinner spinner = (Spinner) findViewById(R.id.spinnerEspecies);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.especies_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener();

        Button btnCalc = (Button) findViewById(R.id.buttonCalcPrenhez);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinner = (Spinner) findViewById(R.id.spinnerEspecies);
                String especieSelecionada = spinner.getSelectedItem().toString();
                HashMap<String, Animal> especies = Config.getEspecies();
                Animal especie = especies.get(especieSelecionada);

                DatePicker datePicker = (DatePicker) findViewById(R.id.datePickerFecundação);
                Calendar dataMin = getCalendarFromDatePicker(datePicker);
                Calendar dataMax = getCalendarFromDatePicker(datePicker);
                dataMin.add(Calendar.DATE, (int) especie.getGestacao().getMin());
                dataMax.add(Calendar.DATE, (int) especie.getGestacao().getMax());
                TextView txMin = (TextView) findViewById(R.id.textViewResultadoMin);
                TextView txMax = (TextView) findViewById(R.id.textViewResultadoMax);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                txMin.setText(format.format(dataMin.getTime()));
                txMax.setText(format.format(dataMax.getTime()));
            }
        });
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
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);
            return true;
        }
        if (id == R.id.action_prenhez) {
            return true;

        }
        if (id == R.id.action_dadosClinicos) {
            Intent i = new Intent(getApplicationContext(), DadosClinicosActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
