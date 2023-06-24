package com.example.tour_guide_app.information;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tour_guide_app.DataBase.PlaceDBHelper;
import com.example.tour_guide_app.MainActivity;
import com.example.tour_guide_app.R;
import com.example.tour_guide_app.comments.CommentsActivity;
import com.example.tour_guide_app.maps.MapsActivity;

import java.util.ArrayList;

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
        Button boton_ubicacion = findViewById(R.id.btn_ubicacion);

        boton_comentarios.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String ultimoNombre = obtenerUltimoNombre();
                Intent intent = new Intent(DescripcionActivity.this, CommentsActivity.class);
                intent.putExtra("nombreu", ultimoNombre);
                intent.putExtra("nombre", nombre);
                startActivity(intent);
            }
        });
        boton_ubicacion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ArrayList<Double> ubicacion = obtenerLongyLat();
                Intent intent = new Intent(DescripcionActivity.this, MapsActivity.class);
                intent.putExtra("longitud", ubicacion.get(0));
                intent.putExtra("latitud", ubicacion.get(1));
                intent.putExtra("nombre", nombre);
                startActivity(intent);
            }
        });
    }
    PlaceDBHelper dbHelper = new PlaceDBHelper(this);
    private String obtenerUltimoNombre() {
        String ultimoNombre = "";

        // Obtener una instancia de la base de datos
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Definir la consulta para obtener el último nombre ingresado
        String query = "SELECT nombre FROM usuarios ORDER BY ROWID DESC LIMIT 1";

        // Ejecutar la consulta y obtener el resultado
        Cursor cursor = db.rawQuery(query, null);

        // Verificar si se encontraron registros
        if (cursor != null && cursor.moveToFirst()) {
            // Obtener el valor del nombre en la primera columna
            ultimoNombre = cursor.getString(0);
            cursor.close();
        }

        // Cerrar la conexión a la base de datos
        db.close();

        return ultimoNombre;
    }

    private ArrayList<Double> obtenerLongyLat(){
        ArrayList<Double> ubicacion = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // Definir la consulta para obtener el último nombre ingresado
        String query = "SELECT longitud, latitud FROM lugares ORDER BY ROWID DESC LIMIT 1";

        // Ejecutar la consulta y obtener el resultado
        Cursor cursor = db.rawQuery(query, null);

        // Verificar si se encontraron registros
        if (cursor != null && cursor.moveToFirst()) {
            // Obtener el valor del nombre en la primera columna
            ubicacion.add(Double.valueOf(cursor.getDouble(0)));
            ubicacion.add(Double.valueOf(cursor.getDouble(1)));
            cursor.close();
        }

        // Cerrar la conexión a la base de datos
        db.close();

        return ubicacion;
    }
}


