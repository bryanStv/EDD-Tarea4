package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int[] vector = rellenarVectorInicial(dato);
        vector=generarPrimos(dato);
        imprimirResultado(dato, vector,true);
    }
    //Rellenar Vector de 1 hasta dato
    private static int[] rellenarVectorInicial(int dato) {
        int vector[]=new int[dato];
        imprimirResultado(dato,vector,false);
        return vector;
    }

    private static void imprimirResultado(int dato, int[] vector,boolean posicionOvalor) {
        if(posicionOvalor) {
            System.out.println("\nVector de primos hasta:" + dato);
            for (int i = 0; i < vector.length; i++) {
                if (i % 10 == 0) System.out.println();
                System.out.print(vector[i] + "\t");
            }
        }else{
            System.out.println("\nVector inicial hasta :"+ dato);
            for (int i = 0; i < vector.length; i++) {
                if (i%10==0) System.out.println();
                System.out.print(i+1+"\t");
            }
        }
    }


    // Generar números primos de 1 a max
    public static int[] generarPrimos (int max)
    {
        if (max >= 2) {
            // Declaraciones
            int dim = tamañoArray(max); // Tamaño del array
            boolean[] esPrimo = getVectorBooleanoInicial(dim);
            cribaMultiplos2(dim, esPrimo);
            int cuenta = getCuantosPrimos(dim, esPrimo);
            return primos(cuenta, dim, esPrimo);
        } else { // max < 2
            // Vector vacío
            return new int[0];
        }
    }
    private static int tamañoArray(int max) {
        return max + 1;
    }
    private static int[] primos(int cuenta, int dim, boolean[] esPrimo) {
        int j;
        int i;
        // Rellenar el vector de números primos
        int[] primos = new int[cuenta];
        for (i=0, j=0; i< dim; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }

    private static int getCuantosPrimos(int dim, boolean[] esPrimo) {
        int i;
        // ¿Cuántos primos hay?
        int cuenta = 0;
        for (i=0; i< dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }

    private static void cribaMultiplos2(int dim, boolean[] esPrimo) {
        int j;
        int i;
        // Criba
        for (i=2; i<Math.sqrt(dim)+1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (j=2*i; j< dim; j+=i)
                    esPrimo[j] = false;
            }
        }
    }

    private static boolean[] getVectorBooleanoInicial(int dim) {
        int i;
        boolean[] esPrimo = new boolean[dim];
        // Inicializar el array
        for (i=0; i< dim; i++)
            esPrimo[i] = true;
        // Eliminar el 0 y el 1, que no son primos
        esPrimo[0] = esPrimo[1] = false;
        return esPrimo;
    }
}