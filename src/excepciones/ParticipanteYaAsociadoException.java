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
public class ParticipanteYaAsociadoException extends Exception {
    public ParticipanteYaAsociadoException() {
        super("El usuario ya es un participante de la encuesta");
    }
}
