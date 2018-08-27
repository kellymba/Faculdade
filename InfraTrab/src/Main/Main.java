package Main;
import java.io.IOException;

import Dao.DAO;
import Uteis.Converte;

public class Main {
	public static void main(String[] args) throws IOException {		
		String localLer = "C:\\Users\\odecioc\\Documents\\teste.txt";
		String localResultado ="C:\\Users\\odecioc\\Documents\\Mensagem.txt";
		String localGravarResultado ="C:\\Users\\odecioc\\Documents\\resultadoFinal.txt";
		
		// Leu, criptografou e gravou criptografado
		DAO.gravarArquivo(Converte.converteString(DAO.lerArquivo(localLer)), localResultado);
		//Ler a resposta e grava
		Converte.converteStringBinarioToListaBinario(DAO.lerArquivo(localResultado));
		DAO.gravarArquivo(Converte.converteVetorStringToAscii(), localGravarResultado);

		Converte.listaString.clear();
	}



}
