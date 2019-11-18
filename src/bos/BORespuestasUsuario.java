/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import definiciones.IDAORespuestaUsuario;
import excepciones.ConexionException;
import fabrica.FabricaDAO;
import java.util.ArrayList;
import modelo.RespuestaUsuario;

/**
 *
 * @author jose
 */
public class BORespuestasUsuario {

    private IDAORespuestaUsuario daoRespuestaUsuario;

    public BORespuestasUsuario() {
        daoRespuestaUsuario = FabricaDAO.getFabrica().crearDAORespuestaUsuario();
    }

    public boolean agregarRespuestaUnica(RespuestaUsuario respuesta) throws ConexionException {
        if (daoRespuestaUsuario.buscar(respuesta) == null) {
            return daoRespuestaUsuario.agregar(respuesta);
        } else {
            return daoRespuestaUsuario.modificar(respuesta);
        }
    }

    public boolean agregarRespuestaMultiple(ArrayList<RespuestaUsuario> listaRespuestas) throws ConexionException {
        if (daoRespuestaUsuario.buscar(listaRespuestas.get(0)) == null) {
            for (int i = 0; i < listaRespuestas.size(); i++) {
                daoRespuestaUsuario.agregar(listaRespuestas.get(i));
            }
        } else {
            daoRespuestaUsuario.eliminar(listaRespuestas.get(0).getIdEncuesta(),
                    listaRespuestas.get(0).getNumeroPregunta(), listaRespuestas.get(0).getDni());
            for (int i = 0; i < listaRespuestas.size(); i++) {
                daoRespuestaUsuario.agregar(listaRespuestas.get(i));
            }
            
        }
        return true;
    }
    
    public boolean verificarSiContestada(int idEncuesta, int numeroPregunta, long dni) throws ConexionException{
        return daoRespuestaUsuario.buscar(idEncuesta, numeroPregunta, dni);
    }
    
    
    public boolean buscar(int idEncuesta, long dni, long idPreguntaRequisito, int idOpcionRequisito) throws ConexionException{
        return daoRespuestaUsuario.buscar(idEncuesta, dni, idPreguntaRequisito, idOpcionRequisito);
    }
    
//    public ArrayList<RespuestaUsuario> traerMisRespuestas(){
//        
//    }
}
