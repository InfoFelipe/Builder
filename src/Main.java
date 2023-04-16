import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import br.edu.ifg.Director;

public class Main {
    public static void main(String[] args) throws InterruptedException {
       Director director;
       String tipoSenha;
       ArrayList<String> senhaFinal = new ArrayList<>();

       director = new Director();       
       tipoSenha = director.organizarProducao();

       while(tipoSenha.equals("alfanumerica")){

       }

       if(tipoSenha.equals("alfanumerica")){
            senhaFinal = director.getAlfanumerica().getSenha();

        } else if(tipoSenha.equals("letrasnumeros")){
            senhaFinal = director.getLetrasNumeros().getSenha();

        } else if(tipoSenha.equals("letrascaracteres")){
            senhaFinal = director.getLetrasCaracteres().getSenha();

        } else {
            senhaFinal = director.getNumerosCaracteres().getSenha();
        }

        System.out.println("\nSua nova senha e:\n");

        for(String caracter : senhaFinal){
            System.out.print(caracter);
            TimeUnit.SECONDS.sleep(3);
        }
    }
}
