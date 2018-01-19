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
    private TextView txtV,abra;
    String name;



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        configureNextButton();


    } //Oncreate


    private static final String EXTRA_STRING = "import static com.example.mariu.rps.MainActivity";

    public static Intent newIntent(Context packageContext, String extraString) {
        Intent i = new Intent(packageContext, MainActivity.class);
        i.putExtra(EXTRA_STRING, extraString);
        return i;
    }







    private void configureNextButton(){
        Button nextButton = findViewById(R.id.nameBtn);
        nextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//                editTxt = (EditText) findViewById(R.id.TheeditText);
//                txtV = (TextView) findViewById(R.id.theUserName);
//                abra = findViewById(R.id.abra);
//                name = editTxt.getText().toString();
//                abra.setText(name);
//                txtV.setText(name);
//                Intent i = MainActivity.class(FirstScreen.this, name);
//                startActivity(i);
            startActivity(new Intent(FirstScreen.this, MainActivity.class));

             }
        });
    }



} //SECONDACTIVITY
