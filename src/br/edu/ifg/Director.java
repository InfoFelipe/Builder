package br.edu.ifg;


public class Director {
    
    private Alfanumerica alfanumerica = new Alfanumerica();
    private LetrasCaracteres letrasCaracteres = new LetrasCaracteres();
    private LetrasNumeros letrasNumeros = new LetrasNumeros();
    private NumerosCaracteres numerosCaracteres = new NumerosCaracteres();

    public String organizarProducao() {
        Client cliente;
        SenhaBuilder senhaBuilder = new SenhaBuilder();
        int quantCaracteres;

        cliente = new Client();
        cliente.definirTipoSenha();
        cliente.definirQuantCaracter();
        quantCaracteres = (int) cliente.getQuantCaracter();

        if(cliente.getTipoSenha().equals("alfanumerica")){
            senhaBuilder.setCaracteres();
            senhaBuilder.setLetras();
            senhaBuilder.definirQuantCadaCarecter(cliente.getTipoSenha(), quantCaracteres);
            senhaBuilder.definirLetras();
            senhaBuilder.definirCaracteresEspeciais();
            senhaBuilder.gerarNumeros();
            senhaBuilder.gerarLetrasMaisculas();
            this.alfanumerica.setSenha(senhaBuilder.getCaracteresDaSenha(), quantCaracteres);
            return cliente.getTipoSenha();

        } else if(cliente.getTipoSenha().equals("letrasnumeros")){
            senhaBuilder.setLetras();
            senhaBuilder.definirQuantCadaCarecter(cliente.getTipoSenha(), quantCaracteres);
            senhaBuilder.definirLetras();
            senhaBuilder.gerarNumeros();
            senhaBuilder.gerarLetrasMaisculas();
            this.letrasNumeros.setSenha(senhaBuilder.getCaracteresDaSenha(), quantCaracteres);
            return cliente.getTipoSenha();

        } else if(cliente.getTipoSenha().equals("letrascaracteres")){
            senhaBuilder.setLetras();
            senhaBuilder.setCaracteres();
            senhaBuilder.definirQuantCadaCarecter(cliente.getTipoSenha(), quantCaracteres);
            senhaBuilder.definirLetras();
            senhaBuilder.definirCaracteresEspeciais();
            senhaBuilder.gerarLetrasMaisculas();
            this.letrasCaracteres.setSenha(senhaBuilder.getCaracteresDaSenha(), quantCaracteres);
            return cliente.getTipoSenha();

        } else {
            senhaBuilder.setCaracteres();
            senhaBuilder.definirQuantCadaCarecter(cliente.getTipoSenha(), quantCaracteres);
            senhaBuilder.definirCaracteresEspeciais();
            senhaBuilder.gerarNumeros();
            this.numerosCaracteres.setSenha(senhaBuilder.getCaracteresDaSenha(), quantCaracteres);
            return cliente.getTipoSenha();
        }

    }

    public void reset(){
        this.setAlfanumerica(null);
        this.setLetrasCaracteres(null);
        this.setLetrasNumeros(null);
        this.setNumerosCaracteres(null);
    }

    public Alfanumerica getAlfanumerica() {
        return alfanumerica;
    }

    public void setAlfanumerica(Alfanumerica alfanumerica) {
        this.alfanumerica = alfanumerica;
    }

    public LetrasCaracteres getLetrasCaracteres() {
        return letrasCaracteres;
    }

    public void setLetrasCaracteres(LetrasCaracteres letrasCaracteres) {
        this.letrasCaracteres = letrasCaracteres;
    }

    public LetrasNumeros getLetrasNumeros() {
        return letrasNumeros;
    }

    public void setLetrasNumeros(LetrasNumeros letrasNumeros) {
        this.letrasNumeros = letrasNumeros;
    }

    public NumerosCaracteres getNumerosCaracteres() {
        return numerosCaracteres;
    }

    public void setNumerosCaracteres(NumerosCaracteres numerosCaracteres) {
        this.numerosCaracteres = numerosCaracteres;
    }
    
    
    
}
