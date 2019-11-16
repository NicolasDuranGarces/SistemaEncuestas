/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

import excepciones.ConexionException;
import java.util.ArrayList;
import modelo.Participante;

/**
 *
 * @author jose
 */
public interface IDAOParticipante {
 
    
    public boolean agregar(Participante participante) throws ConexionException;
            
    public boolean eliminar(long dni, int idEncuesta) throws ConexionException;
    
    public ArrayList<Participante> listar(int idEncuesta) throws ConexionException;
}
