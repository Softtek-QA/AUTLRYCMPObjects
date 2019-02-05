package br.lry.components.va.cat010;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomRadioButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTBaseComponent;
import br.lry.components.va.cat003.Item;



public class AUTDesconto extends AUTBaseComponent {

	
	/**
	 * Desconto no pedido
	 * @author Softtek - QA
	 *
	 */

	
	/**
	 * Listagem dos Tipos de Desconto
	 * @author Softtek - QA
	 *
	 */
	public static enum AUT_TIPO_DESCONTO{
		REAIS,
		PORCENTAGEM;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case REAIS: {
				return "REAIS";
			}
			case PORCENTAGEM: {
				return "PORCENTAGEM";
			}
			}
			return super.toString();
		}
	}
	
	
	/**
	 * Listagem dos Tipos de Motivo para desconto de frete
	 * @author Softtek - QA
	 *
	 */
	public static enum AUT_MOTIVO_DESCONTO_FRETE{
		NEGOCIACAO,
		VENDA_ERRADA,
		ATRASO_NA_ENTREGA_DE_PEDIDO,
		AVARIA_NO_PRODUTO,
		PRODUTO_COM_ALTO_VALOR_AGREGADO,
		RUPTURA_DE_PRODUTO;
		
		
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case NEGOCIACAO: {
				return "Negociação";
			}
			case VENDA_ERRADA: {
				return "Venda errada";
			}
			case ATRASO_NA_ENTREGA_DE_PEDIDO: {
				return "Atraso na entrega de pedido";
			}
			case AVARIA_NO_PRODUTO: {
				return "Avaria no produto";
			}
			case PRODUTO_COM_ALTO_VALOR_AGREGADO: {
				return "Produto com alto valor agregado";
			}
			case RUPTURA_DE_PRODUTO: {
				return "Ruptura de produto";
			}
			}
			return super.toString();
		}
	}
	
	public enum AUT_VA_MOTIVO{
		ESPECIAL,
		SALDO,
		ERRO_NO_PRECO,
		SITE;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case ESPECIAL: {
				return "7 - ESPECIAL";
			}
			case SALDO: {
				return "9 - SALDO";
			}
			case ERRO_NO_PRECO: {
				return "8 - ERRO DE PRECO";
			}
			case SITE: {
				return "20 - SITE";
			}
			}
			return super.toString();
		}
	}
	
	
	/**
	 * Desconto sobre o valor da seção 
	 * @param parametros - Desconto 
	 * @return - Verdadeiro para desconto devidamente aplicado 
	 */
	public boolean autDescontoSecao(java.util.HashMap parametros) {			
		try {
			
			AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.ValorSecao").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.ValorSecao").click();
			
			if ( parametros.get("AUT_TIPO_DESCONTO").toString() == AUT_TIPO_DESCONTO.REAIS.toString()) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").setFocus();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
			}

			else if (parametros.get("AUT_TIPO_DESCONTO").toString() == AUT_TIPO_DESCONTO.PORCENTAGEM.toString()) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").setFocus();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
			}
			
			AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_SECAO").setFocus();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_SECAO").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_SECAO").select(parametros.get("AUT_MOTIVO").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Desconto.DescontoPorcentagem_SECAO").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Desconto.DescontoPorcentagem_SECAO").setText(parametros.get("AUT_DESCONTO").toString());

			
			return true;
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	
	}
	
	
	/**
	 * Desconto sobre o valor do Item
	 * @param parametros - Desconto 
	 * @return - Verdadeiro para desconto devidamente aplicado 
	 */
	public boolean autDescontoItem(java.util.HashMap parametros) {			
		try {

			AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.ValorItem").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.ValorItem").click();
			
			if ( parametros.get("AUT_TIPO_DESCONTO").toString() == AUT_TIPO_DESCONTO.REAIS.toString()) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").setFocus();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
			}

			else if (parametros.get("AUT_TIPO_DESCONTO").toString() == AUT_TIPO_DESCONTO.PORCENTAGEM.toString()) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").setFocus();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
			}
						
			AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_ITEM").setFocus();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_ITEM").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_ITEM").select(parametros.get("AUT_MOTIVO").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Desconto.DescontoPorcentagem_ITEM").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Desconto.DescontoPorcentagem_ITEM").typeKeys(parametros.get("AUT_DESCONTO").toString());

			return true;
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	
	}
	
	
	/**
	 * Desconto sobre o valor do Total
	 * @param parametros - Desconto 
	 * @return - Verdadeiro para desconto devidamente aplicado 
	 */
	public boolean autDescontoTotal(java.util.HashMap parametros) {
		try {
			AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.ValorTotal").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.ValorTotal").click();
			
			if ( parametros.get("AUT_TIPO_DESCONTO").toString() == AUT_TIPO_DESCONTO.REAIS.toString()) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").setFocus();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
			}

			else if (parametros.get("AUT_TIPO_DESCONTO").toString() == AUT_TIPO_DESCONTO.PORCENTAGEM.toString()) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").setFocus();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
			}
			
			AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_TOTAL").setFocus();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_TOTAL").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_TOTAL").select(parametros.get("AUT_MOTIVO").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Desconto.DescontoPorcentagem_TOTAL").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Desconto.DescontoPorcentagem_TOTAL").typeKeys(parametros.get("AUT_DESCONTO").toString());

			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}


	}
	

	
	/**
	 * Desconto sobre o valor do Frete
	 * @param parametros - Desconto 
	 * @return - Verdadeiro para desconto devidamente aplicado 
	 */
	public boolean autDescontoFrete(java.util.HashMap parametros) {
		try {
			
			AUT_AGENT_SILK4J.<DomRadioButton>find("VA.FluxoSaida.Entrega").select();
			AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.ListaEndereco").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.PopUpFreteAdicional").click();
			DomListBox listComboEntrega= AUT_AGENT_SILK4J.<DomListBox>find("VA.ConfirmacaoLogin.Turno");
			selectValor(listComboEntrega);
			AUT_AGENT_SILK4J.<DomElement>find("VA.FluxoSaida.Frete").click();
			
			if ( parametros.get("AUT_TIPO_DESCONTO").toString() == AUT_TIPO_DESCONTO.REAIS.toString()) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").setFocus();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
			}

			else if (parametros.get("AUT_TIPO_DESCONTO").toString() == AUT_TIPO_DESCONTO.PORCENTAGEM.toString()) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").setFocus();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
			}
			
	        AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.Motivo_FRETE").select(parametros.get("AUT_MOTIVO").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Desconto.Desconto_FRETE").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Desconto.Desconto_FRETE").typeKeys(parametros.get("AUT_DESCONTO").toString());
			AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.Confirmar").click();


			

			
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}


	}
	
	
	
	public boolean autPopUpConfirmacao() {			
		try {
			AUT_AGENT_SILK4J.<DomListBox>find("VA.Desconto.PopUpSim").click();
		
			return true;
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	
	}
	
	
	
	/**
	 * Desconto sobre o valor dos Itens
	 * @param parametros - Desconto 
	 * @return - Verdadeiro para desconto devidamente aplicado 
	 */
	public boolean autDescontoItens(java.util.HashMap parametros) {			
		try {
			
			HashMap<Integer, ArrayList<Item>> item = Item.carregaItens();

			int quantidadeItens = (int) parametros.get("AUT_QUANTIDADE_ITENS");

			for (Integer kv : item.keySet()) {
				System.out.println("Key: " + kv);

				int contador = 0;

				for (Item material : item.get(kv)) {

					if (contador >= quantidadeItens) {
						break;
					}


			AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.//DIV[@data-entry='"+contador+"']").click();;

			
			if ( material.getTipoDesconto().toString() == AUT_TIPO_DESCONTO.REAIS.toString()) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").setFocus();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
			}

			else if (material.getTipoDesconto().toString() == AUT_TIPO_DESCONTO.PORCENTAGEM.toString()) {
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").setFocus();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
				AUT_AGENT_SILK4J.<DomElement>find("VA.Desconto.EscolherTipoDesconto_ITEM").click();
			}
					
			
			AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.//DIV[@id='item-"+contador+"']//DIV[@id='item-discount']//SELECT[@class='select']").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.//DIV[@id='item-"+contador+"']//DIV[@id='item-discount']//SELECT[@class='select']").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//DIV[@id='item-"+contador+"']//DIV[@id='item-discount']//SELECT[@class='select']").select(material.getMotivoDesconto().toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.//INPUT[@id='value-discount-"+contador+"']").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.//INPUT[@id='value-discount-"+contador+"']").typeKeys(material.getValorDesconto().toString());

			contador++;
			
			}
		}
			return true;
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	
	}
	
	
	/**
	 * Desconto sobre o valor dos Itens
	 * @param parametros - Desconto 
	 * @return - Verdadeiro para desconto devidamente aplicado 
	 */
	public boolean autDescontoSecoes(java.util.HashMap parametros) {			
		try {
					

    		ArrayList<String> teste1 = new ArrayList<String>();
    		int contador = 0;
    		int cont = 0;
			int contadorExpressao = 1;
			
			List<DomElement> txtArticleNovos =  AUT_AGENT_SILK4J.<DomElement>findAll("//BrowserApplication//STRONG[@class='*price-tag-detail']");
			List<DomElement> txtArticle =  AUT_AGENT_SILK4J.<DomElement>findAll("//BrowserApplication//DomElement[@class='price-tag']");
            

            for(DomElement teste: txtArticleNovos) {
            	System.out.print("Descobrindo as listas"+teste.getText());
            	String a = teste.getText().substring(0, 2);
            	System.out.println("Saida da secao"+a);
            	teste1.add(a);
            }
            

            
            for (DomElement title : txtArticle) {
                System.out.print("Lista de rows"+title.getText());
                System.out.println("Tags"+title.getText());
				java.util.regex.Pattern padrao = java.util.regex.Pattern.compile(".*Seção.*");
				java.util.regex.Matcher analise = padrao.matcher(title.getText());
				contador ++;
				
				if(analise.find()) {			
					
		            for (int i=0; i < teste1.size(); i++) {
		            	System.out.println("Saida do numero da seção"+teste1.get(i));
		         
		            
		            

					if (contador ==4) {
						
						cont = 3;
					}
					
					else {
						cont =2;
					}
					
	        		
	        		if ((int) parametros.get("AUT_QUANTIDADE_SECAO") >= contadorExpressao)  {
	    			
	        		title.getText().length();
	        		
	        		if(title.getText().length() ==26) {
			        	String res = title.getText().substring(16, 21);
		        		AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.//DIV[@id='section-"+teste1.get(i)+"']["+cont+"]//DIV[@textContents='Total Seção:']//SPAN[@class='price-currency']").click(); 		    			
		        		AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//DIV[@id='section-"+teste1.get(i)+"']["+cont+"]//SELECT[@class='select']").select(parametros.get("AUT_MOTIVO").toString()); 
		        		AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.//INPUT[@id='value-discount-"+teste1.get(i)+"']").typeKeys(parametros.get("AUT_DESCONTO").toString()); 		        		
		        		contador =0;
		    			System.out.println("Valor do substr"+res);
	        		}
	        		
	        		if(title.getText().length() == 24) {
			        	String res = title.getText().substring(16, 19);
			        	
			        	//BrowserApplication//BrowserWindow//DIV[@id='section-13'][2]//DIV[@textContents='Total Seção:']//SPAN[@class='price-currency']
		        		AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.//DIV[@id='section-"+teste1.get(i)+"']["+cont+"]//DIV[@textContents='Total Seção:']//SPAN[@class='price-currency']").click(); 		    			
		        		AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//DIV[@id='section-"+teste1.get(i)+"']["+cont+"]//SELECT[@class='select']").select(parametros.get("AUT_MOTIVO").toString()); 
		        		AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.//INPUT[@id='value-discount-"+teste1.get(i)+"']").typeKeys(parametros.get("AUT_DESCONTO").toString()); 		        		
		        		contador =0;
		    			System.out.println("Valor do substr"+res);
	        		}
	        		
	        		if(title.getText().length() == 23) {
			        	String res = title.getText().substring(16, 18);
		        		AUT_AGENT_SILK4J.<DomElement>find("VA.AtualizacaoDados.//DIV[@id='section-"+teste1.get(i)+"']["+cont+"]//DIV[@textContents='Total Seção:']//SPAN[@class='price-currency']").click(); 		    			
		        		AUT_AGENT_SILK4J.<DomListBox>find("VA.AtualizacaoDados.//DIV[@id='section-"+teste1.get(i)+"']["+cont+"]//SELECT[@class='select']").select(parametros.get("AUT_MOTIVO").toString()); 
		        		AUT_AGENT_SILK4J.<DomTextField>find("VA.AtualizacaoDados.//INPUT[@id='value-discount-"+teste1.get(i)+"']").typeKeys(parametros.get("AUT_DESCONTO").toString()); 		        		
		        		contador =0;
		    			System.out.println("Valor do substr"+res);
	        		}
	        			

	    			contadorExpressao ++;
					
				}	
		      }
	
			}
            
        }
               		
			return true;
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	
	}	
}