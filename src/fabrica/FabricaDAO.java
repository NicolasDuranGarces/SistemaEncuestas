/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabrica;

import daos.FabricaDAOJDBC;
import definiciones.IFabricaDAO;

/**
 *
 * @author brian
 */
public class FabricaDAO {

    public static IFabricaDAO getFabrica() {
        return new FabricaDAOJDBC();
    }

}
