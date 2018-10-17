package br.lry.components.va.cat003;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.DomButton;
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
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaInicialLoja.QuantidadeItem").setText(parametros.get("AUT_QUANTIDADE_ITEM").toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA02.TelaInicialLoja.CodigoItem").setText(parametros.get("AUT_CODIGO_ITEM").toString());
			AUT_AGENT_SILK4J.<DomButton>find("VA02.TelaInicialLoja.PesquisarProduto").click();
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}

}
