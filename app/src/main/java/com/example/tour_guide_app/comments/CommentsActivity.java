package com.example.tour_guide_app.comments;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tour_guide_app.DataBase.PlaceDBHelper;
import com.example.tour_guide_app.R;
import com.example.tour_guide_app.information.DescripcionActivity;
import com.example.tour_guide_app.information.InformationActivity;
import com.example.tour_guide_app.maps.MapsActivity;

public class CommentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_comments);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        // Inflar el menú en el Toolbar
        getMenuInflater().inflate(R.menu.menu_bar, toolbar.getMenu());

        String nombre = getIntent().getStringExtra("nombre");
        TextView textView = findViewById(R.id.texto_lugarmostrar);
        textView.setText(nombre);

        String nombre1 = getIntent().getStringExtra("nombreu");
        TextView textViewnombre = findViewById(R.id.texto_usuariomostrar);
        textViewnombre.setText(nombre1);

        PlaceDBHelper dbHelper = new PlaceDBHelper(this);
        Button boton_enviar = findViewById(R.id.enviar_btn);
        EditText txt_comentario = findViewById(R.id.texto_comentario);
        RatingBar rtn_bar = findViewById(R.id.rating_valoraciones);
        TextView nombrelugar =findViewById(R.id.texto_lugarmostrar);
        TextView nombreusuario = findViewById(R.id.texto_usuariomostrar);
        boton_enviar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                float puntuacion = rtn_bar.getRating();
                if (puntuacion == 0) {
                    // El RatingBar no tiene un valor válido
                    Toast.makeText(view.getContext(), "Por favor, califique el lugar", Toast.LENGTH_SHORT).show();
                    return;
                }
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                ContentValues cv = new ContentValues();
                cv.put("usuario_nombre", nombreusuario.getText().toString());
                cv.put("lugar_nombre", nombrelugar.getText().toString());
                cv.put("comentario", txt_comentario.getText().toString());
                cv.put("puntuacion", rtn_bar.getRating());
                db.insert("valoraciones", null, cv);
                Toast.makeText(view.getContext(), "Valoracion enviada", Toast.LENGTH_SHORT).show();
                db.close();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}