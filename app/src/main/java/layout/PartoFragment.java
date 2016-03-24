package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import br.blog.fbastos.vetcalc.AnaliticsApp;
import br.blog.fbastos.vetcalc.Animal;
import br.blog.fbastos.vetcalc.Config;
import br.blog.fbastos.vetcalc.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PartoFragment extends Fragment {


    public PartoFragment() {
        // Required empty public constructor
    }

    public static java.util.Calendar getCalendarFromDatePicker(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        return calendar;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_parto, container, false);

        AnaliticsApp application = (AnaliticsApp) getActivity().getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("Parto");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());


        Spinner spinner = (Spinner) v.findViewById(R.id.spinnerEspecies);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.especies_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener();

        Button btnCalc = (Button) v.findViewById(R.id.buttonCalcPrenhez);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Spinner spinner = (Spinner) v.findViewById(R.id.spinnerEspecies);
                String especieSelecionada = spinner.getSelectedItem().toString();
                HashMap<String, Animal> especies = Config.getEspecies();
                Animal especie = especies.get(especieSelecionada);

                DatePicker datePicker = (DatePicker) v.findViewById(R.id.datePickerFecundação);
                Calendar dataMin = getCalendarFromDatePicker(datePicker);
                Calendar dataMax = getCalendarFromDatePicker(datePicker);
                dataMin.add(Calendar.DATE, (int) especie.getGestacao().getMin());
                dataMax.add(Calendar.DATE, (int) especie.getGestacao().getMax());
                TextView txMin = (TextView) v.findViewById(R.id.textViewResultadoMin);
                TextView txMax = (TextView) v.findViewById(R.id.textViewResultadoMax);
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                txMin.setText(format.format(dataMin.getTime()));
                txMax.setText(format.format(dataMax.getTime()));
            }
        });

        return v;

    }
}
