/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ordenardesdefichero;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;



/**
 *
 * @author Usuario DAM
 */
public class OrdenarDesdeFichero {

    
    //Método para ordenar palabras de un array
    public static String[] ordenarPalabras(String[] cadena){
        String[] palabrasOrdenadas = cadena;
        String aux;
        
        for(int i = 0; i < cadena.length; i++){
            for(int j = i; j < cadena.length; j++){
                if(palabrasOrdenadas[j].length() < palabrasOrdenadas[i].length()){
                    aux = palabrasOrdenadas[j];
                    palabrasOrdenadas[j] = palabrasOrdenadas[i];
                    palabrasOrdenadas[i] = aux;
                }
                if(palabrasOrdenadas[j].length() == palabrasOrdenadas[i].length()){
                    String[] palabras = {palabrasOrdenadas[j],palabrasOrdenadas[i]};
                    Arrays.sort(palabras);
                    palabrasOrdenadas[i] = palabras[0];
                    palabrasOrdenadas[j] = palabras[1];
                }
            }
        }

        return palabrasOrdenadas;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String ciudades = "";
 
        try{
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File ("src/ficheros/ciudades.txt");
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            System.out.println("Ciudades leídas desde el fichero:\n");
            String linea;
            while((linea=br.readLine()) != null){
                System.out.println(linea);  
                ciudades += linea + " ";
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
           // En el finally cerramos el fichero, para asegurarnos
           // que se cierra tanto si todo va bien como si salta 
           // una excepcion.
            try{
                if(fr != null){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        
        //Creo un array con cada ciudad por separado
        String[] ciudadesSeparadas = ciudades.split(" ");
        
        //Creo un nuevo array resultado que contendrá las ciudades ordenadas
        String[] ciudadesOrdenadas = ordenarPalabras(ciudadesSeparadas);
        
        System.out.println("\nCiudades ordenadas por tamaño y orden alfabético: \n");
        for(int i = 0; i < ciudadesOrdenadas.length; i++){
            System.out.print(ciudadesOrdenadas[i] + " ");
            if(i % 8 == 7)
                System.out.print("\n");
        }           
    }
}
