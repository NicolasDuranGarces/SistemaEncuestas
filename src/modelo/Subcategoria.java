/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author jose
 */
public class Subcategoria extends Asset {

    private int idCategoria;

    public Subcategoria(int idSubcategoria, String nombre, int idCategoria) {
        super(idSubcategoria, nombre);
        this.idCategoria = idCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idSubcategoria) {
        this.idCategoria = idCategoria;
    }

}
