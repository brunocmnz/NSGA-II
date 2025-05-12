import java.util.ArrayList;
import java.util.List;

public class FNDS {

    public static List<List<Individuo>> fnds(List<Individuo> P){
        // Codificar a parte I e II do FNDS
        List<List<Individuo>> F = new ArrayList<>();
        // Parte I
        List<Individuo> f1 = new ArrayList<>();
        for(Individuo p : P){
            p.s = new ArrayList<>();
            p.n = 0;
            // Percorre todos os pontos
            for(Individuo q : P){
                if(p.ehMenorQue(q)){
                    // p domina q
                    p.s.add(q);
                }else if(q.ehMenorQue(p)){
                    // qdomina p
                    p.n++;
                }
            }
            if (p.n == 0){
                // Nao foi dominado entao ta na fronteira 1
                p.rank = 1;
                f1.add(p);
            }
        }
        F.add(f1);

        // Parte II
        int i = 0;
        while (true){
            List<Individuo> Q = new ArrayList<>();
            // Percorre os individuos na ultima fronteira
            for (Individuo p : F.get(i)) {
                // Percorre os individuos
                for (Individuo q : p.s) {
                    q.n--;
                    if(q.n == 0){
                        // O ponto q esta na fronteira atual
                        q.rank = i + 2;
                        Q.add(q);
                    }
                }
            }
            if (Q.isEmpty()){
                // Nao encontrou nova fronteira
                break;
            }
            // Insere a fronteira e incrementa i
            F.add(Q);
            i++;
        }

        return F;
    }
}
