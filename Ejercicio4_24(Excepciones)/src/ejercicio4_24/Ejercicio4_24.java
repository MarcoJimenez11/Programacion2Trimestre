/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4_24;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Usuario DAM
 */
public class Ejercicio4_24 {
    
    public static void mostrarNota(double nota){
        if(nota >= 0){
            if(nota < 3)
                System.out.println("Muy deficiente");
            else if(nota < 5)
                System.out.println("Insuficiente");
            else if(nota < 6)
                System.out.println("Suficiente");
            else if(nota < 7)
                System.out.println("Bien");
            else if(nota < 9)
                System.out.println("Notable");
            else
                System.out.println("Sobresaliente");
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Declaración de variables
        double nota;
        boolean malNum = true;
        Scanner leer = new Scanner(System.in);
        
        //Lectura de la nota de un alumno
        System.out.print("Introduce la nota del alumno: ");
        
        while(malNum){
            try{
                nota = leer.nextDouble();
                if(nota < 0 || nota > 10) throw new NotaException("La nota no está entre 0 y 10");
                mostrarNota(nota);
                malNum = false;
            }
            catch(NotaException e){
                System.out.println("Introduzca una nota entre 0 y 10");
            }
            catch(InputMismatchException ex){
                System.out.println("Introduzca una nota NUMÉRICA entre 0 y 10");
                leer.next();
            }
        }
        
    }
    
}
