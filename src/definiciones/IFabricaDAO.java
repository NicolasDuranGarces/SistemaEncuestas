/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package definiciones;

/**
 *
 * @author jose
 */
public interface IFabricaDAO {
    
    public IDAOCategoria crearDAOCategoria();
    
    public IDAOCiudad crearDAOCiudad();
    
    public IDAODetalleTema crearDAODetalleTema();
    
    public IDAOEncuesta crearDAOEncuesta();
    
    public IDAOOpciones crearDAOOpciones();
    
    public IDAOParticipante crearDAOParticipante();
    
    public IDAOPregunta crearDAOPregunta();
    
    public IDAOPreguntaEncuesta crearDAOPreguntaEncuesta();
    
    public IDAORespuestaUsuario crearDAORespuestaUsuario();
    
    public IDAOSubcategoria crearDAOSubcategoria();
    
    public IDAOTemaInteres crearDAOTemaInteres();
    
    public IDAOUsuario crearDAOUsuario();
    
    public IDAOLogIn crearDAOLogIn();
}
