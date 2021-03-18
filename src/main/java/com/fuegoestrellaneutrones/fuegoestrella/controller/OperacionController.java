package com.fuegoestrellaneutrones.fuegoestrella.controller;

import com.fuegoestrellaneutrones.fuegoestrella.dto.*;
import com.fuegoestrellaneutrones.fuegoestrella.model.Satelite;
import com.fuegoestrellaneutrones.fuegoestrella.service.SateliteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class OperacionController {
    private List<Satelite> satelite = new ArrayList<>();

    /**
     * Hallar la posición de las naves por post
     * @author paula.galeano
     * @since 17/03/2021
     */
    SateliteService service = new SateliteService();
    @PostMapping(path = "/topsecret")
    public RespuestaNavesDTO topsecret (@RequestBody Map<String, List<Satelite>> data){
        try {
            String mensajes = service.mensaje(data.get("satellites"));
            double[] posiciones = service.obtenerPosiciones(data.get("satellites"));
            PosicionesDTO posicionesDTO = new PosicionesDTO();
            RespuestaNavesDTO respuesta = new RespuestaNavesDTO();
            if(!mensajes.equals("Error")){
                posicionesDTO.setPosx(posiciones[0]);
                posicionesDTO.setPosy(posiciones[1]);
                respuesta.setMensaje(mensajes);
                respuesta.setPosiciones(posicionesDTO);
            }else{
                throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Error", new Exception());
            }
            return respuesta;

        }catch(Exception e){
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Error", e);
        }
    }

    /**
     * Hallar la posición de una nave en especifico por metodo post
     * @author paula.galeano
     * @since 17/03/2021
     */
    @PostMapping(path = "/topsecret_split/{satelite_name}")
    public void topsecret_split (@RequestBody SateliteEspecificoDTO data, @PathVariable(value = "satelite_name") String nombre){
        try {
            service.guardarDatos(data,nombre);

        }catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error", e);
        }
    }

    /**
     * Hallar la posición de una nave en especifico por metodo post
     * @author paula.galeano
     * @since 17/03/2021
     */
    @GetMapping(path = "/topsecret_split")
    public RespuestaNavesDTO topsecret_split (){
        try {
            List<Satelite> satelitesList = service.getSateliteEspecifico();
            String mensajes = service.mensaje(satelitesList);
            double[] posiciones = service.obtenerPosiciones(satelitesList);

            PosicionesDTO posicionesDTO = new PosicionesDTO();
            RespuestaNavesDTO respuestaNavesDTO = new RespuestaNavesDTO();
            posicionesDTO.setPosx(posiciones[0]);
            posicionesDTO.setPosy(posiciones[1]);

            if(posiciones.length < 2 || mensajes.equals("Error")){
                respuestaNavesDTO.setMensaje("No hay suficiente información");
            }else{
                respuestaNavesDTO.setMensaje(mensajes);
                respuestaNavesDTO.setPosiciones(posicionesDTO);
            }

            return respuestaNavesDTO;

        }catch(Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error", e);
        }
    }
}
