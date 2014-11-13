//Classe cujos objetos representam os blocos utilizados no jogo Minecraft
package Classes_associadas;

/**
 *
 * @author Crispino
 */
public class Bloco {
    //enum que define de quais tipos o bloco pode ser
    public enum Tipo{
        PEDRA, PEDREGULHO,TIJOLO, OURO, GELO, 
    }
    //variável que guarda o nome do tipo correspondente ao bloco.
    private String tipo;
    //variável que indica o tempo que o bloco leva para ser minerado por uma dada picareta
    //para a posição 0, indica o tempo levado por uma picareta de madeira.
    //para a posição 1, para uma picareta de diamante
    private double tempo[];
    //variável que indica se o bloco está quebrado
    private boolean quebrado;
    
    //construtor que define os tempos de acordo com o tipo de bloco escolhido.
    public Bloco(Tipo tipo){
        this.quebrado = false;
        this.tempo = new double[2];
        
        switch (tipo){
                case PEDRA:
                    this.tipo = "Pedra";
                    this.tempo[0] = 1.15;
                    this.tempo[1] = 0.3;
                    break;
                case PEDREGULHO:
                    this.tipo = "Pedregulho";
                    this.tempo[0] = 1.5;
                    this.tempo[1] = 0.4;
                    break;
                case TIJOLO:
                    this.tipo = "Tijolo";
                    this.tempo[0] = 3;
                    this.tempo[1] = 3;
                    break;
                case OURO:
                    this.tipo = "Ouro";
                    this.tempo[0] = 15;
                    this.tempo[1] = 0.6;
                    break;
                case GELO:
                    this.tipo = "Gelo";
                    this.tempo[0] = 0.4;
                    this.tempo[1] = 0.1;
                    break;
        }
    }
    
    //construtor vazio, que define o bloco como de pedra, por padrão
    public Bloco(){
        tempo = new double[2];
        
        tempo[0] = 1.15;
        tempo[1] = 0.3;
        
        this.quebrado = false;
    }
    
    public double getTempo1(){
        return this.tempo[0];
    }
    
    public double getTempo2(){
        return this.tempo[1];
    }
    
    public void setQuebrado(boolean quebrado){
        this.quebrado = quebrado;
    }
    
    public boolean quebrado(){
        return this.quebrado;
    }
    
    @Override
    public String toString(){
        String s = "Bloco de " + this.tipo;
        return s;
    }
}
