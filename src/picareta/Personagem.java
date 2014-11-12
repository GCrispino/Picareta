/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package picareta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Crispino
 */
public class Personagem {
    private String nome; //nome do personagem
    private ArrayList <Picareta> picaretas; //array de picaretas que o personagem guarda;
    private int picaretaatual; //picareta que o personagem está usando no momento.
    private final int QTDMAXITENS = 5; //quantidade máxima de itens que o personagem pode guardar
    
    public Personagem(String nome){
        if (Main.isDigito(nome))
            this.nome = "Padrao";
        else
            this.nome = nome;
        this.picaretas = new ArrayList<>();
        picaretaatual = -1;
    }
    //construtor vazio
    public Personagem(){
        this.nome = "Padrao";
        this.picaretas = new ArrayList<>();
        picaretaatual = -1;
    }
    
    String getNome(){
        return this.nome;
    }
    
    public Personagem criarPersonagem(){
        String nome;
        Scanner input = new Scanner(System.in);
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Digite o nome do personagem: ");
        nome = input.nextLine();
        
        Personagem P = new Personagem(nome);
        
        System.out.println("Personagem criado com sucesso!");
        try {
            System.in.read();
        } catch (IOException ex) {
            Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return P;
    }
    
    public void adicionarPicareta(){
        Scanner input = new Scanner(System.in);
        int r;
        
        do{
            System.out.println("Escolha um tipo de picareta para adicionar ao inventario do seu personagem:");
            System.out.println("1. Madeira");
            System.out.println("2. Diamante");
        
            r = input.nextInt();
            
            if(r != 1 && r != 2){
                System.out.println("Opção inválida!");
                try {
                    System.in.read();
                } catch (IOException ex) {
                    Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }while(r != 1 && r != 2);
        
        
        Picareta P;
        switch(r){
            case 1:
                P = new PicaretaMadeira();
                this.picaretas.add(P);
                System.out.println("Picareta de madeira adicionada!");
                break;
            case 2:
                P = new PicaretaDiamante();
                this.picaretas.add(P);
                System.out.println("Picareta de diamante adicionada!");
                break;
        }
        //se o personagem não possuir picareta alguma, a primeira que for registrada vai ser usada.
        if (this.picaretaatual == -1)
            this.picaretaatual = 0;
    }

    public void modificarPicaretaAtual(){
        Scanner input = new Scanner(System.in);
        char r;
        int i = 0,j = i + 1,opcao;
        
        if (this.picaretaatual == -1){
            System.out.println("O personagem não está utilizando nenhuma picareta!");
            try {
                System.in.read();
            } catch (IOException ex) {
                Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Deseja criar nova picareta para que o personagem possa utilizá-la(S / N)?");
            r = input.next().charAt(0);
            System.out.println("r");
        }
        
        System.out.println("Picareta atual: ");
        System.out.println(this.picaretas.get(picaretaatual));
        
        if (this.picaretas.isEmpty()){
            System.out.println("O personagem não possui nenhuma picareta!");
            try {
                System.in.read();
            } catch (IOException ex) {
                Logger.getLogger(Personagem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if (this.picaretas.size() == 1)
            System.out.println("Só existe a picareta atual no inventário!");
        else{
            System.out.println("Lista de picaretas:");
            while (i < this.picaretas.size()){
                if (i != this.picaretaatual){
                    System.out.println(j + ". " + this.picaretas.get(i));
                    j++;
                }
                i++;
            }
            System.out.println("Digite o número correspondente à picareta que você deseja utilizar:");
            opcao = input.nextInt();
            if (opcao < this.picaretaatual)
                this.picaretaatual = opcao - 1;
            else
                this.picaretaatual = opcao;
            
            System.out.println(this.picaretas.get(this.picaretaatual) + " selecionada!");
        }
    }

    public Picareta getPicaretaAtual(){
        return this.picaretas.get(this.picaretaatual);
    }
}
