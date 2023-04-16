package br.edu.ifg;

import java.util.Scanner;

public class Client {
    String tipoSenha;
    int quantCaracter;

    Scanner reader = new Scanner(System.in);

    public void definirTipoSenha(){

        System.out.println("\nDigite o número da senha que deseja gerar: ");
        tipoSenha = reader.nextLine();

    }

    public void definirQuantCaracter(){

        System.out.println("\nQuantidade de caracter da senha: 6, 8, 16");
        quantCaracter = reader.nextInt();

    }

    public String getTipoSenha() {
        return tipoSenha;
    }

    public void setTipoSenha(String tipoSenha) {
        this.tipoSenha = tipoSenha;
    }

    public int getQuantCaracter() {
        return quantCaracter;
    }

    public void setQuantCaracter(int quantCaracter) {
        this.quantCaracter = quantCaracter;
    }

    

    

}
