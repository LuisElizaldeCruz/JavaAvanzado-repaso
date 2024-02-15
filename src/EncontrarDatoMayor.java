public class EncontrarDatoMayor {

    public static void main(String[] args) {
        int cadena[] = {3,32,43,2,43,32};
        int nMayor = cadena[0];
        int posicion=0;

        for(int i=0; i < cadena.length; i++){
            if(cadena[i] > nMayor){
                nMayor = cadena[i];
                posicion = i;
            }
        }
        System.out.println("El numero mas grande es: " + nMayor + " en la posicion" + posicion);
    }

}
