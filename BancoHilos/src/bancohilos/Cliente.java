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
public class Cliente extends Thread{
    private final CuentaBancaria cuenta;
    private final CuentaBancaria[] allCuentas;
    private final int dni;
    private static int diasMes = 0;
    
    public Cliente(int dni, CuentaBancaria[] cuentas, int numeroCuenta){
        this.dni = dni;
        this.allCuentas = cuentas;
        this.cuenta = cuentas[numeroCuenta];
    }
    
    @Override
    public void run(){
        int aleatorio;
        int dinero;
        int numeroOtraCuenta;
        while(true){
            aleatorio = (int) (Math.random() * 4);
            dinero = (int) (Math.random() * 1000)+1;
            
            try{
                sleep((long) (Math.random()*3000)+1000);
            }catch(InterruptedException e){
                System.out.println("Error al dormir, no tiene sueño nuestro amigo el cliente");
            }
            
            switch(aleatorio){
                case 0:
                    cuenta.consultar(dni);
                    break;
                case 1:
                    cuenta.ingresar(dni, dinero);
                    break;
                case 2:
                    cuenta.retirar(dni, dinero);
                    break;
                case 3:
                    numeroOtraCuenta = (int) (Math.random() * allCuentas.length);
                    CuentaBancaria otraCuenta = allCuentas[numeroOtraCuenta];
                    cuenta.transferencia(dni, dinero, otraCuenta);
                    break;
            }
            diasMes++;
            if(diasMes >= 30){
                diasMes = 0;
                for(int i = 0; i < allCuentas.length; i++)
                    allCuentas[i].actualizarCuenta();
            }
        }
    }
}
