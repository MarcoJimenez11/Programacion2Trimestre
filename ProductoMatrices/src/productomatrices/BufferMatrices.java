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
public class BufferMatrices {
    private int[][] matrizA;
    private int[][] matrizB;
    private int[][] matrizResultado;
    private int filA;
    private int colB;
    
    public BufferMatrices(int[][] matrizA, int[][] matrizB, int filA, int colB){
        this.matrizA = matrizA;
        this.matrizB = matrizB;
        this.filA = filA;
        this.colB = colB;
        this.matrizResultado = new int[filA][colB];
    }
    
    public int getFilA(){
        return filA;
    }
    
    public int getValorPosicion(int matriz, int fila, int columna){
        int resultado = 0;
        if(matriz == 1)
            resultado = matrizA[fila][columna];
        else
            resultado = matrizB[fila][columna];
        return resultado;
    }
    
    public void setValorPosicion(int valor, int fila, int columna){
        matrizResultado[fila][columna] = valor;
    }
    
    public void MostrarMatriz(){
        for(int i = 0; i < filA; i++){
            for(int j = 0; j < colB; j++)
                System.out.print(matrizResultado[i][j] + "  ");
            System.out.println("");
        }
    }
}
