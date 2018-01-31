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
public class Lector extends Thread{
    private Libro libro;
    private int numero;
    
    public Lector(Libro l, int numero){
        libro = l;
        this.numero = numero;
    }
    
    @Override
    public void run(){
        String texto = "";
        do{
            try{
                sleep((long) (Math.random()*2000)+1000);
            }catch(InterruptedException e){}
            libro.leer(numero);
        }while(libro.estaIncompleto());
        //Una última lectura para asegurar que los lectores leen el libro acabado
        System.out.println("---------------------------------- Lector " + numero + " está leyendo " + libro.getTexto());
    }
}
