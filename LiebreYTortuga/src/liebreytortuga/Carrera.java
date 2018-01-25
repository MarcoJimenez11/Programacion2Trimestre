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
public class Carrera {
    private int tortuga;
    private int liebre;
    private int turno;
    
    public Carrera(){
        tortuga = 1;
        liebre = 1;
        turno = 1;
    }
    
    public synchronized int LiebreMueve(int casillas){
        while(turno != 1){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        liebre = liebre + casillas;
        if(liebre < 1)
            liebre = 1;
        turno = 2;
        notify();       
        return liebre;
    }
    
    public synchronized int TortugaMueve(int casillas){
        while(turno != 2){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        tortuga = tortuga + casillas;
        if(tortuga < 1)
            tortuga = 1;
        turno = 1;        
        notify();
        this.MostrarCarrera();
        return tortuga;
    }
    
    public synchronized void MostrarCarrera(){
        for(int i = 1; i <= tortuga;i++){
            System.out.print(" ");
            if(tortuga == i)
                System.out.println("T");
        }
        
        for(int i = 1; i <= liebre;i++){
            System.out.print(" ");
            if(liebre == i)
                System.out.println("L");
        }
        System.out.println("_______________________________________________________________________");
        
        if(liebre >= 70 && tortuga >= 70)
            System.out.println("Empate");
        else if(liebre >= 70)
            System.out.println("Gana la liebre");
        else if(tortuga >= 70)
            System.out.println("Gana la tortuga");
    }
}
