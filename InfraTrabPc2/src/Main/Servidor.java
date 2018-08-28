package Main;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Dao.DAO;
import Schemas.Arquivo;
import Uteis.Converte;

public class Servidor {
	//PC2
	public static void main(String[] args) throws IOException, InterruptedException {
		Arquivo arquivoler;
		boolean executa = false;
		Date data = new Date();
		ArrayList<Arquivo> ListaArquivos = new ArrayList<Arquivo>();
		String localLeitura[] = {"C:\\Users\\Odecio\\Documents\\Pasta Compartilhada\\numero1Criptografado.txt",
				"C:\\Users\\Odecio\\Documents\\Pasta Compartilhada\\numero2Criptografado.txt",
				"C:\\Users\\Odecio\\Documents\\Pasta Compartilhada\\numeroOPCCriptografado.txt",
				"C:\\Users\\Odecio\\Documents\\Pasta Compartilhada\\Resposta\\Resposta.txt"};

		File file = new File(localLeitura[0]);
		while(executa==false) {
			if(file.exists()){
				file = new File(localLeitura[1]);
				if(file.exists()) {
					file = new File(localLeitura[2]);
					if(file.exists()){
						executa=true;
					}
					else {
						Thread.sleep(1000);
					}

				}
				else {
					Thread.sleep(1000);
				}

			}
			else {
				Thread.sleep(1000);
			}
		}

		if(executa==true) {
			for (int i = 0; i < 3; i++) {
				Converte.converteStringBinarioToListaBinario(DAO.lerArquivo(localLeitura[i]));
				arquivoler = new Arquivo();
				arquivoler.setNumero(Converte.converteVetorStringToAscii());
				ListaArquivos.add(arquivoler);
				Converte.listaString.clear();	
			}
			double n1 = Double.parseDouble( ListaArquivos.get(0).getNumero());
			double n2 = Double.parseDouble( ListaArquivos.get(1).getNumero());
			double resultado=0.0;

			if(ListaArquivos.get(2).getNumero().equalsIgnoreCase("*")) {
				resultado=n1*n2;

			}
			else if(ListaArquivos.get(2).getNumero().equalsIgnoreCase("+")) {
				resultado=n1+n2;
			}
			else if(ListaArquivos.get(2).getNumero().equalsIgnoreCase("-")) {
				resultado=n1-n2;
			}
			else if(ListaArquivos.get(2).getNumero().equalsIgnoreCase("/")) {
				resultado=n1/n2;
			}
			else {
				System.out.println("Operação inválida");
				
			}
			
			
			String resposta = String.valueOf(resultado);
			String log = "Operação realizada:"+String.valueOf(n1)+" "+ListaArquivos.get(2).getNumero()+" "+String.valueOf(n2)+" = "+
			resposta +" Data: "+String.valueOf(data);
			System.out.println(resultado);
			DAO.gravarArquivo(Converte.converteString(log),localLeitura[3]);
			DAO.gravarArquivo(Converte.converteString(resposta),localLeitura[3]);
		}
	}
}