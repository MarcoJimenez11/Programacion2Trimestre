/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancohilos;

/**
 *
 * @author Usuario DAM
 */
public class CuentaBancaria {
    double saldo;
    int numeroCuenta;
    int meses;
    boolean seccionCritica;
    Fichero fichero;
    
    public CuentaBancaria(int numero, Fichero fichero){
        //Al crear una cuenta en nuestro Banco le regalamos 1000€ !!!
        saldo = 1000;
        numeroCuenta = numero;
        meses = 0;
        seccionCritica = false;
        this.fichero = fichero;
        this.fichero.escribe("Ha sido creada la cuenta " + numeroCuenta);
    }
    
    public void ingresar(int dni, int dinero){
        esperar();
        saldo += dinero;
        fichero.escribe("El cliente " + dni + " ha ingresado " + dinero + " € en la cuenta " + numeroCuenta + "(Saldo: " + saldo + ")");
        continuar();
    }
    
    public void retirar(int dni, int dinero){
        esperar();
        if(this.puedeRetirar(dinero)){
            saldo -= dinero;
            fichero.escribe("El cliente " + dni + " ha retirado " + dinero + " € en la cuenta " + numeroCuenta + "(Saldo: " + saldo + ")");
        }
        else{
            fichero.escribe("El cliente " + dni + " no ha podido retirar " + dinero + " € en la cuenta " + numeroCuenta);
        }
        continuar();
    }
    
    public void consultar(int dni){
        fichero.escribe("El cliente " + dni + " consulta el saldo de su cuenta " + numeroCuenta + ": " + saldo + " € ");
    }
    
    public void transferencia(int dni, int dinero, CuentaBancaria cuenta){
        if(this.puedeRetirar(dinero)){
            this.retirar(dni, dinero);
            cuenta.ingresar(dni, dinero);
            fichero.escribe("El cliente " + dni + " ha transferido " + dinero + " € hacia la cuenta " + cuenta.getNumeroCuenta());
        }
        else{
            fichero.escribe("El cliente " + dni + " no puede transferir " + dinero + " € hacia la cuenta " + cuenta.getNumeroCuenta());
        }
        
    }
    
    public boolean puedeRetirar(int dinero){
        boolean puede = false;
        if(saldo >= dinero)
            puede = true;
        return puede;
    }
    
    public int getNumeroCuenta(){
        return this.numeroCuenta;
    }

    public void actualizarCuenta(){
        meses++;
        fichero.escribe("---------------------------------- MES " + meses + " CUENTA " + numeroCuenta + "---------------------------------");
        fichero.escribe("Ha pasado un mes pero la cuenta " + numeroCuenta + " es normal");
    }
    
    public synchronized void esperar(){
        while(seccionCritica){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        seccionCritica = true;
    }
    
    public synchronized void continuar(){
        seccionCritica = false;
        notifyAll();
    }
    
}
