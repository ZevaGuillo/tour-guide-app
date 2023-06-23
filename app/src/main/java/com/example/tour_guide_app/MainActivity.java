package com.example.tour_guide_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tour_guide_app.DataBase.PlaceDBHelper;
import com.example.tour_guide_app.information.InformationActivity;


public class MainActivity extends AppCompatActivity {

    private EditText TextNombre;
    private Button btnAcceso;
    private SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button btn_acceder = findViewById(R.id.btn_acceder);
        /*btn_acceder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(intent);
            }
        });*/

            // Obtener referencias de los elementos del XML
            TextNombre = findViewById(R.id.inputName);
            btnAcceso = findViewById(R.id.btn_acceder);

            // Configurar evento de clic para el botón "Acceder"
            btnAcceso.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Obtener el nombre ingresado
                    String nombre = TextNombre.getText().toString().trim();

                    if (!nombre.isEmpty()) {
                        // Guardar el nombre en la tabla "usuarios"
                        guardarNombreEnTabla(nombre);
                    } else {
                        // Mostrar mensaje de error
                        Toast.makeText(getApplicationContext(), "Ingrese un nombre", Toast.LENGTH_SHORT).show();

                    }
                }
            });
            // Configurar tu SQLiteOpenHelper para obtener la instancia de la base de datos
            PlaceDBHelper dbHelper = new PlaceDBHelper(this);
            database = dbHelper.getWritableDatabase();
        }
        private void guardarNombreEnTabla(String nombre) {

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            long resultado = database.insert("usuarios", null, values);

            if (resultado != -1) {
                Toast.makeText(this, "Nombre guardado correctamente", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, InformationActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Error al guardar el nombre", Toast.LENGTH_SHORT).show();
            }
        }

}