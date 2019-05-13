package br.lry.components.va.cat003;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;

public class AUTItem extends AUTVABaseComponent{
	
	
	/**
	 * Incluir item no carrinho de compras do sistema VA
	 * @param parametros - Quantidade e código do item a ser inserido no carrinho
	 * @return - Verdadeiro para item inserido no carrinho de compra
	 */
	public boolean autVAIncluirItemNoCarrinho(java.util.HashMap<String, Object> parametros) {
		try {
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaInicialLoja.QuantidadeItem").setText(parametros.get("AUT_QUANTIDADE_ITEM").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaInicialLoja.CodigoItem").typeKeys(parametros.get("AUT_CODIGO_ITEM_VA").toString());
			AUT_AGENT_SILK4J.<DomButton>find("VA.TelaInicialLoja.PesquisarProduto").click();
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	public void autBoitataIncluirItemCarrinho(java.util.HashMap<String, Object> parametros) {
		
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").setText(parametros.get("AUT_CODIGO_ITEM").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaPesquisaBoitata.BtAdicionarCarrinho2").click();
	
	}
	
	
	public void autVAIncluirItemEmMassa(java.util.HashMap<String, Object> parametros) {
		
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaInicialLoja.ItemMassa").click();
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaInicialLoja.InserirItensMassa").setText(parametros.get("AUT_CODIGO_ITEM").toString());
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaInicialLoja.InserirItensMassa").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.EnviarMassa").click();
	
	}
	
	
	public void autBoitataPesquisarItem(java.util.HashMap<String, Object> parametros) {
		
		AUT_AGENT_SILK4J.<DomTextField>find("VA.TelaPesquisaBoitata.MaterialPesquisa").typeKeys(parametros.get("AUT_CODIGO_ITEM").toString());
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPesquisaBoitata.BtPesquisaMaterial").mouseMove();
		AUT_AGENT_SILK4J.<DomButton>find("VA.TelaPesquisaBoitata.BtPesquisaMaterial").click();
	}

}
