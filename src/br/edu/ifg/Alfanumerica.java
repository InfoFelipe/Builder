package br.edu.ifg;


import java.util.ArrayList;
import java.util.Random;

import br.edu.ifg.Interfaces.ISenha;

public class Alfanumerica implements ISenha{

    private String[] senhaFinal;

    @Override
    public String[] getSenha() {
        return this.senhaFinal;
        
    }

    @Override
    public void setSenha(ArrayList<ArrayList<String>> caracteresDaSenha, int quantCaracteres) {
        Random aleatorio = new Random();
        ArrayList<String> caracteres = new ArrayList<String>();
        ArrayList<String> senhaFinal = new ArrayList<String>();
        ArrayList<Integer> numerosSelecionado = new ArrayList<Integer>();
        int num;

        
        for(int i = 0; i<caracteresDaSenha.size(); i++){
            caracteres.addAll(caracteresDaSenha.get(i));
        }

        for(int i=0;i< caracteres.size(); i++){
            num = aleatorio.nextInt(caracteres.size());

            while (numerosSelecionado.contains(num)) {
                num = aleatorio.nextInt(caracteres.size());
                
            }
            numerosSelecionado.add(num);
            senhaFinal.add(caracteres.get(num));
        }
        
    }
    
}
