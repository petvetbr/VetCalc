package br.blog.fbastos.vetcalc;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

/**
 * A placeholder fragment containing a simple view.
 */
public class ParametrosClinicos2Fragment extends Fragment {

    public ParametrosClinicos2Fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_parametros_clinicos2, container, false);

        AnaliticsApp application = (AnaliticsApp) getActivity().getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("Paramtros");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());



        final TextView txFc = (TextView) v.findViewById(R.id.textFC);
        final TextView txTemp = (TextView) v.findViewById(R.id.textTemp);
        final TextView txFr = (TextView) v.findViewById(R.id.textFR);
        final TextView txGestacao = (TextView) v.findViewById(R.id.textGestacao);


        final Spinner spinner = (Spinner) v.findViewById(R.id.spinnerEspecies);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(),
                R.array.especies_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        return v;
    }
}
