package br.lry.components.va.cat005;

import com.borland.silktest.jtf.xbrowser.DomButton;
import br.lry.components.AUTVABaseComponent;

public class AUTConversao extends AUTVABaseComponent{

	
	/**
	 * Realizar conversão de carrinho para pedido
	 * @return - Verdadeiro para o carrinho convertido em pedido
	 */
	public boolean autVAConvercaoParaPedido() {
		try {
			AUT_AGENT_SILK4J.<DomButton>find("VA.Pedidos.ConverterPedido").click();	
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean autVAConvercaoParaOrcamento() {
		try {
			AUT_AGENT_SILK4J.<DomButton>find("VA.Pedidos.ConverterOrcamento").click();	
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
}
