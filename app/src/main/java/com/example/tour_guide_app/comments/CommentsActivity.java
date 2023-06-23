package com.example.tour_guide_app.comments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.tour_guide_app.R;

public class CommentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        String nombre = getIntent().getStringExtra("nombre");


        TextView textView = findViewById(R.id.texto_lugarmostrar);
        textView.setText(nombre);

    }
}