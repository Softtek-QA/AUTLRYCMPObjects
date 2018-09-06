package br.lry.components.hmc;

import org.junit.Test;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.common.types.MouseButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTHMCCadastros extends AUTHMCLogin {
	
	
	private Desktop AUT_AGENT_SILK4J = new Desktop();


	String usuario = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN, "AUT_USER").toString();
	String senha = autGetCurrentParameter("AUT_PASSWORD").toString();
	String userID = autGetCurrentParameter("AUT_USER_ID").toString();
	String userName = autGetCurrentParameter("AUT_USER_NAME").toString();
	String email = autGetCurrentParameter("AUT_USER_EMAIL").toString();
	String novaSenha = autGetCurrentParameter("AUT_NOVA_SENHA").toString();
	String canal = autGetCurrentParameter("AUT_CANAL").toString();
	String tipo = autGetCurrentParameter("AUT_TIPO").toString();
	String unidadeB2B = autGetCurrentParameter("AUT_UNIDADE_B2B_PADRAO").toString();
	String departamento = autGetCurrentParameter("AUT_DEPARTAMENTO").toString();
	String codigoCategoria = autGetCurrentParameter("AUT_CODIGO_CATEGORIA").toString();
	String codigoDepartamento = autGetCurrentParameter("AUT_CODIGO_DEPARTAMENTO").toString();
	String loja = autGetCurrentParameter("AUT_LOJA").toString();
	
	
	
	
	/**
	 * 
	 * CADASTRO DE USUARIO B2B CUSTOMER
	 * 
	 */
	@Test
	public void autCadastrarUsuarioHMC() {

		autStartLoginDefault(usuario, senha);
		//AUT_AGENT_SILK4J.<DomTextField>find("HMC.Maximizar").click();
		//AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaLogin.Usuario").click();
		//AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaLogin.Usuario").setText(usuario);

		//AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaLogin.Senha").click();
		//AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaLogin.Senha").setText(senha);		
		//AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaLogin.BotaoLogin").click();

		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaInicial.ListaIdiomas").click();
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaInicial.ListaIdiomas").select("Português do Brasil");

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.MenuLateralUsuarios").click();

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.Clientes").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.NovoItem").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.SubMenuClienteDropDown").click();

		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.IdUsuario").setText(userID);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.NomeUsuario").setText(userName);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.DescricaoUsuario").setText(userName);

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaRemetentes.AbaRemetentes").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaRemetentes.Email").setText(email);

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaSenha.AbaSenha").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaSenha.NovaSenha").setText(novaSenha);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaSenha.Senha").setText(novaSenha);

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.AbaAdministracao").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaAdministracao.Canal").setText(tipo);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaAdministracao.Tipo").setText(canal);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaAdministracao.UnidadeB2BPadrao").setText(unidadeB2B);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaAdministracao.Departamento").setText(departamento);

		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaAdministracao.NumeroDepartamento").setText(departamento);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaAdministracao.CodigoCategoria").setText(codigoCategoria);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaAdministracao.CodigoDepartamento").setText(codigoDepartamento);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaAdministracao.Loja").setText(loja);
	}

	
}

