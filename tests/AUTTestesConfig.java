package br.lry.components.tests;

public class AUTTestesConfig {

	public AUTTestesConfig() {
		// TODO Auto-generated constructor stub
	}

	public static void testesPrint(String conteudo) {
		conteudo = "abdfdfdfsdfdfs";
		System.out.println(conteudo);
	}
	
	public static void testesPrintItem(Object[] conteudo) {
		//conteudo[0] = "abdfdfdfsdfdfs";
		System.out.println(conteudo[0]);
	}
	public static void main(String[] args) {
		java.util.HashMap<String, Integer> parametros = new java.util.HashMap<String,Integer>();
		java.util.HashMap<Integer,java.util.HashMap<String,Object>> tabela = new java.util.HashMap<Integer,java.util.HashMap<String,Object>>();
		String valor = "12333444444444333333333";
		Object[] valor1 = new Object[2];
		valor1[0] = "conteudo array testes guilherme";
		System.out.println(valor1[0]);
		System.out.println(valor);
		valor = "222222222";
		System.out.println(valor);
		testesPrint(valor);
		testesPrintItem(valor1);
		System.out.println(valor);
		System.out.println(valor1[0]);
		parametros.put("valor1", 30);
		parametros.put("valor6", 60);
		parametros.put("valor4", 90);
		parametros.put("valor3", 45);
		System.out.println(parametros);
		System.out.println(parametros.get("valor3"));
		
		tabela.put(1, new java.util.HashMap<String,Object>());
		tabela.put(2, new java.util.HashMap<String,Object>());

		tabela.get(1).put("coluna1", "valor 1");
		tabela.get(1).put("coluna2", "valor 2");
		tabela.get(1).put("coluna3", "valor 3");
		tabela.get(1).put("coluna4", "valor 4");

		tabela.get(2).put("coluna1", "valor 1");
		tabela.get(2).put("coluna2", "valor 2");
		tabela.get(2).put("coluna3", "valor 3");
		tabela.get(2).put("coluna4", "valor 4");
		tabela.get(2).put("coluna5", "valor 1");
		tabela.get(2).put("coluna6", "valor 2");
		tabela.get(2).put("coluna8", "valor 3");
		tabela.get(2).put("coluna9", "valor 4");

		System.out.println(tabela);
	}
}
