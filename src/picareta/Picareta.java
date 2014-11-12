/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package picareta;

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
    
    //quebra a picareta modificando a variável 'quebrado'
    public void quebrarPicareta(){
        this.quebrado = true;
    }
    
    public boolean quebrado(){
        return this.quebrado;
    }
    
    public abstract void quebrarBloco(Bloco B);
    
    @Override
    public abstract String toString();
}
