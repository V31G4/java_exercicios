package ttet.exerciciosjava.exerciciobasico02;

import java.util.ArrayList;
import java.util.List;

public class ListaVaziaMain {
    public static void main(String[] args) {
        ListaVazia listavazia = new ListaVazia();
        List<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(30);
        numeros.add(20);

        int mean = listavazia.listMean(numeros);
        System.out.println(mean);
    }
}
