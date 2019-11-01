/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bos;

import definiciones.IDAOCategoria;
import excepciones.ConexionException;
import excepciones.YaExistenteException;
import fabrica.FabricaDAO;
import java.util.ArrayList;
import modelo.Categoria;

/**
 *
 * @author jose
 */
public class BOCategorias {
    private IDAOCategoria dAOCategoria;
    
    public BOCategorias(){
        dAOCategoria = FabricaDAO.getFabrica().crearDAOCategoria();
    }
    
    public boolean crearCategoria(Categoria categoria) throws ConexionException, YaExistenteException{
        if (dAOCategoria.buscar(categoria.getId()) == null) {
            dAOCategoria.agregar(categoria);
            return true;
        } else {
            throw new YaExistenteException("La categoria");
        }
    }
    public ArrayList<Categoria> cargarCategorias() throws ConexionException{
        return dAOCategoria.cargarCategorias();
    }
    
}
