package fr.nathanchevalier.l3_tp1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Objects;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent intent = getIntent();

        int last_entier_1 = intent.getIntExtra("entier_1",0);
        int last_entier_2 = intent.getIntExtra("entier_2",0);

        final EditText entier_1 = findViewById(R.id.entier1);
        final EditText entier_2 = findViewById(R.id.entier2);

        entier_1.setText(Integer.toString(last_entier_1));
        entier_2.setText(Integer.toString(last_entier_2));

        final TextView result = findViewById(R.id.newresult);

        final Button calculer = findViewById(R.id.calculer);
        final Button effacer = findViewById(R.id.effacer);

        final RadioGroup radioGroup = findViewById(R.id.radiogroup);

        calculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Objects.equals(entier_1.getText().toString(), "") && !Objects.equals(entier_2.getText().toString(), "")) {
                    int valEntier1 = Integer.parseInt(entier_1.getText().toString());
                    int valEntier2 = Integer.parseInt(entier_2.getText().toString());

                    int btn = radioGroup.getCheckedRadioButtonId();
                    switch (btn) {
                        case R.id.radio_plus:
                            result.setText(String.valueOf(valEntier1 + valEntier2));
                            break;
                        case R.id.radio_moins:
                            result.setText(String.valueOf(valEntier1 - valEntier2));
                            break;
                        case R.id.radio_fois:
                            result.setText(String.valueOf(valEntier1 * valEntier2));
                            break;
                        case R.id.radio_diviser:
                            double dvalEntier1 = Double.parseDouble(String.valueOf(valEntier1));
                            double dvalEntier2 = Double.parseDouble(String.valueOf(valEntier2));
                            if (dvalEntier2 != 0) {
                                result.setText(String.valueOf(dvalEntier1 / dvalEntier2));
                            }
                            else
                                result.setText(" Erreur");
                            break;
                        case -1:
                            result.setText(" Erreur");
                            break;
                    }
                } else
                    result.setText(" Erreur");
            }
        });

        effacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier_1.setText("");
                entier_2.setText("");
                radioGroup.clearCheck();
            }
        });
    }
}
