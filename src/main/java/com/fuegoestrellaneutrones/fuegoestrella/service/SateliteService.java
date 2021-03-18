package com.fuegoestrellaneutrones.fuegoestrella.service;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fuegoestrellaneutrones.fuegoestrella.dto.PosicionesDTO;
import com.fuegoestrellaneutrones.fuegoestrella.dto.RespuestaNavesDTO;
import com.fuegoestrellaneutrones.fuegoestrella.dto.SateliteEspecificoDTO;
import com.fuegoestrellaneutrones.fuegoestrella.model.Satelite;
import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;
import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


public class SateliteService {

    /**
     * Hallar y organizar el mensaje secreto de las 3 naves
     *
     * @author paula.galeano
     * @since 17/03/2021
     */
    public static String mensaje(List<Satelite> data) {
        ArrayList<String> mensajeSatelite = new ArrayList<>();
        StringBuilder cadenaTexto = new StringBuilder();
        Boolean mensajeFinal = true;
        for (int i = 0; i < data.size(); i++) {
            String[] mensajes = data.get(i).getMessage();
            //segundo for para validar cada satelite
            for (int h = 0; h < mensajes.length; h++) {
                if (mensajeSatelite.isEmpty() || h >= mensajeSatelite.size()) {
                    mensajeSatelite.add(mensajes[h]);
                } else if (mensajeSatelite.get(h) == "") {
                    mensajeSatelite.set(h, mensajes[h]);
                }
            }

        }
        for (int j = 0; j < mensajeSatelite.size(); j++) {
            if (mensajeSatelite.get(j) == "") {
                mensajeFinal = false;
            } else {
                cadenaTexto.append(mensajeSatelite.get(j) + " ");
            }
        }
        if (mensajeFinal == false) {
            String error = "Error";
            return error;
        } else {
            cadenaTexto.setLength(cadenaTexto.length() - 1);
            return cadenaTexto.toString();
        }

    }

    /**
     * Hallar la posición de la nave dependiendo de las posiciones de las otras 3
     *
     * @author paula.galeano
     * @since 17/03/2021
     */
    public double[] obtenerPosiciones(List<Satelite> data) {
        double[][] positions = new double[][]{{-500.00, -200.00}, {100.00, -100.00}, {500.00, 200.00}};
        double[] distances = new double[3];
        for (Satelite sa : data) {
            switch (sa.getName()) {
                case "kenobi":
                    distances[0] = sa.getDistance();
                    break;
                case "skywalker":
                    distances[1] = sa.getDistance();
                    break;
                case "solo":
                    distances[2] = sa.getDistance();
                    break;

            }
        }

        NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(new TrilaterationFunction(positions, distances), new LevenbergMarquardtOptimizer());
        LeastSquaresOptimizer.Optimum optimum = solver.solve();

        // the answer
        double[] centroid = optimum.getPoint().toArray();
        return centroid;

    }

    /**
     * Guardar el json de las naves
     *
     * @author paula.galeano
     * @since 17/03/2021
     */
    ArrayList<Satelite> sateliteEspecifico = new ArrayList<>();

    public ArrayList<Satelite> getSateliteEspecifico() {
        return sateliteEspecifico;
    }

    public void guardarDatos (SateliteEspecificoDTO data, String nombre) {
        try {
            Satelite satelite = new Satelite();
            boolean existe = true;
            for (int i = 0; i < sateliteEspecifico.size(); i++) {
                if(sateliteEspecifico.get(i).getName().equals(nombre)){
                    existe = false;
                }
            }
            if(existe){
                System.out.println("Crear uno nuevo");
                satelite.setDistance(data.getDistance());
                satelite.setMessage(data.getMessage());
                satelite.setName(nombre);
                sateliteEspecifico.add(satelite);
            }else{
                System.out.println("Ya existe");
            }

        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Error", e);
        }
    }
}
