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
public class BancoHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CuentaBancaria[] cuentas = new CuentaBancaria[4];
        cuentas[0] = new CuentaBancaria(0);
        cuentas[1] = new CuentaBancaria(1);
        
        cuentas[2] = new CuentaAhorro(2);
        
        cuentas[3] = new CuentaDeposito(3);
        
        Cliente cliente10 = new Cliente(10, cuentas, 0);
        Cliente cliente11 = new Cliente(11, cuentas, 0);
        Cliente cliente20 = new Cliente(20, cuentas, 1);
        Cliente cliente21 = new Cliente(21, cuentas, 1);
        
        Cliente cliente30 = new Cliente(30, cuentas, 2);
        
        Cliente cliente40 = new Cliente(40, cuentas, 3);
        
        cliente10.start();
        cliente11.start();
        cliente20.start();
        cliente21.start();
        cliente30.start();
        cliente40.start();
        
        /*
        
        
        HAY QUE ARREGLAR EL ESCRIBIR EN FICHEROS
        
        
        */
        
        
        
        
    }
    
}
