/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liebreytortuga;

import static java.lang.Thread.sleep;

/**
 *
 * @author Usuario DAM
 */
public class Tortuga extends Thread{
    private Carrera carrera;
    private int distancia;
    
    public Tortuga(Carrera c){
        carrera = c;
        distancia = 1;
    }
    
    @Override
    public void run(){
        do{
            int aleatorio = (int) (Math.random() * 10);
            if(aleatorio < 5)
                distancia = carrera.TortugaMueve(3);
            else if(aleatorio < 7)
                distancia = carrera.TortugaMueve(-6);
            else
                distancia = carrera.TortugaMueve(1);
        }while(distancia<70);
    }
}
