package com.example.tour_guide_app.information;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tour_guide_app.MainActivity;
import com.example.tour_guide_app.R;
import com.example.tour_guide_app.comments.CommentsActivity;

public class DescripcionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        // Obtener los extras del Intent
        String nombre = getIntent().getStringExtra("nombre");
        int imagenResId = getIntent().getIntExtra("imagenResId", 0);
        String ubicacion = getIntent().getStringExtra("ubicacion");
        String categoria = getIntent().getStringExtra("categoria");
        String descripcion = getIntent().getStringExtra("descripcion");
        String precios = getIntent().getStringExtra("precios");
        String horarios = getIntent().getStringExtra("horarios");

        // Mostrar el nombre y la imagen en la Activity
        TextView textView = findViewById(R.id.textViewNombreLugar);
        ImageView imageView = findViewById(R.id.imageViewLugar);
        TextView textViewubicacion = findViewById(R.id.textViewUbicacion);
        TextView textViewcategoria = findViewById(R.id.textViewCategoria);
        TextView textViewdescripcion = findViewById(R.id.textViewDescripcion);
        TextView textViewprecios = findViewById(R.id.textViewPrecios);
        TextView textViewhorarios = findViewById(R.id.textViewHorarios);

        textView.setText(nombre);
        imageView.setImageResource(imagenResId);
        textViewubicacion.setText(ubicacion);
        textViewcategoria.setText(categoria);
        textViewdescripcion.setText(descripcion);
        textViewprecios.setText(precios);
        textViewhorarios.setText(horarios);

        Button boton_comentarios = findViewById(R.id.btn_comentarios);

        boton_comentarios.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(DescripcionActivity.this, CommentsActivity.class);
                intent.putExtra("nombre", nombre);
                startActivity(intent);
            }
        });

    }
}
