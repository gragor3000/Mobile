package com.example.mic.atelier1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    Button btnSubmit;//bouton qui calcule le pourboire
    NumberPicker nbPickTip;//choix du pourcentage
    Spinner spPer;//spinner du nombre de choix de personne
    EditText txtMontant;//Edit text du montant
    ToggleButton tgTaxe;//toggle de taxe
    float Montant;
    float Total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set le onclick du button et le button
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);

        //set le number picker
        nbPickTip = (NumberPicker) findViewById(R.id.nbPickTip);
        nbPickTip.setMaxValue(25);
        nbPickTip.setMinValue(5);
        nbPickTip.setWrapSelectorWheel(true);

        //set le spinner
        spPer = (Spinner) findViewById(R.id.spPer);
        List<String> Personne = new ArrayList<String>();//choix pour les personnes
        Personne.add("1");
        Personne.add("2");
        Personne.add("3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Personne);
        spPer.setAdapter(dataAdapter);

        //set l'editText
        txtMontant = (EditText) findViewById(R.id.txtMontant);

        //set le toggle de taxe
        tgTaxe = (ToggleButton) findViewById(R.id.tgTaxe);
    }

    @Override
    public void onClick(View v)//fait afficher un message s'il ne mais pas de montant
    {
        //si il n'a pas entré de montant
        if (txtMontant.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Veuillez mettre un montant",
                    Toast.LENGTH_SHORT).show();

        } else {
            Montant = Integer.parseInt(txtMontant.getText().toString());
            Total = Montant;

            if(tgTaxe.isChecked())//si on calcul les taxes
            {
                Total = Total + Total* (float)(0.15);
            }
            //calcul le pourboir
            Total = Total* ((float)nbPickTip.getValue() /100);
            //calcul le montant par personne
            Total = Total/ Float.parseFloat(spPer.getSelectedItem().toString());
            Total = new BigDecimal(Total).setScale(2, RoundingMode.HALF_UP).floatValue();
            Toast.makeText(getApplicationContext(), Float.toString(Total),
                    Toast.LENGTH_SHORT).show();

            //envoi les valeurs à l'autre activité
           /* Intent startbuttonintent = new Intent(this, SecondActivity.class);
            startbuttonintent.putExtra("Montant",Montant);
            startbuttonintent.putExtra("tgTaxe",tgTaxe.isChecked());
            startbuttonintent.putExtra("nbPickTip",nbPickTip.getValue());
            startbuttonintent.putExtra("spPer",spPer.getSelectedItem().toString());
            startbuttonintent.putExtra("Total",Total);
            startActivity(startbuttonintent);*/





        }
    }
}
