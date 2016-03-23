package br.blog.fbastos.vetcalc;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

public class EspeciesSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

    // protected TextView txFc;
//    protected TextView txFr;
//    protected TextView txTemp;
//    protected TextView txGest;
//    public EspeciesSpinnerActivity(TextView txFc_, TextView txFr_,TextView txTemp_,TextView txGest_)
//    {
//        //txFc=txFc_;
//        txFr=txFr_;
//        txGest=txGest_;
//        txTemp=txTemp_;
//
//    }
    public void onItemSelected(AdapterView<?> parent, View view,
                               int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        // parent.getItemAtPosition(pos)
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }
}
