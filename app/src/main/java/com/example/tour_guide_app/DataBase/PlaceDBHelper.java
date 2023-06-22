package com.example.tour_guide_app.DataBase;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class PlaceDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "lugares.db";
    private static final int DATABASE_VERSION = 1;

    public PlaceDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Crea la tabla de lugares
        String createTableQuery = "CREATE TABLE lugares (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "ubicacion TEXT, " +
                "categoria TEXT, " +
                "descripcion TEXT, " +
                "precios TEXT, " +
                "horarios TEXT, " +
                "imagen TEXT)";
        db.execSQL(createTableQuery);

        ContentValues values1 = new ContentValues();
        values1.put("nombre", "Malecon 2000");
        values1.put("ubicacion", "Guayaquil");
        values1.put("categoria", "Parque");
        values1.put("descripcion", "Parque urbano le devuelve a la ciudad su relación perdida con el Río Guayas");
        values1.put("precios", "Gratis");
        values1.put("horarios", "Lunes a Domingo: 7:00 - 00:00");
        long newRowId1 = db.insert("lugares", null, values1);

        ContentValues values2 = new ContentValues();
        values2.put("nombre", "Guayarte");
        values2.put("ubicacion", "Guayaquil");
        values2.put("categoria", "Plaza");
        values2.put("descripcion", "Es una plaza de Guayaquil de contenido artístico y gastronómico");
        values2.put("precios", "Gratis");
        values2.put("horarios", "Lunes a Viernes: 12:00 - 22:00");
        long newRowId2 = db.insert("lugares", null, values2);

        ContentValues values3 = new ContentValues();
        values3.put("nombre", "Parque Samanes");
        values3.put("ubicacion", "Guayaquil");
        values3.put("categoria", "Parque");
        values3.put("descripcion", "Conocido como Parque Ecológico Samanes");
        values3.put("precios", "Gratis");
        values3.put("horarios", "Lunes a Domingo: 6:00 - 23:00");
        long newRowId3 = db.insert("lugares", null, values3);

        ContentValues values4 = new ContentValues();
        values4.put("nombre", "Cerro Santa Ana");
        values4.put("ubicacion", "Guayaquil");
        values4.put("categoria", "Monumento");
        values4.put("descripcion", "Es un sitio de interés turístico. A 310 metros se encuentran restaurantes, cafés, galerías de arte, cibercafés" );
        values4.put("precios", "Gratis");
        values4.put("horarios", "Es recomendable visitarlo de dia.");
        long newRowId4 = db.insert("lugares", null, values4);

        ContentValues values5 = new ContentValues();
        values5.put("nombre", "Parque Historico");
        values5.put("ubicacion", "Samborondón");
        values5.put("categoria", "Parque");
        values5.put("descripcion", "Parque recreativo con un espacio de vida silvestre y cultural que exhibe especies de flora y fauna de Guayaquil" );
        values5.put("precios", "Gratis");
        values5.put("horarios", "Miercoles a Domingo: 09:00 - 17:00");
        long newRowId5 = db.insert("lugares", null, values5);

        ContentValues values6 = new ContentValues();
        values6.put("nombre", "Parque Seminario");
        values6.put("ubicacion", "Guayaquil");
        values6.put("categoria", "Parque");
        values6.put("descripcion", "Parque de las Iguanas es un pequeño y tradicional parque urbano público ubicado en el sector Rocafuerte en el centro de la ciudad de Guayaquil." );
        values6.put("precios", "Gratis");
        values6.put("horarios", "Lunes a Domingo: 09:00 - 19:10");
        long newRowId6 = db.insert("lugares", null, values6);

        ContentValues values7 = new ContentValues();
        values7.put("nombre", "El Patio");
        values7.put("ubicacion", "Guayaquil");
        values7.put("categoria", "Restaurante");
        values7.put("descripcion", "Restaurante con un buen servicio." );
        values7.put("precios", "Depende del platillo.");
        values7.put("horarios", "Lunes a Domingo: 09:00 - 21:00");
        long newRowId7 = db.insert("lugares", null, values7);

        ContentValues values8 = new ContentValues();
        values8.put("nombre", "Casa Julián");
        values8.put("ubicacion", "Parque Historico de Guayaquil");
        values8.put("categoria", "Restaurante");
        values8.put("descripcion", "Encontrarás los mejores sabores del Ecuador incorporados a una Cocina de Autor Única. " );
        values8.put("precios", "20 US$ - 50 US$");
        values8.put("horarios", "Lunes a Sábado: 13:00 a 23:00");
        long newRowId8 = db.insert("lugares", null, values8);

        ContentValues values9 = new ContentValues();
        values9.put("nombre", "Noe Sushi Bar");
        values9.put("ubicacion", "Guayaquil");
        values9.put("categoria", "Restaurante");
        values9.put("descripcion", "Lo mejor de la gastronomía fusión japonesa-ecuatoriana a través de una combinación con los sabores nacionales." );
        values9.put("precios", "20 US$ - 80 US$");
        values9.put("horarios", "Lunes a Sábado: 12:00 a 22:00");
        long newRowId9 = db.insert("lugares", null, values9);

        ContentValues values10 = new ContentValues();
        values10.put("nombre", "Catedral Católica Metropolitana de Guayaquil");
        values10.put("ubicacion", "Guayaquil");
        values10.put("categoria", "Monumento");
        values10.put("descripcion", "Es una catedral ecuatoriana que se encuentra en pleno centro de Guayaquil, en el Parque Seminario" );
        values10.put("precios", "Gratis");
        values10.put("horarios", "Lunes a Domingo: 12:00 a 22:00");
        long newRowId10 = db.insert("lugares", null, values10);

        // Verifica si la inserción fue exitosa
        if (newRowId1 != -1 && newRowId2 != -1 && newRowId3 != -1 && newRowId4 != -1 && newRowId5 !=-1 && newRowId6 !=-1 && newRowId7 !=-1
                && newRowId8 !=-1 && newRowId9 !=-1 && newRowId10 !=-1) {
            // El nuevo registro se agregó correctamente
        } else {
            // Ocurrió un error al agregar el nuevo registro
        }

        // Cierra la conexión con la base de datos
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

