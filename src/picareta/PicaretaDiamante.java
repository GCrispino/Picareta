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
public class PicaretaDiamante extends Picareta{
    
    public PicaretaDiamante(){
        //através do construtor da superclasse define a durabilidade da picareta de madeira
        super(1563);
    }
    
    //sobrescrita do metodo "quebrarBloco"
    @Override
    public void quebrarBloco(Bloco B){
        if (this.quebrado()){
            System.out.println("A picareta de diamante esta quebrada!");
            return ;
        }
        
        System.out.println("O " + B + " esta sendo quebrado: ");
        try {
            //pausa o programa pelo tempo que a picareta leva para quebrar o bloco dado.
            Thread.sleep((long) (B.getTempo2() * 1000));
        } catch (InterruptedException ex) {
            Logger.getLogger(PicaretaMadeira.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        B.setQuebrado(true);
        System.out.println("Bloco quebrado!");
        
        this.durabilidade -= 1;
        
        if (this.durabilidade == 0)
            this.quebrarPicareta();
    }
    
    
    @Override
    public String toString(){
        String s = "Picareta de diamante";
        
        return s;
    }
}
