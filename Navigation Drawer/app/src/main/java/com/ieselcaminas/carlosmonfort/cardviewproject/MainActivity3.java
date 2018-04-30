package com.ieselcaminas.carlosmonfort.cardviewproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by alu53789415m on 31/01/17.
 */

public class MainActivity3 extends AppCompatActivity{

    TextView textView;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1_secundary_layout);

        textView = (TextView)findViewById(R.id.textView2);
        imageView = (ImageView)findViewById(R.id.imageView2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


    }
}
