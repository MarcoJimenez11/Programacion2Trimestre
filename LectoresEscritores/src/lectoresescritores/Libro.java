/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectoresescritores;

import static java.lang.Thread.sleep;

/**
 *
 * @author Usuario DAM
 */
public class Libro {
    private String texto;
    private final int tamanio;
    private boolean puedeEscribir;
    private int escritoresLeyendo;
    
    //el constructor cuyo parámetro es el tamaño del texto que contiene el libro
    public Libro(int tamanio){
        texto = "";
        this.tamanio = tamanio;
        puedeEscribir = true;
        escritoresLeyendo = 0;
    }
    
    //Para la última lectura de los lectores
    public String getTexto(){
        return texto;
    }
    
    //método leer al que acceden a la vez todos los lectores
    public void leer(int numero){
        //comprueba que puede leer y se bloquea la hebra en caso de que no pueda
        puedeLeer(numero);
        
        //bloque que simula la lectura del libro
        escritoresLeyendo++;
        System.out.println("---------------------------------- Lector " + numero + " está leyendo " + texto);
        try{
                sleep((long) (Math.random()*5000)+1000);
        }catch(InterruptedException e){}
        escritoresLeyendo--;
        
        //si hay otras hebras lectoras leyendo se espera avisando que quedan lectores activos
        while(escritoresLeyendo > 0){
            System.out.println("*********** Todavía hay " + escritoresLeyendo + " lectores leyendo");
            try{
                sleep(1000);
            }catch(InterruptedException e){}
        }
        
        //avisa de que ya se puede escribir
        puedeEscribir();
    }
    
    public synchronized void puedeLeer(int numero){
        while(puedeEscribir && estaIncompleto()){
            try{
                System.out.println("Lector " + numero + " espera para leer");
                wait();
            }catch(InterruptedException e){}
        }
    }
    
    public synchronized void puedeEscribir(){
        puedeEscribir = true;
        notify();
    }
    
    public synchronized void escribir(char c, int numero){
        while(!puedeEscribir && estaIncompleto()){
            try{
                System.out.println("Escritor " + numero + " espera para escribir");
                wait();
            }catch(InterruptedException e){}
        }
        
        //Bloque que simula la escritura en el libro
        texto += c + " ";
        System.out.println("--------------------------------- Escritor " + numero + " escribe: " + c);
        try{
                sleep((long) (Math.random()*5000)+1000);
        }catch(InterruptedException e){}
        
        puedeEscribir = false;
        
        notifyAll();
    }
    
    public boolean estaIncompleto(){
        boolean incompleto = true;
        if(texto.length() >= tamanio)
            incompleto = false;
        return incompleto;
    }
}
