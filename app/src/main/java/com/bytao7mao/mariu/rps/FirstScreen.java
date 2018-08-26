package com.bytao7mao.mariu.rps;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;


/**
 * Created by Marius on 1/18/2018.
 */

public class FirstScreen extends Activity {
    private EditText editTxt;
    String name;
    Button nextButton;
    private static final String NAME = "name";
    MediaPlayer bgMusic = new MediaPlayer();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

        bgMusic = MediaPlayer.create(this,R.raw.asian);

       ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);
       toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    bgMusic.start();
                } else {
                    // The toggle is disabled
                    bgMusic.pause();
                }
            }
        });


        editTxt = findViewById(R.id.TheeditText);
        nextButton = findViewById(R.id.nameBtn);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                configureNextButton();
            } //Oncreate
            private void configureNextButton() {
                name = editTxt.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    editTxt.setError("Please input a name");
                    return;
                }
                Intent i = new Intent(FirstScreen.this, MainActivity.class);
                i.putExtra(NAME, name);
                bgMusic.pause();
                startActivity(i);
            }
        });
    }
} //SECONDACTIVITY
