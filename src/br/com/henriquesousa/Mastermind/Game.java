package br.com.henriquesousa.Mastermind;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
	

	static void printIntArray(int[] arr) {
		for(int i = 0; i < 4; i++) {
			System.out.print(arr[i]);;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Mastermind");

		//TODO colocar opção pra aumentar o numero de pegs de 4 pra 5 ou mais
		//TODO colocar opção para escolher a quantidade de cores dos pegs 
		Code code = new Code(4, 10);
		
		int guesses = 100;
		
		Scanner sc = new Scanner(System.in);
		
		int[] keyPegs = new int[4];
		
		//game loop
		for( ; guesses != 0; guesses--) {
			//TODO pegar o guessed code como um numero só de 4 digitos
			int[] guessedCode = new int[4];
			for(int i = 0; i < 4; i++) {
				guessedCode[i] = sc.nextInt();
			}
			System.out.println("Input is: ");
			printIntArray(guessedCode);
			System.out.printf("%n");
			
			//for debug
			//System.out.println("code is:");
			//printIntArray(code.getPegs());
			//System.out.printf("%n");
			
			//test for correct guesses
			//TODO colocar dentro da class Code
			//TODO mostrar os keypegs sem nenhuma ordem, como no jogo SENHA
			for(int i = 0; i < 4; i++) {
				if(guessedCode[i] == code.getPeg(i)) {
					keyPegs[i] = 2;
				} else for(int j = 0; j < 4; j++) {
					if(Arrays.asList(Arrays.stream(code.getPegs()).boxed().toArray(Integer[]::new)
							).contains(Integer.valueOf(guessedCode[i]))) { 
						keyPegs[i] = 1;
					} else {
						keyPegs[i] = 0;
					}
				}
			}
			System.out.println("key pegs:");
			printIntArray(keyPegs);
			System.out.printf("%n");
			
			//verify if the user won the game
			boolean win = true;
			for(int i = 0; i < 4; i++) {
				if(keyPegs[i] != 2) {
					win = false;
					break;
				}
			}
			if(win) {
				System.out.println("You are the winner! The code is:");
				printIntArray(code.getPegs());
				System.out.printf("%n");
				break;
			}
		}
		sc.close();
		
	}
	
}
