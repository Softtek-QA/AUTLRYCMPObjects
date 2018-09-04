package br.lry.components.hmc;

import org.junit.Test;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTHMCCadastros extends AUTHMCLogin {
	
	
	private Desktop AUT_AGENT_SILK4J = new Desktop();
	
	
	public enum AUT_ENUM{
		CHANNEL_STORE,
		CHANNEL_ECOMMERCE,
		CHANNEL_TELESEIOS,
		WITHOUT_CHANNEL;
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			
			return super.toString();
		}
	}


	String usuario = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN, "AUT_USER").toString();
	String senha = autGetCurrentParameter("AUT_PASSWORD").toString();
	String userID = autGetCurrentParameter("AUT_USER_ID").toString();
	String userName = autGetCurrentParameter("AUT_USER_NAME").toString();
	String userEmail = autGetCurrentParameter("AUT_USER_EMAIL").toString();
	String newPassword = autGetCurrentParameter("AUT_NEW_PASSWORD").toString();
	String identifierType = autGetCurrentParameter("AUT_IDENTIFIER_TYPE").toString();
	
	/**
	 * 
	 * CADASTRO DE USUARIO B2B CUSTOMER
	 * 
	 */
	@Test
	public void autCadastrarUsuarioHMC() {
		
		autStartLoginDefault(usuario, senha);

		

		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaLogin.Usuario").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaLogin.Usuario").setText(usuario);
		
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaLogin.Senha").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaLogin.Senha").setText(senha);		
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaLogin.BotaoLogin").click();
		
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaInicial.ListaIdiomas").click();
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaInicial.ListaIdiomas").select("Português do Brasil");

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.MenuGestaoUsuarios").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.NovoItem").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.SubMenuClienteDropDown").click();
		
		
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.IdUsuario").setText(userID);		
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.NomeUsuario").setText(userName);		
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.DescricaoUsuario").setText(userName);		
		
		//AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.B2BCustomer").click();
		
		//Aba Addresses
		AUT_AGENT_SILK4J.<DomElement>find("HMC.Menus.Addresses").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.AddressesConfiguration.EMail").setText(userEmail);
		
		//Aba Password
		AUT_AGENT_SILK4J.<DomElement>find("HMC.Menus.Password").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.PaswordConfiguration.NewPassword").setText(newPassword);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.PasswordConfiguration.PasswordRepeat").setText(newPassword);
		
		//Aba Administration
		AUT_AGENT_SILK4J.<DomElement>find("HMC.Menus.Administrator").click();
		//AUT_AGENT_SILK4J.<DomElement>find("HMC.AdministratorConfiguration.Type").setText();
		
		
	
	}

	
}

