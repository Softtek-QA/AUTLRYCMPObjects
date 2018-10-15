package br.lry.components.va.cat005;

import com.borland.silktest.jtf.xbrowser.DomButton;
import br.lry.components.AUTVABaseComponent;

public class AUTConversao extends AUTVABaseComponent{

	
	public boolean autVAConvercaoParaPedido() {
		try {
			AUT_AGENT_SILK4J.<DomButton>find("VA02.Pedidos.ConverterPedido").click();	
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
	
}
