package bingo;

import BingoUtilidades.Utilidades;
import java.util.Collections;
import java.util.LinkedList;

public class Juego {

    private LinkedList<Integer> bombo;
    private LinkedList<Integer> bolasExtraidas;
    private LinkedList<Carton> cartones;
    private LinkedList<Carton> cartonesGanadores;

    public Juego() {
        this.bombo = new LinkedList<>(Utilidades.getNumeros());
        this.bolasExtraidas = new LinkedList<>();
        this.cartones = new LinkedList<>();
        this.cartonesGanadores = new LinkedList<>();
    }

    public boolean finalizado() {
        boolean res = false;
        if (this.bombo.isEmpty()) {
            res = true;
        }

        if (this.cartonesGanadores.size() > 1) {
            res = true;
        }

        return res;
    }

    public boolean comprobarCarton(Carton c) {
        return this.bolasExtraidas.containsAll(c.getNumeros());
    }

    public Carton generarCarton() {
        LinkedList<Integer> numeros = new LinkedList<>(this.bombo);
        LinkedList<Integer> numerosCarton = new LinkedList<>();
        Collections.shuffle(numeros);
        for (int i = 1; i <= Utilidades.TAMAÑO_CARTON; i++) {
            numerosCarton.add(numeros.pop());
        }
        Carton c = new Carton(numerosCarton);
        this.cartones.add(c);
        return c;
    }

    public int extraerBola() {
        Collections.shuffle(this.bombo);
        this.bolasExtraidas.add(this.bombo.peekFirst()); 
        for (Carton c : this.cartones) {
            if (comprobarCarton(c)) {
                this.cartonesGanadores.add(c);
                break;
            }
        }

        return this.bombo.pop(); 
    }
}
