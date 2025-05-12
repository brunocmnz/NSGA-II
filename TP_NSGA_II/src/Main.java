import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void sortByObjetivo(List<Individuo> fronteira, int posObjetivo) {
        fronteira.sort(Comparator.comparingDouble(o -> o.f[posObjetivo]));
    }

    public static void crowdingDistance(List<List<Individuo>> fronteiras) {
        for (List<Individuo> fronteira : fronteiras) {
            int mlen = fronteira.get(0).f.length;

            // Inicializa d = 0 para todos
            for (Individuo ind : fronteira) {
                ind.d = 0.0;
            }

            for (int m = 0; m < mlen; m++) {
                sortByObjetivo(fronteira, m);

                fronteira.get(0).d = Double.POSITIVE_INFINITY;
                fronteira.get(fronteira.size() - 1).d = Double.POSITIVE_INFINITY;

                double fm_min = fronteira.get(0).f[m];
                double fm_max = fronteira.get(fronteira.size() - 1).f[m];

                if (fm_max - fm_min == 0) continue; // evita divisão por zero

                for (int i = 1; i < fronteira.size() - 1; i++) {
                    double distancia = (fronteira.get(i + 1).f[m] - fronteira.get(i - 1).f[m]) / (fm_max - fm_min);
                    fronteira.get(i).d += distancia;
                }
            }
        }
    }


    public static void imprimeFronteiras(List<List<Individuo>> fronteiraList){
        int f = 1;
        for (List<Individuo> fronteira : fronteiraList) {
            System.out.print("F"+f+"\t");
            for (Individuo individuo : fronteira) {
                System.out.print(individuo + "\t");
            }
            f++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<Individuo> indList = new ArrayList<Individuo>();
        indList.add(new Individuo(new double[]{1,5},"A"));
        indList.add(new Individuo(new double[]{2,3},"B"));
        indList.add(new Individuo(new double[]{4,1},"C"));
        indList.add(new Individuo(new double[]{4,3},"E"));
        indList.add(new Individuo(new double[]{5,5},"F"));

//        indList.add(new Individuo(new double[]{3,4},"D"));
        indList.add(new Individuo(new double[]{1.5,4},"D"));

        List<List<Individuo>> fronteiraList = FNDS.fnds(indList);

        imprimeFronteiras(fronteiraList);

        crowdingDistance(fronteiraList);

        System.out.println();
        imprimeFronteiras(fronteiraList);
    }
}