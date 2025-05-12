import java.util.List;

public class Individuo {
    // Valores dos pontos
    protected double[] x;
    // Valores avliado nas funcoes
    protected double[] f;
    // Individuos dominados
    protected List<Individuo> s;
    // Quantidade de vezes que ele eh dominado
    protected int n;
    // Seu rank
    protected int rank;
    // Sua classificação
    protected double d;
    //Descricao
    protected String desc;

    public Individuo(double[] f, String desc) {
        this.f = f;
        this.desc = desc;
    }

    public double[] getAvaliacao(){
        return f;
    }

    public boolean ehMenorQue(Individuo comp) {
        int tam = this.f.length;
        int menor = 0;
        for (int i = 0; i < tam; i++) {
            if(this.f[i] > comp.f[i]){
                // Maior
                menor = -1;
                break;
            }else if(this.f[i] < comp.f[i]){
                // Menor
                menor = 1;
            }// Else entao eh igual
        }
        if(menor == 1){
            // O ponto this domina o ponto comp
            return true;
        }else {
            // O ponto this nao domina o ponto comp
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(d > 0){
            return desc + "{(" +f[0] + ", " +f[1]  + ") d: " + d + "}";
        }else{
            return desc + "(" +f[0] + ", " +f[1]  + ")";
        }
    }
}
