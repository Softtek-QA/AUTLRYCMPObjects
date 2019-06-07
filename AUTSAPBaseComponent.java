package br.lry.components;

import java.io.IOException;

import com.borland.silktest.jtf.BaseState;
import com.borland.silktest.jtf.Control;
import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.PushButton;
import com.borland.silktest.jtf.win32.ListView;
import com.microfocus.silktest.jtf.sap.SapButton;
import com.microfocus.silktest.jtf.sap.SapRadioButton;
import com.microfocus.silktest.jtf.sap.SapTextField;
import com.microfocus.silktest.jtf.sap.SapWindow;
import com.microfocus.silktest.jtf.sap.common.types.VKey;

import br.lry.components.AUTBaseComponent.AUT_SYNC_EXECUTION_STATE;
import br.lry.components.pdv.AUTPDVBaseServices;
import br.lry.components.sap.AUTSAPBaseServices;
import br.lry.components.sap.AUTSAPBaseComponent.IAUTSAPProcessExecution;
import br.lry.components.va.AUTVAGeradorPedido.AUT_VA_FLUXO_SAIDA;
import br.lry.components.va.cat001.AUTVALogin;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTSAPBaseComponent extends AUTBaseComponent{
	
	public static br.lry.components.sap.AUTSAPBaseServices sap;
	
	
	public void autInitSAPApp() {				
		AUT_AGENT_SILK4J.<Control>find("SAPConnections.ItensConfiguracao").textClick("Conexões");
		AUT_AGENT_SILK4J.<ListView>find("SAPConnections.ListaConexoes").select("ECC - ECQ2");
		AUT_AGENT_SILK4J.<PushButton>find("SAPConnections.Logon").click();				
	}
	
	public void autStartLoginDefault(java.util.HashMap<String, Object> parametros) {
		//autInitSAPApp();
		AUT_AGENT_SILK4J.<Control>find("SAPConnections.ItensConfiguracao").textClick("Conexões");
		AUT_AGENT_SILK4J.<ListView>find("SAPConnections.ListaConexoes").select(parametros.get("AMBIENTE_SAP").toString());
		AUT_AGENT_SILK4J.<PushButton>find("SAPConnections.Logon").click();	
		
		AUT_AGENT_SILK4J.exists("SAP", 1000 * 180);
		
		AUT_AGENT_SILK4J.<SapWindow>find("SAP").setActive();
		AUT_AGENT_SILK4J.<SapTextField>find("SAP.Login.Usuario").setText(parametros.get("USUARIO_SAP").toString());
		AUT_AGENT_SILK4J.<SapTextField>find("SAP.Login.Senha").setText(parametros.get("SENHA_SAP").toString());
		
		AUT_AGENT_SILK4J.<SapButton>find("SAP.Executar").select();
		
		if(AUT_AGENT_SILK4J.<SapWindow>find("SAP").exists("OpcoesMultiplasConexoes",6000)) {
			AUT_AGENT_SILK4J.<SapRadioButton>find("SAP.OpcoesMultiplasConexoes.Multiconexao").select();
			AUT_AGENT_SILK4J.<SapWindow>find("SAP.OpcoesMultiplasConexoes").sendVKey(VKey.ENTER);
		}
	
	}
	
	public void autSAPLogout() {
		try {
			java.lang.Runtime.getRuntime().exec("cmd /c taskkill /f /t /im sap*");
			com.borland.silktest.jtf.Utils.sleep(15000);
		} catch (IOException e) {
			com.borland.silktest.jtf.Utils.sleep(15000);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * 
	 * CAT0XX
	 * CMP00002 - Realizar login no SAP
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00092(java.util.HashMap<String, Object> parametros) {
		sap = new AUTSAPBaseServices();
		sap.autSAPFaturarPedido(parametros);
	}
	
	/**
	 * 
	 * CAT0XX
	 * CMP00012 - Faturar pedido no SAP
	 * @param parametro - Parametros de entrada do sistema
	 * @return
	 */
	public void CMP00093(java.util.HashMap<String, Object> parametros) {
//		autInitConfigurationPDV();	
//		pdv.autStartPagamentoPedido(parametros);
//		autInsertScreenByScenario();
	}
}
