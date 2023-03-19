package br.edu.ifg.adicionais;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LerArquivo {
    public static String lerArquivo(String path) {
        
        Path caminho = Paths.get(path);
		try {
            byte[] texto = Files.readAllBytes(caminho);
            String leitor = new String(texto);
            return leitor;
            
		} catch(Exception erro) {
			return erro.getMessage();
		}
    }

    public static String[] quebraArquivo(String path) {
        String arquivo = LerArquivo.lerArquivo(path);

        String letras[] = arquivo.split(",");

        return letras;
    }
}
