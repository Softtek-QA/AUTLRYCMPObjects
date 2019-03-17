package br.lry.components.tests;

import br.lry.functions.AUTProjectsFunctions;

public class AUTTestFunctionsDevelop {

	public static void main(String[] args) {
		String inscription = AUTProjectsFunctions.autGetIncriptionRS();
		System.out.println(inscription);
		System.out.println(AUTProjectsFunctions.autGetIncriptionPR());
	}
	
	
	public AUTTestFunctionsDevelop() {
		// TODO Auto-generated constructor stub
	}

}
