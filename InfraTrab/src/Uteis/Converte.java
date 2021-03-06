package Uteis;
import java.util.ArrayList;

public class Converte {

	public static ArrayList<String> listaString = new ArrayList<String>();

	public static String converteString(String mensagem) {
		String Binario="";
		char c[]= mensagem.toCharArray();
		int[] vetorInt = new int[c.length];
		int[]vetorCripto = new int[c.length];
		for (int i = 0; i < c.length; i++) {
			int aux = c[i];
			vetorInt[i]=aux; //Valor ascii
			vetorCripto[i]=Criptografia.criptografa(vetorInt[i]); //Valor acii criptografado
			Binario=Binario+""+Converte.converteIntToStringBinario(vetorCripto[i]);//Passa para bin
		}
		return Binario;
	}

	public static String converteIntToStringBinario(int number) {
		StringBuilder result = new StringBuilder();
		for(int i = 23; i >= 0 ; i--) {
			int mask = 1 << i;
			result.append((number & mask) != 0 ? "1" : "0");
			if (i % 24 == 0)
				result.append(" ");
		}
		result.replace(result.length() - 1, result.length(), "");
		return result.toString();
	}

	public static ArrayList<String> converteStringBinarioToListaBinario(String binario) {
		int index = 0;
		while (index<binario.length()) {
			listaString.add(binario.substring(index, Math.min(index+24,binario.length())));
			index+=24;
		}
		return listaString;
	}

	public static String converteVetorStringToAscii(){	
		String mensagemFinal="";

		int[] map = {1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192,
				16384,32768,65536,131072,//18
				262144,524288,1048576,2097152,4194304,8388608};
		String[] binarioUnidade = new String[map.length];


		for (int i = 0; i < listaString.size(); i++){
			binarioUnidade = listaString.get(i).split("");
			int j =23;
			int valorAsciiCripto =0;
			int valorAscii=0;
			for (int k = 0; k < 23; k++) {
				if(binarioUnidade[j].equals("1"))
				{
					valorAsciiCripto = valorAsciiCripto + map[k];						
				}
				j--;

			}
			valorAscii=Criptografia.desCriptografa(valorAsciiCripto);
			char letra = (char) valorAscii;
			String recebeChar=String.valueOf(letra);
			mensagemFinal=mensagemFinal+recebeChar;

		}
		return mensagemFinal ;
	}

}
