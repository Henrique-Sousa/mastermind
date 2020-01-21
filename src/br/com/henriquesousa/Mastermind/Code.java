package br.com.henriquesousa.Mastermind;

public class Code {
	private int[] codePegs = new int[4]; 
	
	//TODO colocar opcao para nao repetir nenhum peg
	public Code() {
		for(int i = 0; i < 4; i++) {
			codePegs[i] = (int)(10*Math.random());
		}		
	}
	public Code(int n, int m) {
		for(int i = 0; i < n; i++) {
			codePegs[i] = (int)(m*Math.random());
		}		
	}
	
	public int getPeg(int i) {
		return codePegs[i];
	}
	
	public int[] getPegs() {
		return codePegs;
	}
	
	//TODO criar funcao toString (retorna os 4 numeros como uma string)
	
	public void printCode() {
		for(int i = 0; i < 4; i++) {
			System.out.print(codePegs[i]);
		}
	}
}
