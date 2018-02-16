/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancohilos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Usuario DAM
 */
public class CuentaBancaria {
    double saldo;
    int numeroCuenta;
    int meses;
    boolean puedeActualizar;
    FileWriter fichero;
    PrintWriter writer;
    
    public CuentaBancaria(int numero){
        //Al crear una cuenta en nuestro Banco le regalamos 1000€ !!!
        saldo = 1000;
        numeroCuenta = numero;
        meses = 0;
        puedeActualizar = true;
        try{
            fichero = new FileWriter("src/ficheros/registrosBanco.txt", true);
            writer = new PrintWriter(fichero);
            writer.println("Ha sido creada la cuenta " + numeroCuenta);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    public synchronized void ingresar(int dni, int dinero){
        while(!puedeActualizar){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        saldo += dinero;
        puedeActualizar = false;
        notifyAll();
        writer.println("El cliente " + dni + " ha ingresado " + dinero + " € en la cuenta " + numeroCuenta + "(Saldo: " + saldo + ")");
    }
    
    public synchronized void retirar(int dni, int dinero){
        while(puedeActualizar){
            try{
                wait();
            }catch(InterruptedException e){}
        }
        if(this.puedeRetirar(dinero)){
            saldo -= dinero;
            writer.println("El cliente " + dni + " ha retirado " + dinero + " € en la cuenta " + numeroCuenta + "(Saldo: " + saldo + ")");
            puedeActualizar = true;
            notifyAll();
        }
        else{
            writer.println("El cliente " + dni + " no ha podido retirar " + dinero + " € en la cuenta " + numeroCuenta);
        }
    }
    
    public synchronized void consultar(int dni){
        writer.println("El cliente " + dni + " consulta el saldo de su cuenta " + numeroCuenta + ": " + saldo + " € ");
    }
    
    public synchronized void transferencia(int dni, int dinero, CuentaBancaria cuenta){
        if(this.puedeRetirar(dinero)){
            this.retirar(dni, dinero);
            cuenta.ingresar(dni, dinero);
            writer.println("El cliente " + dni + " ha transferido " + dinero + " € hacia la cuenta " + cuenta.getNumeroCuenta());
        }
        else{
            writer.println("El cliente " + dni + " no puede transferir " + dinero + " € hacia la cuenta " + cuenta.getNumeroCuenta());
        }
        
    }
    
    public synchronized boolean puedeRetirar(int dinero){
        boolean puede = false;
        if(saldo >= dinero)
            puede = true;
        return puede;
    }
    
    public synchronized int getNumeroCuenta(){
        return this.numeroCuenta;
    }

    public synchronized void actualizarCuenta(){
        meses++;
        writer.println("---------------------------------- MES " + meses + " ---------------------------------");
        writer.println("Ha pasado un mes pero la cuenta " + numeroCuenta + " es normal");
    }
}
