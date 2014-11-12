/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package picareta;

/**
 *
 * @author Crispino
 */
public class Bloco {
    //enum que define de quais tipos o bloco pode ser
    public enum Tipo{
        PEDRA, PEDREGULHO,TIJOLO, OURO, GELO, 
    }
    String tipo;
    //variável que indica o tempo que o bloco leva para ser minerado por uma dada picareta
    //para a posição 0, indica o tempo levado por uma picareta de madeira.
    //para a posição 1, para uma picareta de diamante
    double tempo[];
    boolean quebrado;
    
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
    
    double getTempo1(){
        return this.tempo[0];
    }
    
    double getTempo2(){
        return this.tempo[1];
    }
    
    void setQuebrado(boolean quebrado){
        this.quebrado = quebrado;
    }
    
    @Override
    public String toString(){
        String s = "Bloco de " + this.tipo;
        return s;
    }
}
