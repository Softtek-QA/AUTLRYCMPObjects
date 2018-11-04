package br.lry.components.safe;

import org.junit.Test;

import com.borland.silktest.jtf.xbrowser.BrowserApplication;
import com.borland.silktest.jtf.xbrowser.BrowserWindow;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.sap.AUTSAPBaseComponent;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;


/**
 * 
 * Realiza procedimentos de consulta de vale troca
 * 
 * 
 * @author Softtek-QA
 *
 */
public class AUTSafeConsultaValeTroca extends AUTSafeBaseComponent {

	public String AUT_VALE_TROCA_OUTPUT = null; //Vale troca
	
	/**
	 * 
	 * Consulta numeros de vale troca gerados para cliente
	 * 
	 * @param parametrosConfig - Parametros de configuração
	 * 
	 * 
	 */
	public void autIniConsultaValeTrocaParaCliente(java.util.HashMap<String,Object> parametrosConfig) {
	
		autLogin(parametrosConfig.get("AUT_USER").toString(), parametrosConfig.get("AUT_PWD").toString());
		
	}
	
	@Test
	public void autIniConsultaValeTrocaParaCliente() {
		autLogin(autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_SAFE_VALE_TROCA_LINX, "AUT_USER").toString(),autGetCurrentParameter("AUT_PWD").toString());
		AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.TelaInicial").exists("001MenuValeTroca", 30000);
		
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.001MenuValeTroca").click();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.000MenuManutencao").click();
		AUT_AGENT_SILK4J.<DomElement>find("SAFE.TelaInicial.001SubMenu000ValeTroca").click();
		
		AUT_SAFE_TYPE_PERSONS typePerson = (AUT_SAFE_TYPE_PERSONS)autGetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME, "AUT_TYPE_PERSON");
		String numeroDocumento = autGetCurrentParameter("AUT_DOCUMENT").toString();
		String tipoDocEstrangeiro = autGetCurrentParameter("AUT_TYPE_DOC_FOREIGN").toString();
		switch(typePerson) {
		case ESTRANGEIRO:{	
			AUT_AGENT_SILK4J.<DomListBox>find("SAFE.000TelaValeTroca.ListaTiposPessoa").select(typePerson.toString());
			AUT_AGENT_SILK4J.<DomListBox>find("SAFE.000TelaValeTroca.ListaTiposDocsEstrangeiro").select(tipoDocEstrangeiro);
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.000TelaValeTroca.NumeroDocumento").setText(numeroDocumento);
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.000TelaValeTroca.BotaoPesquisar").click();
					
			break;
		}
		case FISICA:{
			
			AUT_AGENT_SILK4J.<DomListBox>find("SAFE.000TelaValeTroca.ListaTiposPessoa").select(typePerson.toString());
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.000TelaValeTroca.NumeroDocumento").setText(numeroDocumento);
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.000TelaValeTroca.BotaoPesquisar").click();
			
			break;
		}
		case JURIDICA:{
			AUT_AGENT_SILK4J.<DomListBox>find("SAFE.000TelaValeTroca.ListaTiposPessoa").select(typePerson.toString());
			AUT_AGENT_SILK4J.<DomTextField>find("SAFE.000TelaValeTroca.NumeroDocumento").setText(numeroDocumento);
			AUT_AGENT_SILK4J.<DomElement>find("SAFE.000TelaValeTroca.BotaoPesquisar").click();

			break;
		}
		}

		AUT_AGENT_SILK4J.<DomElement>find("SAFE.000TelaValeTroca.ValeTrocaEmitido").click();
		
		String valeTroca = AUT_AGENT_SILK4J.<DomElement>find("SAFE.DetalhesValeTroca001.NumeroVale").getText();
		Integer vlTroca = Integer.parseInt(valeTroca);
		System.out.println(vlTroca);
		AUT_VALE_TROCA_OUTPUT = vlTroca.toString();
		
		AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.DetalhesValeTroca001").close();
		AUT_AGENT_SILK4J.<BrowserWindow>find("SAFE.000TelaValeTroca").close();
		
	}
	
	
	/**
	 * 
	 * Construtor padrão
	 * 
	 */
	public AUTSafeConsultaValeTroca() {
		// TODO Auto-generated constructor stub
	}

}
