
package BingoUtilidades;

import java.util.ArrayList;

public class Utilidades {
    public final static int BOLA_MAYOR = 30;
    public final static int TAMAÑO_CARTON = 9;
    public static ArrayList<Integer> getNumeros() {
        ArrayList<Integer> num = new ArrayList<>();
        for(int i = 1; i <= BOLA_MAYOR; i++) {
            num.add(i);
        }
        return num;
    }
}
