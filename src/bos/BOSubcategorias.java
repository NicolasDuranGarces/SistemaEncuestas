/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import definiciones.IDAOSubcategoria;
import excepciones.ConexionException;
import excepciones.YaExistenteException;
import fabrica.FabricaDAO;
import java.util.ArrayList;
import modelo.Subcategoria;

/**
 *
 * @author jose
 */
public class BOSubcategorias {
    private IDAOSubcategoria dAOSubcategoria;

    public BOSubcategorias() {
        dAOSubcategoria = FabricaDAO.getFabrica().crearDAOSubcategoria();
    }  
    
    public boolean crearCategoria(Subcategoria subcategoria) throws ConexionException, YaExistenteException{
        if (dAOSubcategoria.buscar(subcategoria.getId()) == null) {
            dAOSubcategoria.agregar(subcategoria);
            return true;
        } else {
            throw new YaExistenteException("La categoria");
        }
    }
    
    public ArrayList<Subcategoria> cargarSubcategorias(int idCategoria) throws ConexionException{
        ArrayList<Subcategoria> lista = dAOSubcategoria.cargarPorCategoria(idCategoria);
        return lista;
    }
}
