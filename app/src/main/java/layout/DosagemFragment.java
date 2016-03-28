package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import br.blog.fbastos.vetcalc.AnaliticsApp;
import br.blog.fbastos.vetcalc.Especies;
import br.blog.fbastos.vetcalc.Medidas;
import br.blog.fbastos.vetcalc.R;
import br.blog.fbastos.vetcalc.UnidadesDosagem;
import br.blog.fbastos.vetcalc.Util;

/**
 * A simple {@link Fragment} subclass.
 */
public class DosagemFragment extends Fragment {


    public DosagemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_dosagem, container, false);

        // Obtain the shared Tracker instance.
        AnaliticsApp application = (AnaliticsApp) getActivity().getApplication();
        Tracker mTracker = application.getDefaultTracker();
        mTracker.setScreenName("Dosagem");
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());


        Spinner spinner = (Spinner) v.findViewById(R.id.spinnerApresentacao);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getContext(),
                R.array.apresentacoes_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener();


        final Spinner spinnerApr = (Spinner) v.findViewById(R.id.spinnerUnidadeDosagem);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapterApr = ArrayAdapter.createFromResource(this.getContext(),
                R.array.unidades_dosagem_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapterApr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinnerApr.setAdapter(adapterApr);
        //spinner.setOnItemSelectedListener();


        Button btnCalc = (Button) v.findViewById(R.id.buttonCalc);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText txPeso = (EditText) v.findViewById(R.id.editTextPeso);
                EditText txDose = (EditText) v.findViewById(R.id.editTextDose);
                TextView txResultado = (TextView) v.findViewById(R.id.textViewResultado);

                double peso = Double.parseDouble(txPeso.getText().toString());
                double dose = Double.parseDouble(txDose.getText().toString());

                UnidadesDosagem unidDose = UnidadesDosagem.values()[spinnerApr.getSelectedItemPosition()];

                double resultado = 0;
                switch (unidDose) {

                    case MG_Kg:
                        resultado = dose * peso;
                        break;
                    case MG_M2_CANINO:
                        resultado = dose * Util.GetBodyAreaM2(Especies.CANINA, peso);
                        break;
                    case MG_M2_FELINA:
                        resultado = dose * Util.GetBodyAreaM2(Especies.FELINA, peso);
                        break;
                }


                txResultado.setText(String.format("%.1f", resultado));
                Spinner spinner = (Spinner) v.findViewById(R.id.spinnerApresentacao);
                int posItem = spinner.getSelectedItemPosition();
                TextView txResultadoApresentacao = (TextView) v.findViewById(R.id.textViewResultadoApresentacao);
                txResultadoApresentacao.setText("");
                if (posItem < 0) {
                    return;
                }

                EditText txApresentacao = (EditText) v.findViewById(R.id.editTextApresentacao);
                TextView txUnidadeResultadoApresentacao = (TextView) v.findViewById(R.id.textViewResultadoUnidadesApresentacao);
                String valorApresentacao = txApresentacao.getText().toString();
                if (valorApresentacao.length() == 0 || posItem < 0) {
                    return;
                }
                double apresentacao = Double.parseDouble(valorApresentacao);
                Medidas medida = Medidas.values()[posItem];

                switch (medida) {
                    case MG_COMP: {
                        double result = resultado / apresentacao;
                        txResultadoApresentacao.setText(String.format("%.1f", result));
                        txUnidadeResultadoApresentacao.setText(getResources().getText(R.string.comprimidos));
                    }
                    break;
                    case MG_ML: {
                        double result = resultado / apresentacao;
                        txResultadoApresentacao.setText(String.format("%.1f", result));
                        txUnidadeResultadoApresentacao.setText("mL");

                    }
                    break;
                    case PERCENT: {
                        double result = resultado / (apresentacao * 10);
                        txResultadoApresentacao.setText(String.format("%.1f", result));
                        txUnidadeResultadoApresentacao.setText("mL");
                    }
                    break;
                }

            }
        });
        return v;
    }

}
