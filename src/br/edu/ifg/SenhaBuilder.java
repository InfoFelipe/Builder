package br.edu.ifg;

import java.util.ArrayList;
import java.util.Random;

import br.edu.ifg.Interfaces.IBuilder;
import br.edu.ifg.adicionais.LerArquivo;

public class SenhaBuilder implements IBuilder {

    private String[] letras;
    private String[] caracteres;
    private ArrayList<ArrayList<String>> caracteresDaSenha = new ArrayList<>();
    private int quantLetras;
    private int quantNumeros;
    private int quantCaracterEspeciais;
    private int quantMaiusculas;

    public void setCaracteres() {
        String pathCaracteres = "C:\\Users\\pedrp\\OneDrive\\Documentos\\GitHub\\Builder\\src\\br\\edu\\ifg\\Arquivos\\CaractersEspeciais.txt";
        String caracteres[] = LerArquivo.quebraArquivo(pathCaracteres); 
        this.caracteres = caracteres;
    }


    public void setLetras() {
        String pathLetras = "C:\\Users\\pedrp\\OneDrive\\Documentos\\GitHub\\Builder\\src\\br\\edu\\ifg\\Arquivos\\Letras.txt";
        String letras[] = LerArquivo.quebraArquivo(pathLetras);

        this.letras = letras;
    }


    @Override
    public ArrayList<Integer> definirQuantCadaCarecter(String tipoSenha, int quantCaracter){
        
        int quantLetras = 0, quantNumeros = 0, quantCaracterEspeciais = 0;
        int quantMaiusculas = 0, quantCaracterRestante;
        ArrayList<Integer> quantidades = new ArrayList<>();
        
        if(tipoSenha.equals("alfanumerica")) {
            quantLetras = this.definirQuantLetras(quantCaracter);
            quantCaracterRestante = (quantCaracter) - quantLetras;
            quantCaracterEspeciais = this.definirQuantCaracteresEsp(quantCaracterRestante);
            quantCaracterRestante -= quantCaracterEspeciais;
            quantNumeros = quantCaracterRestante;
            quantMaiusculas = this.definirQuantLetrasMaiusculas(quantLetras);
            quantLetras -= quantMaiusculas;

        } else if(tipoSenha.equals("letrasnumeros")) {
            quantLetras = this.definirQuantLetras(quantCaracter);
            quantCaracterRestante = (quantCaracter) - quantLetras;
            quantNumeros = quantCaracterRestante;
            quantMaiusculas = this.definirQuantLetrasMaiusculas(quantLetras);
            quantLetras -= quantMaiusculas;

        } else if(tipoSenha.equals("letrascaracteres")) {
            quantLetras = this.definirQuantLetras(quantCaracter);
            quantCaracterRestante = (quantCaracter) - quantLetras;
            quantCaracterEspeciais = quantCaracterRestante;
            quantMaiusculas = this.definirQuantLetrasMaiusculas(quantLetras);
            quantLetras -= quantMaiusculas;

        } else {
            quantCaracterEspeciais = this.definirQuantCaracteresEsp(quantCaracter);
            quantCaracterRestante = (quantCaracter) - quantCaracterEspeciais;
            quantNumeros = quantCaracterRestante;
        }

        this.setQuantLetras(quantLetras);
        this.setQuantMaiusculas(quantMaiusculas);
        this.setQuantNumeros(quantNumeros);
        this.setQuantCaracterEspeciais(quantCaracterEspeciais);
        
        return quantidades;
    }
    
    public int definirQuantLetras(int quantCaracter) {
        int quantLetras;
        Random aleatorio = new Random();

        quantLetras = aleatorio.nextInt(quantCaracter);

        if(quantCaracter/2 == 3) {
            quantLetras = 3;

        } else {
            while (quantLetras > 3 && quantLetras >= (quantCaracter - 1)) {
                quantLetras = aleatorio.nextInt(quantCaracter);
            }
        }

        return quantLetras;
    }

    public int definirQuantCaracteresEsp(int quantCaracter) {
        int quantCaracterEspeciais;
        Random aleatorio = new Random();

        quantCaracterEspeciais = aleatorio.nextInt(quantCaracter);

        while (quantCaracterEspeciais == quantCaracter) {
            quantCaracterEspeciais = aleatorio.nextInt(quantCaracter);
        }

        return quantCaracterEspeciais;
    }

    public int definirQuantLetrasMaiusculas(int quantLetras) {
        int quantMaiusculas;
        Random aleatorio = new Random();

        quantMaiusculas = aleatorio.nextInt(quantLetras);

        return quantMaiusculas;
    }

    @Override
    public void definirLetras() {
        Random aleatorio = new Random();
        ArrayList<String> letras = new ArrayList<>();
        
        for(int i=0; i<this.getQuantLetras();i++){
            int num = aleatorio.nextInt(this.getLetras().length);
            String letra = this.getLetras()[num];
            letras.add(letra);            
        }

        this.caracteresDaSenha.add(letras);
    }

    @Override
    public void definirCaracteresEspeciais() {
        Random aleatorio = new Random();
        ArrayList<String> caracteresEspec = new ArrayList<>();
        
        for(int i=0; i<this.getQuantCaracterEspeciais();i++){
            int num = aleatorio.nextInt(this.getCaractersEspeciais().length);
            String caractere = this.getCaractersEspeciais()[num];
            caracteresEspec.add(caractere);            
        }

        this.caracteresDaSenha.add(caracteresEspec);
    }

    @Override
    public void gerarLetrasMaisculas() {
        Random aleatorio = new Random();
        ArrayList<String> maisculas = new ArrayList<>();
        
        for(int i=0; i<this.getQuantMaiusculas();i++){
            int num = aleatorio.nextInt(this.getLetras().length);
            String letraMaiscula = this.getLetras()[num].toUpperCase();
            maisculas.add(letraMaiscula);            
        }

        this.caracteresDaSenha.add(maisculas);
    }

    @Override
    public void gerarNumeros() {
        Random aleatorio = new Random();
        ArrayList<String> numeros = new ArrayList<>();
        
        for(int i=0; i<this.getQuantNumeros();i++){
            int num = aleatorio.nextInt(10);
            String numero = Integer.toString(num);
            numeros.add(numero);            
        }

        this.caracteresDaSenha.add(numeros);
    }

    @Override
    public String[] getCaractersEspeciais() {
        return this.caracteres;
        
    }

    @Override
    public String[] getLetras() {
        return this.letras;
    }  

    @Override
    public ArrayList<ArrayList<String>> getCaracteresDaSenha() {
        return this.caracteresDaSenha;
    }

    public int getQuantLetras() {
        return quantLetras;
    }


    public void setQuantLetras(int quantLetras) {
        this.quantLetras = quantLetras;
    }


    public int getQuantNumeros() {
        return quantNumeros;
    }


    public void setQuantNumeros(int quantNumeros) {
        this.quantNumeros = quantNumeros;
    }


    public int getQuantCaracterEspeciais() {
        return quantCaracterEspeciais;
    }


    public void setQuantCaracterEspeciais(int quantCaracterEspeciais) {
        this.quantCaracterEspeciais = quantCaracterEspeciais;
    }


    public int getQuantMaiusculas() {
        return quantMaiusculas;
    }


    public void setQuantMaiusculas(int quantMaiusculas) {
        this.quantMaiusculas = quantMaiusculas;
    }
   
    
}
