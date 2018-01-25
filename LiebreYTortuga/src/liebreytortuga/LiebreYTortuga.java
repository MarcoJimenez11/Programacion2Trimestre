/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebreytortuga;

/**
 *
 * @author Usuario DAM
 */
public class LiebreYTortuga {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Carrera c = new Carrera();
        Liebre l = new Liebre(c);
        Tortuga t = new Tortuga(c);
        
        l.start();
        t.start();
    }
}
