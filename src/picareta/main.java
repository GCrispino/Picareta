/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package picareta;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * @author Crispino
 */
public class Main {
    public static boolean isDigito(String s){
        for (int i = 0;i < s.length();i++)
            if (Character.isDigit(s.charAt(i)))
                return true;
        
        return false;
    }
    public static void geraArrayBlocos(ArrayList <Bloco> array){
        Random gerador = new Random();
        int rand;
        
        //através de números aleatórios, adiciona automaticamente 20 elementos ao array 
        //de blocos
        for (int i = 0;i < 15;i++){
            rand = gerador.nextInt(5);
            
            Bloco B = null;
            switch (rand){
                case 0:
                    B = new Bloco(Bloco.Tipo.PEDRA);
                    break;
                case 1:
                    B = new Bloco(Bloco.Tipo.PEDREGULHO);
                    break;
                case 2:
                    B = new Bloco(Bloco.Tipo.TIJOLO);
                    break;
                case 3:
                    B = new Bloco(Bloco.Tipo.OURO);
                    break;
                case 4:
                    B = new Bloco(Bloco.Tipo.GELO);
                    break;
            }
            array.add(B);
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random gerador = new Random();
        
        Personagem principal = new Personagem();
        ArrayList <Bloco> listabloco = new ArrayList<>();
        
        geraArrayBlocos(listabloco);
        
//        principal.adicionarPicareta();
//        principal.getPicaretaAtual().quebrarBloco(listabloco.get(listabloco.size() - 1));
    }
}
