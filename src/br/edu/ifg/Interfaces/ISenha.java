package br.edu.ifg.Interfaces;

import java.util.ArrayList;

public interface ISenha {
    public void setSenha(ArrayList<ArrayList<String>> caracteresDaSenha, int quantCaracteres);
    public String[] getSenha();
}
