package com.example.mic.atelier1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mic on 28/01/2016.
 */


public class SecondActivity extends Activity {

    NumberPicker nbPickTip;//choix du pourcentage
    Spinner spPer;//spinner du nombre de choix de personne
    EditText txtMontant;//Edit text du montant
    ToggleButton tgTaxe;//toggle de taxe
    EditText txtTotal;//edit text du total du tip

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

        //set l'editText de Montant
        txtMontant = (EditText) findViewById(R.id.txtMontant);

        //set l'editText de Total
        txtTotal = (EditText) findViewById(R.id.txtTotal);

        //set le toggle de taxe
        tgTaxe = (ToggleButton) findViewById(R.id.tgTaxe);

        //set le spinner
        spPer = (Spinner) findViewById(R.id.spPer);

        //set le number picker
        nbPickTip = (NumberPicker) findViewById(R.id.nbPickTip);

        Bundle extras = getIntent().getExtras();
        txtMontant.setText(Float.toString(extras.getFloat("Montant")));
        tgTaxe.setChecked(extras.getBoolean("tgText"));
        nbPickTip.setValue(extras.getInt("nbPickTip"));
        txtTotal.setText(Float.toString(extras.getFloat("Total")));
        spPer.setSelection(extras.getInt("spPer"));


        nbPickTip.setMaxValue(25);
        nbPickTip.setMinValue(5);
        nbPickTip.setWrapSelectorWheel(true);


        List<String> Personne = new ArrayList<String>();//choix pour les personnes
        Personne.add("1");
        Personne.add("2");
        Personne.add("3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Personne);
        spPer.setAdapter(dataAdapter);


    }
}
