package Main;
import java.io.IOException;
import java.util.Scanner;

import Dao.DAO;
import Schemas.Arquivo;
import Uteis.Converte;

public class PC1 {
	public static void main(String[] args) throws IOException {
		//PC1
		Arquivo arquivo = new Arquivo();
		Scanner tc = new Scanner(System.in);
		String lugarGravar[] =
			{"C:\\Users\\Odecio\\Documents\\Pasta Compartilhada\\numero1Criptografado.txt",
					"C:\\Users\\Odecio\\Documents\\Pasta Compartilhada\\numero2Criptografado.txt",
			"C:\\Users\\Odecio\\Documents\\Pasta Compartilhada\\numeroOPCCriptografado.txt"};
		String localResposta="C:\\Users\\Odecio\\Documents\\Pasta Compartilhada\\Resposta\\Resposta.txt";
		
		for (int i = 0; i < 3; i++) {
			arquivo=new Arquivo();
			if(i<=1) {
				System.out.println(i+1+"º Numero: ");}
			else {
				System.out.println("Digite a Op");
			}
			arquivo.setNumero(tc.nextLine());
			DAO.gravarArquivo(Converte.converteString(arquivo.getNumero()),lugarGravar[i]);
		}
		System.out.println("Arquivos enviados");

		tc.close();
		System.out.println(Converte.leResultado(localResposta));
		

	}
}
