package fr.nathanchevalier.l3_tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result = findViewById(R.id.result);

        final EditText entier_1 = findViewById(R.id.entier1);
        final EditText entier_2 = findViewById(R.id.entier2);

        final Button button_diviser = findViewById(R.id.diviser);
        final Button button_additioner = findViewById(R.id.plus);
        final Button button_soustraire = findViewById(R.id.moins);
        final Button button_multiplier = findViewById(R.id.fois);

        final Button button_effacer = findViewById(R.id.effacer);

        final Button button_newactivity = findViewById(R.id.newactivity);

        button_diviser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Objects.equals(entier_1.getText().toString(), "") && !Objects.equals(entier_2.getText().toString(), "")) {
                    double valEntier1 = Double.parseDouble(entier_1.getText().toString());
                    double valEntier2 = Double.parseDouble(entier_2.getText().toString());
                    double value = valEntier1 / valEntier2;
                    if (valEntier2 != 0)
                        result.setText(String.valueOf(value));
                    else
                        result.setText(" Erreur");
                } else
                    result.setText(" Erreur");
            }
        });

        button_multiplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Objects.equals(entier_1.getText().toString(), "") && !Objects.equals(entier_2.getText().toString(), "")) {
                    int valEntier1 = Integer.parseInt(entier_1.getText().toString());
                    int valEntier2 = Integer.parseInt(entier_2.getText().toString());
                    int value = valEntier1 * valEntier2;
                    result.setText(String.valueOf(value));
                } else
                    result.setText(" Erreur");
            }
        });

        button_soustraire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Objects.equals(entier_1.getText().toString(), "") && !Objects.equals(entier_2.getText().toString(), "")) {
                    int valEntier1 = Integer.parseInt(entier_1.getText().toString());
                    int valEntier2 = Integer.parseInt(entier_2.getText().toString());
                    int value = valEntier1 - valEntier2;
                    result.setText(String.valueOf(value));
                } else
                    result.setText(" Erreur");
            }
        });

        button_additioner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!Objects.equals(entier_1.getText().toString(), "") && !Objects.equals(entier_2.getText().toString(), "")) {
                    int valEntier1 = Integer.parseInt(entier_1.getText().toString());
                    int valEntier2 = Integer.parseInt(entier_2.getText().toString());
                    int value = valEntier1 + valEntier2;
                    result.setText(String.valueOf(value));
                } else
                    result.setText(" Erreur");
            }
        });

        button_effacer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entier_1.setText("");
                entier_2.setText("");
            }
        });

        button_newactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                String int1 = entier_1.getText().toString();
                String int2 = entier_2.getText().toString();

                if(!Objects.equals(int1, "") && !Objects.equals(int2, "")){
                    intent.putExtra("entier_1",  Integer.parseInt(int1));
                    intent.putExtra("entier_2",  Integer.parseInt(int2));
                    startActivity(intent);
                }
            }
        });
    }
}
