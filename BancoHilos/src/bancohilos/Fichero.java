/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancohilos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario DAM
 */
public class Fichero {
    private FileWriter fichero;
    private PrintWriter writer;
    
    public Fichero(){
        try{
            fichero = new FileWriter("src/ficheros/registrosBanco.txt", true);
            writer = new PrintWriter(fichero);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public void escribe(String texto){
        writer.println(texto);
    }
    
    public void cerrarFichero(){
        try {
            writer.println("FIN DEL PROGRAMA");
            fichero.close();
        } catch (IOException ex) {
            Logger.getLogger(CuentaBancaria.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
