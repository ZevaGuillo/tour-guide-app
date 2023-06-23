package com.example.tour_guide_app.DataBase;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
        String createTableLugaresQuery = "CREATE TABLE lugares (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "ubicacion TEXT, " +
                "categoria TEXT, " +
                "descripcion TEXT, " +
                "precios TEXT, " +
                "horarios TEXT, " +
                "longitud REAL, " +
                "latitud REAL)";
        db.execSQL(createTableLugaresQuery);

        // Crea la tabla de usuarios
        String createTableUsuariosQuery = "CREATE TABLE usuarios (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT)";
        db.execSQL(createTableUsuariosQuery);

        // Crea la tabla de valoraciones
        String createTableValoracionesQuery = "CREATE TABLE valoraciones (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "comentario TEXT, " +
                "puntuacion FLOAT, " +
                "usuario_id INTEGER, " +
                "lugar_id INTEGER, " +
                "FOREIGN KEY(usuario_id) REFERENCES usuarios(_id), " +
                "FOREIGN KEY(lugar_id) REFERENCES lugares(_id))";
        db.execSQL(createTableValoracionesQuery);


        ContentValues values1 = new ContentValues();
        values1.put("nombre", "Malecon 2000");
        values1.put("ubicacion", "Guayaquil");
        values1.put("categoria", "Parque");
        values1.put("descripcion", "Parque urbano le devuelve a la ciudad su relación perdida con el Río Guayas");
        values1.put("precios", "Gratis");
        values1.put("horarios", "Lunes a Domingo: 7:00 - 00:00");
        values1.put("longitud", "-79.889532");
        values1.put("latitud", "-2.189327");
        long newRowId1 = db.insert("lugares", null, values1);

        ContentValues values2 = new ContentValues();
        values2.put("nombre", "Guayarte");
        values2.put("ubicacion", "Guayaquil");
        values2.put("categoria", "Plaza");
        values2.put("descripcion", "Es una plaza de Guayaquil de contenido artístico y gastronómico");
        values2.put("precios", "Gratis");
        values2.put("horarios", "Lunes a Viernes: 12:00 - 22:00");
        values2.put("longitud", "-79.903465");
        values2.put("latitud", "-2.179908");
        long newRowId2 = db.insert("lugares", null, values2);

        ContentValues values3 = new ContentValues();
        values3.put("nombre", "Parque Samanes");
        values3.put("ubicacion", "Guayaquil");
        values3.put("categoria", "Parque");
        values3.put("descripcion", "Conocido como Parque Ecológico Samanes");
        values3.put("precios", "Gratis");
        values3.put("horarios", "Lunes a Domingo: 6:00 - 23:00");
        values3.put("longitud", "-79,8966");
        values3.put("latitud", "-2,1038");
        long newRowId3 = db.insert("lugares", null, values3);

        ContentValues values4 = new ContentValues();
        values4.put("nombre", "Cerro Santa Ana");
        values4.put("ubicacion", "Guayaquil");
        values4.put("categoria", "Monumento");
        values4.put("descripcion", "Es un sitio de interés turístico. A 310 metros se encuentran restaurantes, cafés, galerías de arte, cibercafés" );
        values4.put("precios", "Gratis");
        values4.put("horarios", "Es recomendable visitarlo de dia.");
        values4.put("longitud", "-79.8832222516164");
        values4.put("latitud", "-2.18116925");
        long newRowId4 = db.insert("lugares", null, values4);

        ContentValues values5 = new ContentValues();
        values5.put("nombre", "Parque Historico");
        values5.put("ubicacion", "Samborondón");
        values5.put("categoria", "Parque");
        values5.put("descripcion", "Parque recreativo con un espacio de vida silvestre y cultural que exhibe especies de flora y fauna de Guayaquil" );
        values5.put("precios", "Gratis");
        values5.put("horarios", "Miercoles a Domingo: 09:00 - 17:00");
        values5.put("longitud", "-79.8696917");
        values5.put("latitud", "-2.1451587");
        long newRowId5 = db.insert("lugares", null, values5);

        ContentValues values6 = new ContentValues();
        values6.put("nombre", "Parque Seminario");
        values6.put("ubicacion", "Guayaquil");
        values6.put("categoria", "Parque");
        values6.put("descripcion", "Parque de las Iguanas es un pequeño y tradicional parque urbano público ubicado en el sector Rocafuerte en el centro de la ciudad de Guayaquil." );
        values6.put("precios", "Gratis");
        values6.put("horarios", "Lunes a Domingo: 09:00 - 19:10");
        values6.put("longitud", "-79.8831778299041");
        values6.put("latitud", "-2.19467435");
        long newRowId6 = db.insert("lugares", null, values6);

        ContentValues values7 = new ContentValues();
        values7.put("nombre", "El Patio");
        values7.put("ubicacion", "Oro Verde Guayaquil");
        values7.put("categoria", "Restaurante");
        values7.put("descripcion", "Restaurante con un buen servicio." );
        values7.put("precios", "Depende del platillo.");
        values7.put("horarios", "Lunes a Domingo: 09:00 - 21:00");
        values7.put("longitud", "-79.89119857724324");
        values7.put("latitud", "-2.188443761402277");
        long newRowId7 = db.insert("lugares", null, values7);

        ContentValues values8 = new ContentValues();
        values8.put("nombre", "Casa Julián");
        values8.put("ubicacion", "Samborondon");
        values8.put("categoria", "Restaurante");
        values8.put("descripcion", "Encontrarás los mejores sabores del Ecuador incorporados a una Cocina de Autor Única. " );
        values8.put("precios", "20 US$ - 50 US$");
        values8.put("horarios", "Lunes a Sábado: 13:00 - 23:00");
        values8.put("longitud", "-79.87066182245269");
        values8.put("latitud", "-2.144638571424993");
        long newRowId8 = db.insert("lugares", null, values8);

        ContentValues values9 = new ContentValues();
        values9.put("nombre", "Noe Sushi Bar");
        values9.put("ubicacion", "Guayaquil");
        values9.put("categoria", "Restaurante");
        values9.put("descripcion", "Lo mejor de la gastronomía fusión japonesa-ecuatoriana a través de una combinación con los sabores nacionales." );
        values9.put("precios", "20 US$ - 80 US$");
        values9.put("horarios", "Lunes a Sábado: 12:00 - 22:00");
        values9.put("longitud", "-79.8982182052549");
        values9.put("latitud", "-2.1692339748671845");
        long newRowId9 = db.insert("lugares", null, values9);

        ContentValues values10 = new ContentValues();
        values10.put("nombre", "Catedral Católica Metropolitana de Guayaquil");
        values10.put("ubicacion", "Guayaquil");
        values10.put("categoria", "Monumento");
        values10.put("descripcion", "Es una catedral ecuatoriana que se encuentra en pleno centro de Guayaquil, en el Parque Seminario" );
        values10.put("precios", "Gratis");
        values10.put("horarios", "Lunes a Domingo: 12:00 - 22:00");
        values10.put("longitud", "-79.88390114758238");
        values10.put("latitud", "-2.1944487461685567");
        long newRowId10 = db.insert("lugares", null, values10);

        ContentValues values11 = new ContentValues();
        values11.put("nombre", "Monumento al Sagrado Corazón");
        values11.put("ubicacion", "Cerro del Carmen");
        values11.put("categoria", "Monumento");
        values11.put("descripcion", "Es una escultura en honor a Jesús de Nazaret. Se encuentra ubicada en un mirador en el Cerro del Carmen, con vista al centro y sur de la ciudad." );
        values11.put("precios", "Gratis");
        values11.put("horarios", "Es recomendable visitarlo de dia.");
        values11.put("longitud", "-79.8914774890875");
        values11.put("latitud", "-2.087151537697263");
        long newRowId11 = db.insert("lugares", null, values11);

        ContentValues values12 = new ContentValues();
        values12.put("nombre", "Zoo el Pantanal");
        values12.put("ubicacion", "Km. 23 Vía a Daule");
        values12.put("categoria", "Zoológico");
        values12.put("descripcion", "Zoológico que fue un centro de rescate de vida silvestre y ahora tiene diversos mamíferos, aves y reptiles." );
        values12.put("precios", "Adultos: $10\n" + "Estudiantes, Tercera Edad y Niños: $5");
        values12.put("horarios", "Lunes a Domigos: 10:00 - 16:00.");
        values12.put("longitud", "-79.96490794943692");
        values12.put("latitud", "-2.0034471301532917");
        long newRowId12 = db.insert("lugares", null, values12);

        ContentValues values13 = new ContentValues();
        values13.put("nombre", "Plaza Lagos");
        values13.put("ubicacion", "Samborondón");
        values13.put("categoria", "Plaza");
        values13.put("descripcion", "Recinto elegante de uso mixto con tiendas, cafeterías, restaurantes y oficinas alrededor de patios arbolados." );
        values13.put("precios", "Gratis");
        values13.put("horarios", "Lunes a Sabado: 08:00 - 0:00 ");
        values13.put("longitud", "-79.87449157641927");
        values13.put("latitud", "-2.0976487783792557");
        long newRowId13 = db.insert("lugares", null, values13);

        ContentValues values14 = new ContentValues();
        values14.put("nombre", "Menestras del Negro");
        values14.put("ubicacion", "Guayaquil");
        values14.put("categoria", "Restaurante");
        values14.put("descripcion", "Deliciosa comida como en casa, acompañados de arroz y menestra como el churrasco montado, megas apanadas, combos de carne y pollo" );
        values14.put("precios", "Depende del Platillo.");
        values14.put("horarios", "Lunes a Domingo: 10:00 - 22:00 ");
        values14.put("longitud", " -79.9016351850178");
        values14.put("latitud", "-2.1355029926424725");
        long newRowId14 = db.insert("lugares", null, values14);

        ContentValues values15 = new ContentValues();
        values15.put("nombre", "Malecón del Salado");
        values15.put("ubicacion", "Guayaquil");
        values15.put("categoria", "Parque");
        values15.put("descripcion", "Llamado así por estar a orillas del estero del mismo nombre, con una extensión de 400 metros, fue construido en 2009, como parte del proceso de regeneración urbana de la ciudad de Guayaquil." );
        values15.put("precios", "Gratis");
        values15.put("horarios", "Lunes a Viernes: 06:00 - 21:00 ");
        values15.put("longitud", "-79.89799221689326");
        values15.put("latitud", "-2.187196571666217");
        long newRowId15 = db.insert("lugares", null, values15);

        ContentValues values16 = new ContentValues();
        values16.put("nombre", "Museo Municipal de Guayaquil");
        values16.put("ubicacion", "Guayaquil");
        values16.put("categoria", "Museo");
        values16.put("descripcion", "Es un museo de Ecuador consagrado a las piezas arqueológicas, objetos y artículos históricos relacionados con la historia guayaquileña. Es considerado como el más importante de la ciudad y uno de los mejores del país." );
        values16.put("precios", "Gratis");
        values16.put("horarios", "Martes a Sábado: 10:00 - 17:30");
        values16.put("longitud", "-79.88257818991013");
        values16.put("latitud", "-2.1957104205310944");
        long newRowId16 = db.insert("lugares", null, values16);
        // Verifica si la inserción fue exitosa
        if (newRowId1 != -1 && newRowId2 != -1 && newRowId3 != -1 && newRowId4 != -1 && newRowId5 !=-1 && newRowId6 !=-1 && newRowId7 !=-1
                && newRowId8 !=-1 && newRowId9 !=-1 && newRowId10 !=-1 && newRowId11 !=-1 && newRowId12 !=-1 && newRowId13 !=1 && newRowId14 !=1
                && newRowId15 !=1 && newRowId16 !=-1) {
            // El nuevo registro se agregó correctamente
        } else {
            // Ocurrió un error al agregar el nuevo registro
        }


        ContentValues values18 = new ContentValues();
        values18.put("nombre", "Ricardo Solorzano");
        long newRowId18 = db.insert("usuarios", null, values18);
        if (newRowId18 != -1) {
            // El nuevo registro se agregó correctamente
        } else {
            // Ocurrió un error al agregar el nuevo registro
        }

        ContentValues values19 = new ContentValues();
        values19.put("comentario", "Excelente Lugar");
        values19.put("puntuacion",5);
        values19.put("usuario_id", 1);
        values19.put("lugar_id", 1);
        long newRowId19 = db.insert("valoraciones", null, values19);
        if (newRowId19 != -1) {
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

