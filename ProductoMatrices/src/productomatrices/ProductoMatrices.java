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
public class ProductoMatrices {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        int filA = 1000;
        int colA = 1000;
        int filB = 1000;
        int colB = filA;
        
        int[][] matrizA = new int[filA][colA];
        int[][] matrizB = new int[filB][colB];
        int[][]matrizResultado = new int[filA][colB];
        
        System.out.println("Producto de las dos siguientes matrices: \n");
        
        for(int i = 0; i < filA; i++){
            for(int j = 0; j < colA; j++)
                matrizA[i][j] = (int) (Math.random() * 9+1);
        }
        for(int i = 0; i < filB; i++){
            for(int j = 0; j < colB; j++)
                matrizB[i][j] = (int) (Math.random() * 9+1);
        }
        
        for(int i = 0; i < filA; i++){
            for(int j = 0; j < colA; j++)
                System.out.print(matrizA[i][j] + "  ");
            System.out.println("");
        }
        System.out.println("");
        for(int i = 0; i < filB; i++){
            for(int j = 0; j < colB; j++)
                System.out.print(matrizB[i][j] + "  ");
            System.out.println("");
        }
        /*
        
        ------HASTA AQUÍ ES SOLO DECLARACIÓN Y MUESTRA DE MATRICES-------
        
        */
        System.out.println("\n Resultado de producto: \n");
        long tiempo = System.currentTimeMillis();
        //Producto de matrizA con matrizB, guardado el resultado en MatrizResultado
        for(int i = 0; i < filA; i++){
            for(int j = 0; j < colB; j++){
                for(int k = 0; k < colB; k++)
                    matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
            }
        }
        
        tiempo = (System.currentTimeMillis()- tiempo);
        System.out.println("Tiempo de ejecución en secuencial: " + tiempo);
        for(int i = 0; i < filA; i++){
            for(int j = 0; j < colB; j++)
                System.out.print(matrizResultado[i][j] + "  ");
            System.out.println("");
        }
        
        System.out.println("\n Ahora con hebras: \n");
        
        BufferMatrices buffer = new BufferMatrices(matrizA, matrizB, filA, colB);
        HiloProductriz hilo1 = new HiloProductriz(buffer,0,4);
        HiloProductriz hilo2 = new HiloProductriz(buffer,1,4);
        HiloProductriz hilo3 = new HiloProductriz(buffer,2,4);
        HiloProductriz hilo4 = new HiloProductriz(buffer,3,4);
        
        tiempo = System.currentTimeMillis();
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();
        tiempo = (System.currentTimeMillis()- tiempo);
        System.out.println("Tiempo de ejecución en paralelo: " + tiempo);
        
        buffer.MostrarMatriz();
    }
}
