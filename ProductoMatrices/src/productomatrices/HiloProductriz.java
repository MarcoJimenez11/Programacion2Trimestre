/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productomatrices;

/**
 *
 * @author Usuario DAM
 */
public class HiloProductriz extends Thread{
    private BufferMatrices buffer;
    private int numero;
    private int hebras;
    
    //El constructor recibe el buffer que contiene las matrices,
    //el número de hebra que es y la cantidad de hebras total
    public HiloProductriz(BufferMatrices buffer, int numero, int hebras){
        this.buffer = buffer;
        this.numero = numero;
        this.hebras = hebras;
    }
    
    @Override
    public void run(){
        //recibe del buffer el valor de la fila y columna de la matriz resultado
        //(al ser nxn da igual si es fila o columna pero para hacerlo más
        //entendible lo hago así
        int filA = buffer.getFilA();
        int colB = buffer.getFilA();
        int valor = 0;
        
        for(int i = numero; i < filA; i += hebras){
            for(int j = 0; j < colB; j++){
                for(int k = 0; k < colB; k++){
                    valor += buffer.getValorPosicion(1, i, k) * buffer.getValorPosicion(2, k, j);
                }
                buffer.setValorPosicion(valor, i, j);
                valor = 0;
            }
        }
    }
}
