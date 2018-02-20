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
    
    public CuentaDeposito(int numero){
        super(numero);
        saldo = 3000;
    }
    
    @Override
    public synchronized void retirar(int dni, int dinero){
        if(meses < 12)
            writer.print("No se puede retirar del depósito aún: ");
        else{
            writer.print("Ya se puede retirar del depósito: ");
            super.retirar(dni, dinero);
        }
    }
    
    @Override
    public void actualizarCuenta(){
        meses++;
        writer.println("---------------------------------- MES " + meses + " CUENTA " + numeroCuenta + " ---------------------------------");
        if(meses < 12)
            writer.println("Aún no han pasado 12 meses para actualizar el depósito " + numeroCuenta);
        else{
            saldo = saldo + saldo * 0.1;
            writer.println("Han pasado 12 meses y el depósito " + numeroCuenta + " recibe una remuneración del 1% (Saldo: " + saldo + ")");
        }
    }
}
