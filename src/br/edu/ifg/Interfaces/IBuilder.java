package br.edu.ifg.Interfaces;

import java.util.ArrayList;

public interface IBuilder {
    public ArrayList<Integer> definirQuantCadaCarecter(String tipoSenha, int quantCaracter);
    public String[] getLetras();
    public String[] getCaractersEspeciais();
    public void gerarNumeros();
    public void gerarLetrasMaisculas();
    public void definirLetras();
    public void definirCaracteresEspeciais();
    public ArrayList<ArrayList<String>> getCaracteresDaSenha();
}
