package br.lry.components.va.cat003;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;

public class AUTItem extends AUTVABaseComponent{
	
	/**
	 * Inclui item no carrinho de compras do sistema VA
	 * @param quantidadeItem - Quantidade do item que será incluso
	 * @param codigoItem - Código do item a ser incluído
	 * @return - Verdadeiro caso consiga incluir o item no carrinho de compras
	 */
	
	@Test
	public void autStartTest() {
		java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
		parametros.put("AUT_QUANTIDADE_ITEM", autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_GERACAO_PEDIDOS, "AUT_QUANTIDADE_ITEM")).toString();
		parametros.put("AUT_CODIGO_ITEM", autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_VA_GERACAO_PEDIDOS, "AUT_CODIGO_ITEM")).toString();
		
	}
	
	
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
