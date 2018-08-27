package Uteis;

public class Criptografia {
	
	public static int criptografa(int inteiro) {
		double a = Math.pow(inteiro, 3);
		int result = (int)a;
		return result;
	}
	public static int desCriptografa(int inteiro) {
		double a=inteiro;
		a=Math.cbrt (a);
		int result = (int)a;
		return result;
	}
}
