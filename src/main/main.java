/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;
import Classes_associadas.Personagem;
import Classes_associadas.Bloco;
import java.io.IOException;
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
    //função que verifica se uma string possui dígito
    public static boolean isDigito(String s){
        for (int i = 0;i < s.length();i++)
            if (Character.isDigit(s.charAt(i)))
                return true;
        
        return false;
    }
    //gera um array de blocos aleatoriamente
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
    //varre o array de blocos, eliminando o bloco que tiver sido quebrado por uma picareta
    public static void verificaArrayBlocos(ArrayList <Bloco> array){
        for (int i = 0;i < array.size();i++){
            if (array.get(i).quebrado())
                array.remove(i);
        }
    }
    //imprime o array de blocos
    public static void imprimeArrayBlocos(ArrayList <Bloco> array){
        for (int i = 0;i < array.size();i++)
            System.out.println((i + 1) + ". " + array.get(i) + ".");
    }
    //imprime a mensagem padrão do jogo
    public static void mensagemPadrao(){
        System.out.println("Bem-vindo ao 'jogo' Minecraft -1.0 Beta!");
        System.out.println("Aperte enter para continuar: ");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //primeiro menu
    public static void Menu1(){
        System.out.println("Escolha uma opção: ");
        System.out.println("1. Criar um personagem:");
        System.out.println("2. Sair do programa: ");
    }
    //menu principal do jogo
    public static void MenuPrincipal(){
        System.out.println("Escolha uma opção abaixo:");
        System.out.println("1. Jogar");
        System.out.println("2. Adicionar uma picareta");
        System.out.println("3. Modificar a picareta atual");
        System.out.println("4. Sair do jogo");
    }
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random gerador = new Random();
        Personagem principal = new Personagem();
        ArrayList <Bloco> listabloco = new ArrayList<>();
        int opcao,nbloco;
        
        geraArrayBlocos(listabloco);
        
        mensagemPadrao();
        
        do{
            Menu1();
            opcao = input.nextInt();
        
            switch(opcao){
                case 1:
                    principal = principal.criarPersonagem();
                    break;
                case 2:
                    System.out.println("Programa encerrado!");
                    break;
                default:
                    System.out.println("Opcao invalida!");
                    try {
                        System.in.read();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }while(opcao != 1 && opcao != 2);
        
        if (opcao == 1){
            do{
                MenuPrincipal();
                opcao = input.nextInt();
                
                switch(opcao){
                    case 1:
                        if (principal.getPicaretaAtual() == null){
                            System.out.println("O personagem "+ principal + " não possui nenhuma picareta!");
                            System.out.println("Para jogar é necessário ter pelo menos uma picareta no inventário!");
                            try {
                               System.in.read();
                            } catch (IOException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{
                            verificaArrayBlocos(listabloco);
                            
                            if (listabloco.isEmpty()){
                                System.out.println("Não há nenhum bloco disponível!");
                                try {
                                    System.in.read();
                                } catch (IOException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            else{
                                System.out.println("Escolha um bloco para quebrar: ");
                                imprimeArrayBlocos(listabloco);
                                nbloco = input.nextInt();
                                //quebra o bloco escolhido utilizando a picareta atual do personagem.
                                principal.getPicaretaAtual().quebrarBloco(listabloco.get(nbloco - 1));
                                try {
                                    System.in.read();
                                } catch (IOException ex) {
                                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        break;
                    case 2:
                        principal.adicionarPicareta();
                        break;
                    case 3:
                        principal.modificarPicaretaAtual();
                        break;
                    case 4:
                        System.out.println("Programa encerrado!");
                        break;
                    default:
                        System.out.println("Opcao invalida!");
                        try {
                          System.in.read();
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
            }while(opcao != 4);
        }
        
    }
}
