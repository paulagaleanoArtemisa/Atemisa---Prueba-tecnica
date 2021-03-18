package com.fuegoestrellaneutrones.fuegoestrella.dto;

public class RespuestaNavesDTO {

    private String mensaje;
    private PosicionesDTO posiciones;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public PosicionesDTO getPosiciones() {
        return posiciones;
    }

    public void setPosiciones(PosicionesDTO posiciones) {
        this.posiciones = posiciones;
    }
}
