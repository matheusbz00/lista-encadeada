package br.univille.dados.estrutura;

import java.util.Comparator;
import java.util.List;

public class SelectorSort<T> {

    public SelectorSort() {
        super();
    }


    public void sort(List<T> list, Comparator<T> comparator) {
        for(int i = 0; i<list.size(); i++) {
            int menor = i;
            for(int j = i + 1; j < list.size(); j++) {
                if(comparator.compare(list.get(j), list.get(menor)) == - 1) {
                    menor = j;
                }
            }
            T temp = list.get(i);
            list.set(i,list.get(menor));
            list.set(menor,temp);
        }
    }
}