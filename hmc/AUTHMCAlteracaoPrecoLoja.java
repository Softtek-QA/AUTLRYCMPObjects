package br.lry.components.hmc;

import org.junit.Test;

import com.borland.silktest.jtf.win32.AccessibleControl;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTableRow;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTHMCAlteracaoPrecoLoja extends AUTHMCLogin{

	String usuario = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN, "AUT_USER").toString();
	String senha = autGetCurrentParameter("AUT_PASSWORD").toString();
	
	
	public enum AUT_HMC_FILTRO_PESQUISA_ITEM{
		CONTEM,
		E_IGUAL,
		E_COMO,
		COMECA_COM,
		TERMINA_COM,
		ESTA_VAZIO,
		NAO_ESTA_VAZIO;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case CONTEM: {
				return "contém";
			}
			case E_IGUAL: {
				return "é igual";
			}
			case E_COMO: {
				return "é como";
			}
			case COMECA_COM: {
				return "começa com";
			}
			case TERMINA_COM: {
				return "termina com";
			}
			case ESTA_VAZIO: {
				return "está vazio";
			}
			case NAO_ESTA_VAZIO: {
				return "não está vazio";
			}
			}
			return super.toString();
		}
	}
	
	
	
	public enum AUT_HMC_LOJAS{
		LM_0001,
		LM_0002,
		LM_0003,
		LM_0005,
		LM_0007,
		LM_0009,
		LM_0010,
		LM_0011,
		LM_0012,
		LM_0013,
		LM_0015,
		LM_0017,
		LM_0018,
		LM_0019,
		LM_0021,
		LM_0022,
		LM_0023,
		LM_0024,
		LM_0026,
		LM_0028,
		LM_0029,
		LM_0032,
		LM_0033,
		LM_0034,
		LM_0035,
		LM_0036,
		LM_0038,
		LM_0039,
		LM_0041,
		LM_0042,
		LM_0043,
		LM_0044,
		LM_0045,
		LM_0046,
		LM_0055,
		LM_0058;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case LM_0001: {
				return "HMC.TelaPrecos.Lojas.LM0001";
			}
			case LM_0002: {
				return "HMC.TelaPrecos.Lojas.LM0002";
			}
			case LM_0003: {
				return "HMC.TelaPrecos.Lojas.LM0003";
			}
			case LM_0005: {
				return "HMC.TelaPrecos.Lojas.LM0005";
			}
			case LM_0007: {
				return "HMC.TelaPrecos.Lojas.LM0006";
			}
			case LM_0009: {
				return "HMC.TelaPrecos.Lojas.LM0009";
			}
			case LM_0010: {
				return "HMC.TelaPrecos.Lojas.LM0010";
			}
			case LM_0011: {
				return "HMC.TelaPrecos.Lojas.LM0011";
			}
			case LM_0012: {
				return "HMC.TelaPrecos.Lojas.LM0012";
			}
			case LM_0013: {
				return "HMC.TelaPrecos.Lojas.LM0013";
			}
			case LM_0015: {
				return "HMC.TelaPrecos.Lojas.LM0015";
			}
			case LM_0017: {
				return "HMC.TelaPrecos.Lojas.LM0017";
			}
			case LM_0018: {
				return "HMC.TelaPrecos.Lojas.LM0018";
			}
			case LM_0019: {
				return "HMC.TelaPrecos.Lojas.LM0019";
			}
			case LM_0021: {
				return "HMC.TelaPrecos.Lojas.LM0021";
			}
			case LM_0022: {
				return "HMC.TelaPrecos.Lojas.LM0022";
			}
			case LM_0023: {
				return "HMC.TelaPrecos.Lojas.LM0023";
			}
			case LM_0024: {
				return "HMC.TelaPrecos.Lojas.LM0024";
			}
			case LM_0026: {
				return "HMC.TelaPrecos.Lojas.LM0026";
			}
			case LM_0028: {
				return "HMC.TelaPrecos.Lojas.LM0028";
			}
			case LM_0029: {
				return "HMC.TelaPrecos.Lojas.LM0029";
			}
			case LM_0032: {
				return "HMC.TelaPrecos.Lojas.LM0032";
			}
			case LM_0033: {
				return "HMC.TelaPrecos.Lojas.LM0033";
			}
			case LM_0034: {
				return "HMC.TelaPrecos.Lojas.LM0034";
			}
			case LM_0035: {
				return "HMC.TelaPrecos.Lojas.LM0035";
			}
			case LM_0036: {
				return "HMC.TelaPrecos.Lojas.LM0036";
			}
			case LM_0038: {
				return "HMC.TelaPrecos.Lojas.LM0038";
			}
			case LM_0039: {
				return "HMC.TelaPrecos.Lojas.LM0039";
			}
			case LM_0041: {
				return "HMC.TelaPrecos.Lojas.LM0041";
			}
			case LM_0042: {
				return "HMC.TelaPrecos.Lojas.LM0042";
			}
			case LM_0043: {
				return "HMC.TelaPrecos.Lojas.LM0043";
			}
			case LM_0044: {
				return "HMC.TelaPrecos.Lojas.LM0044";
			}
			case LM_0045: {
				return "HMC.TelaPrecos.Lojas.LM0045";
			}
			case LM_0046: {
				return "HMC.TelaPrecos.Lojas.LM0046";
			}
			case LM_0055: {
				return "HMC.TelaPrecos.Lojas.LM0055";
			}
			case LM_0058: {
				return "HMC.TelaPrecos.Lojas.LM0058";
			}
			}
			return super.toString();
		}
	}
	
	
	
	public enum AUT_PRECOS_LOJAS{
		LM_0001,
		LM_0002,
		LM_0003,
		LM_0005,
		LM_0007,
		LM_0009,
		LM_0010,
		LM_0011,
		LM_0012,
		LM_0013,
		LM_0015,
		LM_0017,
		LM_0018,
		LM_0019,
		LM_0021,
		LM_0022,
		LM_0023,
		LM_0024,
		LM_0026,
		LM_0028,
		LM_0029,
		LM_0032,
		LM_0033,
		LM_0034,
		LM_0035,
		LM_0036,
		LM_0038,
		LM_0039,
		LM_0041,
		LM_0042,
		LM_0043,
		LM_0044,
		LM_0045,
		LM_0046,
		LM_0055,
		LM_0058;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case LM_0001: {
				return "HMC.TelaPrecos.Precos.LM0001";
			}
			case LM_0002: {
				return "HMC.TelaPrecos.Precos.LM0002";
			}
			case LM_0003: {
				return "HMC.TelaPrecos.Precos.LM0003";
			}
			case LM_0005: {
				return "HMC.TelaPrecos.Precos.LM0005";
			}
			case LM_0007: {
				return "HMC.TelaPrecos.Precos.LM0006";
			}
			case LM_0009: {
				return "HMC.TelaPrecos.Precos.LM0009";
			}
			case LM_0010: {
				return "HMC.TelaPrecos.Precos.LM0010";
			}
			case LM_0011: {
				return "HMC.TelaPrecos.Precos.LM0011";
			}
			case LM_0012: {
				return "HMC.TelaPrecos.Precos.LM0012";
			}
			case LM_0013: {
				return "HMC.TelaPrecos.Precos.LM0013";
			}
			case LM_0015: {
				return "HMC.TelaPrecos.Precos.LM0015";
			}
			case LM_0017: {
				return "HMC.TelaPrecos.Precos.LM0017";
			}
			case LM_0018: {
				return "HMC.TelaPrecos.Precos.LM0018";
			}
			case LM_0019: {
				return "HMC.TelaPrecos.Precos.LM0019";
			}
			case LM_0021: {
				return "HMC.TelaPrecos.Precos.LM0021";
			}
			case LM_0022: {
				return "HMC.TelaPrecos.Precos.LM0022";
			}
			case LM_0023: {
				return "HMC.TelaPrecos.Precos.LM0023";
			}
			case LM_0024: {
				return "HMC.TelaPrecos.Precos.LM0024";
			}
			case LM_0026: {
				return "HMC.TelaPrecos.Precos.LM0026";
			}
			case LM_0028: {
				return "HMC.TelaPrecos.Precos.LM0028";
			}
			case LM_0029: {
				return "HMC.TelaPrecos.Precos.LM0029";
			}
			case LM_0032: {
				return "HMC.TelaPrecos.Precos.LM0032";
			}
			case LM_0033: {
				return "HMC.TelaPrecos.Precos.LM0033";
			}
			case LM_0034: {
				return "HMC.TelaPrecos.Precos.LM0034";
			}
			case LM_0035: {
				return "HMC.TelaPrecos.Precos.LM0035";
			}
			case LM_0036: {
				return "HMC.TelaPrecos.Precos.LM0036";
			}
			case LM_0038: {
				return "HMC.TelaPrecos.Precos.LM0038";
			}
			case LM_0039: {
				return "HMC.TelaPrecos.Precos.LM0039";
			}
			case LM_0041: {
				return "HMC.TelaPrecos.Precos.LM0041";
			}
			case LM_0042: {
				return "HMC.TelaPrecos.Precos.LM0042";
			}
			case LM_0043: {
				return "HMC.TelaPrecos.Precos.LM0043";
			}
			case LM_0044: {
				return "HMC.TelaPrecos.Precos.LM0044";
			}
			case LM_0045: {
				return "HMC.TelaPrecos.Precos.LM0045";
			}
			case LM_0046: {
				return "HMC.TelaPrecos.Precos.LM0046";
			}
			case LM_0055: {
				return "HMC.TelaPrecos.Precos.LM0055";
			}
			case LM_0058: {
				return "HMC.TelaPrecos.Precos.LM0058";
			}
			}
			return super.toString();
		}
	}
	
	
	
	@Test
	public void autHMCAlteracaoPreco(String codigoItem, String precoItem, AUT_PRECOS_LOJAS loja) {
		
		autStartLoginDefault(usuario, senha);
		
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaInicial.ListaIdiomas").click();
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaInicial.ListaIdiomas").select("Português do Brasil");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.Catalogo").click();
		AUT_AGENT_SILK4J.<DomLink>find("HMC.TelaInicial.Produtos").click();
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.Produto.FiltroPesquisa").select(AUT_HMC_FILTRO_PESQUISA_ITEM.E_IGUAL.toString());
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.Produto.NumeroItemPesquisado").setText(codigoItem);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.Produto.Pesquisar").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.Produto.ItemPesquisado").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.Produto.AbaPreco").click();
		AUT_AGENT_SILK4J.<DomElement>find(loja.toString()).setFocus();
		AUT_AGENT_SILK4J.<DomTextField>find(loja.toString()).clearText();
		AUT_AGENT_SILK4J.<DomTextField>find(loja.toString()).setText(precoItem);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.Produto.Salvar").click();
		
		AUT_AGENT_SILK4J.<AccessibleControl>find("HMC.Fechar").click();	
	}
}
