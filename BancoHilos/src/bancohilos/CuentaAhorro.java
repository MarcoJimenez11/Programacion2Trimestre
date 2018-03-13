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
public class CuentaAhorro extends CuentaBancaria {
    
    public CuentaAhorro(int numero,Fichero fichero) {
        super(numero, fichero);
    }
    
    @Override
    public void actualizarCuenta(){
        meses++;
        fichero.escribe("---------------------------------- MES " + meses + " CUENTA " + numeroCuenta + " ---------------------------------");
        saldo = saldo + saldo*0.025;
        fichero.escribe("Ha pasado un mes y la cuenta ahorro " + numeroCuenta + " recibe un 0,25% de interés (Saldo: " + saldo + ")");
    }
}
