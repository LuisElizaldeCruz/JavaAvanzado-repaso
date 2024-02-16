package arreglosoperaciones;

import java.util.Arrays;

public class UnirDosArreglos {

    public static void main(String[] args) {
        int arreglo1[] = {1, 2, 6, 8, 9};
        int arreglo2[] = {3, 5, 6, 9};
        int arreglo3[] = new int[arreglo1.length + arreglo2.length];
int temp;
        for (int i = 0; i < arreglo1.length; i++) {
            arreglo3[i] = arreglo1[i];
            //System.out.print(arreglo1[i]);
        }
        for (int j = 0; j < arreglo2.length; j++){
            arreglo3[j+arreglo1.length] = arreglo2[j];
           // System.out.print(arreglo3[j+arreglo1.length]+ " ");
        }
        System.out.println(Arrays.toString(arreglo3));

        for (int k = 0; k < arreglo3.length; k++) {
            for (int l = 0; l < arreglo3.length-k-1 ; l++) {
                if (arreglo3[l] > arreglo3[l+1]) {
                    temp =  arreglo3[l];
                    arreglo3[l] = arreglo3[l+1];
                    arreglo3[l+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arreglo3));
    }
}