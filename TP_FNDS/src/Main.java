import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Individuo> indList = new ArrayList<Individuo>();
        indList.add(new Individuo(new double[]{2,3},"B"));
        indList.add(new Individuo(new double[]{3,4},"D"));
        indList.add(new Individuo(new double[]{4,3},"E"));
        indList.add(new Individuo(new double[]{4,1},"C"));
        indList.add(new Individuo(new double[]{1,5},"A"));
        indList.add(new Individuo(new double[]{5,5},"F"));

        List<List<Individuo>> fronteiraList = FNDS.fnds(indList);
        // Imprimir as fronteiras
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
}