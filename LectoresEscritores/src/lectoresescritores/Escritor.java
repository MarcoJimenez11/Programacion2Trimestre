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
public class Escritor extends Thread{
    private Libro libro;
    private int numero;
    
    public Escritor(Libro l, int numero){
        libro = l;
        this.numero = numero;
    }
    
    @Override
    public void run(){
        char letra;
        do{
            try{
                sleep((long) (Math.random()*2000)+1000);
            }catch(InterruptedException e){}
            //Genera una letra al azar mediante la tabla ASCII
            letra = (char) (65 + (int) (Math.random()*25));
            libro.escribir(letra, numero);
        }while(libro.estaIncompleto());
    }
}
