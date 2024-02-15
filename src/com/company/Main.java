package com.company;
import java.util.Scanner;
public class Main {
    /**
     * Método Main.
     *
     * @param args dato principal del método main.
     */
    public static void main(String[] args) {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int dato=teclado.nextInt();
        int[] vector = rellenarVectorInicial(dato);
        vector=generarPrimos(dato);
        imprimirResultado(dato, vector,true);
    }
    /**
     * Rellenar Vector de 1 hasta dato.
     *
     * @param dato dato introducido por el usuario.
     * @return vector rellenado de 1 a dato.
     */
    public static int[] rellenarVectorInicial(int dato) {
        int vector[]=new int[dato];
        imprimirResultado(dato,vector,false);
        return vector;
    }
    /**
     * Método imprimir resultado, depende del booleano posicionOvalor, recorrerá el vector por posiciones o valores.
     * @param dato dato.
     * @param vector vector de enteros.
     * @param posicionOvalor booleano para saber si se trata de una posición o un valor.
     * imprime el resultado del vector.
     */
    public static void imprimirResultado(int dato, int[] vector,boolean posicionOvalor) {
        boolean aux = true;
        if(posicionOvalor) {
            System.out.println("\nVector de primos hasta:" + dato);
        }else{
            System.out.println("\nVector inicial hasta :"+ dato);
            aux = false;
        }
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) System.out.println();
            if(aux){
                System.out.print(vector[i] + "\t");
            }else{
                System.out.print(i+1+"\t");
            }
        }
    }


    /**
     * Generar primos de 1 a max.
     *
     * @param max dato introducido por el usuario.
     * @return vector rellenado de 1 a dato.
     */
    public static int[] generarPrimos (int max)
    {
        if (max >= 2) {
            // Declaraciones
            int dim = max+1; // Tamaño del array
            boolean[] esPrimo = getVectorBooleanoInicial(dim);
            cribaMultiplos2(dim, esPrimo);
            int cuenta = getCuantosPrimos(dim, esPrimo);
            return primos(cuenta, dim, esPrimo);
        } else { // max < 2
            // Vector vacío
            return new int[0];
        }
    }
    /**
     * Rellenar vector con números primos.
     *
     * @param cuenta introducido por el usuario.
     * @param dim introducido por el usuario.
     * @param esPrimo introducido por el usuario.
     * @return primos rellenado vector de números primos.
     */
    public static int[] primos(int cuenta, int dim, boolean[] esPrimo) {
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
    /**
     * Cuenta cuantos números primos hay en un vector.
     *
     * @param dim dimensión del vector.
     * @param esPrimo vector con números primos y no primos.
     * @return Entero con el número de primos que hay.
     */
    public static int getCuantosPrimos(int dim, boolean[] esPrimo) {
        int i;
        // ¿Cuántos primos hay?
        int cuenta = 0;
        for (i=0; i< dim; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }
    /**
     * Metodo para poner todos los números multiplos de 2 en false, no devuelve nada pero hace cambios sobre el vector boolean[] esPrimo.
     *
     * @param dim dimensión del vector.
     * @param esPrimo vector con números primos y no primos.
     */
    public static void cribaMultiplos2(int dim, boolean[] esPrimo) {
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
    /**
     * Crear vector inicial.
     *
     *
     * @param dim dimensión del vector.
     * @return vector de booleanos inicializado con todos en true menos el primero y el segundo.
     */
    public static boolean[] getVectorBooleanoInicial(int dim) {
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