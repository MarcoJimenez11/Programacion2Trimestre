/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancohilos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario DAM
 */
public class BancoHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        Fichero fichero = new Fichero();
        CuentaBancaria[] cuentas = new CuentaBancaria[4];
        cuentas[0] = new CuentaBancaria(0, fichero);
        cuentas[1] = new CuentaBancaria(1, fichero);
        
        cuentas[2] = new CuentaAhorro(2, fichero);
        
        cuentas[3] = new CuentaDeposito(3, fichero);
        
        Cliente cliente01 = new Cliente(01, cuentas, 0);
        Cliente cliente02 = new Cliente(02, cuentas, 0);
        Cliente cliente11 = new Cliente(11, cuentas, 1);
        Cliente cliente12 = new Cliente(12, cuentas, 1);
        
        Cliente cliente21 = new Cliente(21, cuentas, 2);
        
        Cliente cliente31 = new Cliente(31, cuentas, 3);
        
        cliente01.start();
        cliente02.start();
        cliente11.start();
        cliente12.start();
        cliente21.start();
        cliente31.start();
        
        try {
            cliente01.join();
            cliente02.join();
            cliente11.join();
            cliente12.join();
            cliente21.join();
            cliente31.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(BancoHilos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        fichero.cerrarFichero();
        System.out.println("FIN");
    }
    
}
