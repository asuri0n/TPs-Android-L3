package fr.nathanchevalier.l3_tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent intent = getIntent();

        int entier_1 = intent.getIntExtra("entier_1",0);
        int entier_2 = intent.getIntExtra("entier_2",0);

        final EditText new_entier_1 = findViewById(R.id.entier1);
        final EditText new_entier_2 = findViewById(R.id.entier2);

        new_entier_1.setText(Integer.toString(entier_1));
        new_entier_2.setText(Integer.toString(entier_2));
    }
}
