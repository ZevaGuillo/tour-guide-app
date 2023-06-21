package com.example.information;
public class MyData {
    private int id;
    private String nombre;
    private String ubicacion;
    private String categoria;
    private String descripcion;
    private String precios;
    private String horarios;
    private int imageRes;

    public MyData(String nombre, String ubicacion, String categoria, String descripcion, String precios, String horarios) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precios = precios;
        this.horarios = horarios;
    }
    public String getnombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getPrecios() {
        return precios;
    }

    public String getHorarios() {
        return horarios;
    }

}

