package ttet.exerciciosjava.exerciciobasico02;

import java.util.List;

public class ListaVazia {

    public int listMean(List<Integer> numeros){
        if(numeros.isEmpty()){
         return 0;
        }
        int sum = 0;

        for (int num : numeros){
            sum += num;
        }
    return sum / numeros.size();
    }
}
