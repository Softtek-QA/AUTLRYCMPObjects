package br.lry.components.va.cat003;
import java.util.ArrayList;
import java.util.HashMap;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomTextField;
import br.lry.components.AUTVABaseComponent;


public class AUTInsercaoItens extends AUTVABaseComponent {

	public AUTInsercaoItens() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Incluir itens no carrinho de compras do sistema VA
	 * @param parametros - Quantidade e código do item a ser inserido no carrinho
	 * @return - Verdadeiro para item inserido no carrinho de compra
	 */
	public boolean autVAIncluirItensNoCarrinho(java.util.HashMap<String, Object> parametros) {
		try {
			
			System.out.println("Entrei no método de inclusão de vários itens");
			
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoCarrinho").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.IniciarAtendimento").click();

			
			
			HashMap<Integer, ArrayList<Item>> item = Item.carregaItens();
			
			int quantidadeItens = (int) parametros.get("AUT_QUANTIDADE_ITENS");
			
			for(Integer kv: item.keySet()){
			      System.out.println("Key: "+ kv); 
			      
			      int contador = 0;
			      
			      for(Item material : item.get(kv)) {
			      		
			      	   if (contador>=quantidadeItens) {
			      		 break;
			      	   }

					   System.out.println ("Codigo do Item "+material.getCodItem());  
					   System.out.println ("Quantidade do Item "+material.getQuantidadeItem());  	      		
					   System.out.println ("Fluxo de Saída "+material.getFluxoSaida());
					   AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaInicialLoja.QuantidadeItem").setText(material.getQuantidadeItem().toString());
					   AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaInicialLoja.CodigoItem").setText(material.getCodItem().toString());
					   AUT_AGENT_SILK4J.<DomButton>find("VA.TelaInicialLoja.PesquisarProduto").click();
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
}

