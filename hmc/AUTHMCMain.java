package br.lry.components.hmc;

import org.junit.Test;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTHMCMain extends AUTHMCLogin {
	
	
	private Desktop AUT_AGENT_SILK4J = new Desktop();
	
	
	String usuario = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN, "AUT_USER").toString();
	String senha = autGetCurrentParameter("AUT_PASSWORD").toString();
	/*
	String userID = autGetCurrentParameter("AUT_USER_ID").toString();
	String userName = autGetCurrentParameter("AUT_USER_NAME").toString();
	String userEmail = autGetCurrentParameter("AUT_USER_EMAIL").toString();
	String newPassword = autGetCurrentParameter("AUT_NEW_PASSWORD").toString();
	*/
	
	
	/**
	 * CADASTRO DE USUARIO B2B CUSTOMER
	 * 
	 */
	@Test
	public void autCadastrarUsuarioHMC() {
		
		autStartLoginDefault(usuario, senha);
		
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.User").click();
		AUT_AGENT_SILK4J.<DomLink>find("HMC.TelaInicial.Customers").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.New").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.B2BCustomer").click();		
		
		/*
		
		//Aba General
		AUT_AGENT_SILK4J.<DomElement>find("HMC.Menus.General").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.GeneralConfigurations.ID").setText(userID);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.GeneralConfigurations.Name").setText(userName);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.GeneralConfigurations.CustomerID").setText(userName);
		
		//Aba Addresses
		AUT_AGENT_SILK4J.<DomElement>find("HMC.Menus.Addresses").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.AddressesConfiguration.EMail").setText(userEmail);
		
		//Aba Password
		AUT_AGENT_SILK4J.<DomElement>find("HMC.Menus.Password").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.PaswordConfiguration.NewPassword").setText(newPassword);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.PasswordConfiguration.PasswordRepeat").setText(newPassword);
		
		//Aba Administration
		*/
		


	
	}

	
}

