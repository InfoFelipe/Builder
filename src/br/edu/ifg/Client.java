package br.edu.ifg;

import java.util.Scanner;

public class Client {
    String tipoSenha;
    Number quantCaracter;

    Scanner reader = new Scanner(System.in);

    public void definirTipoSenha(){

        System.out.println("Digite o tipo de senha que deseja gerar: ");
        tipoSenha = reader.nextLine();

    }

    public void definirQuantCaracter(){

        System.out.println("Quantidade de caracter da senha: 6, 8, 16");
        quantCaracter = reader.nextInt();

    }

    

}
