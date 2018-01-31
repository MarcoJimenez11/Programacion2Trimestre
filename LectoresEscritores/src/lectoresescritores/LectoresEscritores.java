/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectoresescritores;

/**
 *
 * @author Usuario DAM
 */
public class LectoresEscritores {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Libro libro = new Libro(20);
        Lector[] lector = new Lector[20];
        Escritor[] escritor = new Escritor[10];
        
        for(int i = 0; i < 10; i++){
            escritor[i] = new Escritor(libro,i);
            escritor[i].start();
        }
        for(int i = 0; i < 20; i++){
            lector[i] = new Lector(libro,i);
            lector[i].start();
        }
        
        
    }
    
}
