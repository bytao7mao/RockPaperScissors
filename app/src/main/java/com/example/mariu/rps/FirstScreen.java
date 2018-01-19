package com.example.mariu.rps;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;


import org.w3c.dom.Text;



/**
 * Created by Mariu on 1/18/2018.
 */

public class FirstScreen extends Activity {
    private EditText editTxt;
    private TextView txtV;
    String name;
    Button nextButton;
    private static final String NAME = "name";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        editTxt = findViewById(R.id.TheeditText);
        txtV = findViewById(R.id.theUserName);
        nextButton = findViewById(R.id.nameBtn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configureNextButton();
            } //Oncreate

            private void configureNextButton() {
                name = editTxt.getText().toString();
                Intent i = new Intent(FirstScreen.this, MainActivity.class);
                i.putExtra(NAME, name);
                startActivity(i);
            }
        });
    }
} //SECONDACTIVITY
