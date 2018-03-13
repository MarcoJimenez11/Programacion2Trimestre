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
public class CuentaDeposito extends CuentaBancaria{
    
    public CuentaDeposito(int numero, Fichero fichero){
        super(numero, fichero);
        saldo = 3000;
    }
    
    @Override
    public synchronized void retirar(int dni, int dinero){
        if(meses < 12)
            fichero.escribe("No se puede retirar del depósito aún: ");
        else{
            fichero.escribe("Ya se puede retirar del depósito: ");
            super.retirar(dni, dinero);
        }
    }
    
    @Override
    public boolean puedeRetirar(int dinero){
        boolean puede = false;
        if(saldo >= dinero && meses > 11)
            puede = true;
        return puede;
    }
        
    @Override
    public void actualizarCuenta(){
        meses++;
        fichero.escribe("---------------------------------- MES " + meses + " CUENTA " + numeroCuenta + " ---------------------------------");
        if(meses < 12)
            fichero.escribe("Aún no han pasado 12 meses para actualizar el depósito " + numeroCuenta);
        else{
            saldo = saldo + saldo * 0.1;
            fichero.escribe("Han pasado 12 meses y el depósito " + numeroCuenta + " recibe una remuneración del 1% (Saldo: " + saldo + ")");
        }
    }
}
