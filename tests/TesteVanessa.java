package br.lry.components.tests;

public class TesteVanessa {
	
	public static Double FazConta(String valueInput) {
		//Separa inteiro dos centavos
		String[] vlParts = valueInput.trim().split(",");
		
		vlParts[0] = vlParts[0].replace(".", "");
		
		
		Double dbValorInteiro = Double.parseDouble(vlParts[0]);
		Double dbCentavos = Double.parseDouble(vlParts[1]) / 100;
		Double dbDiferenca = 0.00;
		
		//Transforma em numero par para não dar conta fracionada
		if(dbValorInteiro%2 != 0) {
			dbValorInteiro = dbValorInteiro -1;
			dbDiferenca = 1.00;
			
		}
			
		Double Parcela1 = (dbValorInteiro /2) + dbCentavos; 
		
		return Parcela1;
	}

	
	public static String[] FazConta2(String valueInput) {
		
		//Separa inteiro dos centavos
		String[] vlParts = valueInput.trim().split(",");
		
		vlParts[0] = vlParts[0].replace(".", "");
		
		
		Double dbValorInteiro = Double.parseDouble(vlParts[0]);
		Double dbCentavos = Double.parseDouble(vlParts[1]) / 100;
		Double dbDiferenca = 0.00;
		
		//Transforma em numero par para não dar conta fracionada
		if(dbValorInteiro%2 != 0) {
			dbValorInteiro = dbValorInteiro -1;
			dbDiferenca = 1.00;
			
		}
		
		
		Double Parcela1 = (dbValorInteiro /2) + dbCentavos; 
		
		Double Parcela2 = dbValorInteiro + dbCentavos + dbDiferenca ; 
		Parcela2 = Parcela2 - Parcela1;
	
		String result[] =  {Double.toString(Parcela1), Double.toString(Parcela2)};	
		
		return result;
	}
	
	public static void main(String[] args) {
		
		//FazConta("2.651,99");

		String result[] = FazConta2("2.651,99");
		
		System.out.println(result[0]);
		System.out.println(result[1]);
	}

}
