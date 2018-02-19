package com.example.asuri.tp2;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    int Position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton rb1 = findViewById(R.id.radioButton1);
        final RadioButton rb2 = findViewById(R.id.radioButton2);
        final RadioButton rb3 = findViewById(R.id.radioButton3);
        final RadioButton rb4 = findViewById(R.id.radioButton4);
        final RadioButton rb5 = findViewById(R.id.radioButton5);

        final ImageView imageView = findViewById(R.id.imageView);

        final Button b1 = findViewById(R.id.buttonLinearLayout);
        final Button b2 = findViewById(R.id.buttonTableLayout);

        final ListView listView = (ListView) findViewById(R.id.listView);
        registerForContextMenu(listView);
        String[] images = new String[] { "ucbn1","ucbn2","ucbn3","ucbn4","ucbn5"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                String itemValue = (String) listView.getItemAtPosition(position);
                Position = position;
                switch(position)
                {
                    case 0: {imageView.setImageResource(R.drawable.ucbn1); break;}
                    case 1: {imageView.setImageResource(R.drawable.ucbn2); break;}
                    case 2: {imageView.setImageResource(R.drawable.ucbn3); break;}
                    case 3: {imageView.setImageResource(R.drawable.ucbn4); break;}
                    case 4: {imageView.setImageResource(R.drawable.ucbn5); break;}
                }

                Toast.makeText(getApplicationContext(), "Image : "+itemValue, Toast.LENGTH_SHORT).show();
            }
        });

        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try{
                   imageView.setImageResource(R.drawable.ucbn1);
               }
               catch (Exception exc){
                   Toast.makeText(getApplicationContext(), "exc :"+exc.toString(), Toast.LENGTH_SHORT).show();
               }
            }
        });
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    imageView.setImageResource(R.drawable.ucbn2);
                }
                catch (Exception exc){
                    Toast.makeText(getApplicationContext(), "exc :"+exc.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    imageView.setImageResource(R.drawable.ucbn3);
                }
                catch (Exception exc){
                    Toast.makeText(getApplicationContext(), "exc :"+exc.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    imageView.setImageResource(R.drawable.ucbn4);
                }
                catch (Exception exc){
                    Toast.makeText(getApplicationContext(), "exc :"+exc.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        rb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    imageView.setImageResource(R.drawable.ucbn5);
                }
                catch (Exception exc){
                    Toast.makeText(getApplicationContext(), "exc :"+exc.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               setContentView(R.layout.linear_layout);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.table_layout);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo)
    {

        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("UCBM Images");
        menu.add(0, v.getId(), 0, "Envoyer Par Bluetooth");
        menu.add(0, v.getId(), 0, "Imprimer");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        if(item.getTitle()=="Envoyer Par Bluetooth"){
            Toast.makeText(getApplicationContext(), "Vous avez choisi Envoyer par bluetooth", Toast.LENGTH_LONG).show();

            // Make dialogue Builder
            LayoutInflater li = LayoutInflater.from(getApplicationContext());
            View dialogueView = li.inflate(R.layout.dialogue, null);

            final AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getApplicationContext());

            //Set Layout
            dialogBuilder.setView(dialogueView);
            dialogBuilder.setTitle("Par Bluetooth...");

            // Set the custom dialog components - text, image
            final TextView text = (TextView) dialogueView.findViewById(R.id.dialogueTitre);
            text.setText("Vous avez choisi Envoyer Par Bluetooth!");

            ImageView image = (ImageView) dialogueView.findViewById(R.id.dialogueImageView);
            switch(Position)
            {
                case 0: {image.setImageResource(R.drawable.ucbn1); break;}
                case 1: {image.setImageResource(R.drawable.ucbn2); break;}
                case 2: {image.setImageResource(R.drawable.ucbn3); break;}
                case 3: {image.setImageResource(R.drawable.ucbn4); break;}
                case 4: {image.setImageResource(R.drawable.ucbn5); break;}
            }

            dialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("Accepter",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(getApplicationContext(), "Vous avez choisi Acceoter", Toast.LENGTH_LONG).show();
                                    dialogInterface.cancel();
                                }
                            })
                    .setNegativeButton("Annuler",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel();
                                }
                            });

            AlertDialog alterDialog = dialogBuilder.create();
            alterDialog.show();

        } else if(item.getTitle()=="Imprimer"){
            Toast.makeText(getApplicationContext(), "Vous avez choisi Imprimer", Toast.LENGTH_LONG).show();
        } else {
            return false;
        }
        return true;
    }
}
