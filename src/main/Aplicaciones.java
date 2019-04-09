
package main;

import bingo.Juego;
import bingo.Carton;
import java.util.ArrayList;

public class Aplicaciones {

    public static void main(String[] args) {
        Juego bingo = new Juego();
        Carton c1 = new Carton(1), c2 = new Carton(2), c3 = new Carton(3);
        ArrayList<Carton> cartones = new ArrayList<>(3);
        cartones.add(c1);
        cartones.add(c2);
        cartones.add(c3);
        for (Carton c : cartones) {
            System.out.println("NUMEROS DEL CARTON: " + c.getNumeroCarton());
            c = bingo.generarCarton();
            System.out.println(c.getNumeros().toString());
        }

        do {
            int bola = bingo.extraerBola();
            System.out.println("BOLA EXTRAIDA: " + bola);
        } while (!bingo.finalizado());

        System.out.println("\nFIN DEL BINGO");
        for (Carton c : cartones) {
            if (bingo.comprobarCarton(c)) {
                System.out.println("CARTON " + c.getNumeroCarton() + " GANADOR");
            }
        }
    }

}
