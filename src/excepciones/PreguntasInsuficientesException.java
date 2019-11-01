/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author jose
 */
public class PreguntasInsuficientesException extends Exception{

    public PreguntasInsuficientesException(int solicitadas, int enBanco) {
        super("No hay suficientes preguntas para generar la encuesta, hay "+enBanco+", se piden "+solicitadas);
    }
    
}
