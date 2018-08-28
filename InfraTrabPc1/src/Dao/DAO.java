package Dao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Schemas.Arquivo;

public  class DAO {
	
	public static Arquivo arquivo;
	
	
	public static Arquivo lerArquivo(String local) throws IOException  {
		{
			arquivo = new Arquivo();
			String mensagem;
			FileReader arq = new FileReader(local);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			mensagem=linha;
			while(linha!=null) {
				linha = lerArq.readLine();
				if(linha!=null) {
					mensagem=mensagem + linha;
				}
			}
			lerArq.close();
			arquivo.setNumero(mensagem);
			return arquivo;
		}
		
	}
	public static String gravarArquivo(String mensagemCriptografada,String local) throws IOException {
		FileWriter arq = new FileWriter(local);
		PrintWriter gravarArq = new PrintWriter(arq);
		gravarArq.print(mensagemCriptografada);
		gravarArq.close();
		return null;
	}

	public static String LerResposta(String local) throws IOException  {
		{
			String mensagem;
			FileReader arq = new FileReader(local);
			BufferedReader lerArq = new BufferedReader(arq);
			String linha = lerArq.readLine();
			mensagem=linha;
			while(linha!=null) {
				linha = lerArq.readLine();
				if(linha!=null) {
					mensagem=mensagem + linha;
				}
			}
			lerArq.close();
			return mensagem;
		}
		
	}
	
}

