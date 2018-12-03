package br.lry.components.va.cat010;

import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTBaseComponent;

public class AUTDesconto extends AUTBaseComponent {

	
	/**
	 * Desconto no pedido
	 * @author Softtek - QA
	 *
	 */

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
	 * Desconto sobre o valor do pedido Porcentagem
	 * @param parametros - Desconto 
	 * @return - Verdadeiro para desconto devidamente aplicado 
	 */
	public boolean autDesconto(java.util.HashMap parametros) {			
		try {
			AUT_AGENT_SILK4J.<DomElement>find("VA02.Desconto.Valor").setFocus();
			AUT_AGENT_SILK4J.<DomElement>find("VA02.Desconto.Valor").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA02.Desconto.Motivo").setFocus();
			AUT_AGENT_SILK4J.<DomListBox>find("VA02.Desconto.Motivo").click();
			AUT_AGENT_SILK4J.<DomListBox>find("VA02.Desconto.Motivo").select(parametros.get("AUT_MOTIVO").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.Desconto.Porcentagem").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.Desconto.Porcentagem").setText(parametros.get("AUT_DESCONTO").toString());
		
			
			
			
			return true;
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	
	}
	
	
	public boolean autPopUpConfirmacao() {			
		try {
			AUT_AGENT_SILK4J.<DomListBox>find("VA02.Desconto.PopUpSim").click();
		
			return true;
	}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	
	}
	
	
}