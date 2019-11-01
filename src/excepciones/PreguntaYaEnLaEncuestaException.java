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
public class PreguntaYaEnLaEncuestaException extends Exception{

    public PreguntaYaEnLaEncuestaException() {
        super("La pregunta ya se encuentra asociada a la encuesta");
    }
    
}
