package model;

public class Conexoes {                          // Aresta
    private static int contador = 0; 
    private String id;
    private Poste origem;
    private Poste destino;
    private Double distancia; //peso

    public Conexoes(Poste origem, Poste destino, Double distancia) {
        this.id = String.valueOf(contador++);
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Conexoes conexao = (Conexoes) obj;
        
        // Como o grafo é não direcionado, (A, B) e (B, A) devem ser considerados iguais
        return (origem.equals(conexao.origem) && destino.equals(conexao.destino) ||
                origem.equals(conexao.destino) && destino.equals(conexao.origem))
                && distancia.equals(conexao.distancia);
    }

    @Override
    public int hashCode() {
        // Garante que (A, B) e (B, A) tenham o mesmo hash
        return origem.getId().hashCode() + destino.getId().hashCode() + distancia.hashCode();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Poste getOrigem() {
        return origem;
    }

    public void setOrigem(Poste origem) {
        this.origem = origem;
    }

    public Poste getDestino() {
        return destino;
    }

    public void setDestino(Poste destino) {
        this.destino = destino;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }
}