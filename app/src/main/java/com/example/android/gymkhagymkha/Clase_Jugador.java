package com.example.android.gymkhagymkha;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Victor on 14/10/2015.
 */
public class Clase_Jugador {
    private int idJugador;
    private String usuario;
    private String nombre;
    private String apellido;
    private String email;

    public Clase_Jugador(JSONObject objetoJSON) throws JSONException {
        idJugador = objetoJSON.getInt("idJugador");
        usuario = objetoJSON.getString("usuario");
        nombre = objetoJSON.getString("nombre");
        apellido = objetoJSON.getString("apellido");
        email = objetoJSON.getString("email");
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}