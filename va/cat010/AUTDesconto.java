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
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Desconto.DescontoPorcentagem_SECAO").typeKeys(parametros.get("AUT_DESCONTO").toString());

			
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
	
}