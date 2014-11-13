//Classe que representa a picareta do jogo Minecraft
package picareta;

import Classes_associadas.Bloco;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Crispino
 */
public abstract class Picareta {

    /**
     * @param args the command line arguments
     */
   
    //durabilidade da picareta(quantos usos ela leva para quebrar).
    protected int durabilidade;
    //variável booleana que indica se a picareta está quebrada.
    protected boolean quebrado;
    
    //construtor
    protected Picareta(int durabilidade){
        this.durabilidade = durabilidade;
        this.quebrado = false;
    }
    //construtor de cópia
    protected Picareta(Picareta p){
        this.durabilidade = p.durabilidade;
        this.quebrado = p.quebrado;
    }
    
    //quebra a picareta modificando a variável 'quebrado'
    public void quebrarPicareta(){
        this.quebrado = true;
    }
    
    public boolean quebrado(){
        return this.quebrado;
    }
    
    public void setQuebrado(boolean quebrado){
        this.quebrado = quebrado;
    }
    
    public abstract void quebrarBloco(Bloco B);
    
    @Override
    public abstract String toString();
}
