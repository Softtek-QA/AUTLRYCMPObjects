package br.lry.components.hmc;

import org.junit.Test;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.common.types.MouseButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import org.junit.Assert;

public class AUTHMCCadastros extends AUTHMCLogin {
	public String AUT_USUARIO_CADASTRO_OUTPUT=null;
	public String AUT_USUARIO_CADASTRO_PWD_OUTPUT=null;	
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
	String gestorArea = autGetCurrentParameter("AUT_GESTOR").toString();


	/**
	 * 
	 * Executa procedimentos para configuração de perfis de usuário
	 * 
	 */
	public boolean autAdicionarPerfisUsuario(String[] perfis) {
		try {
			DomElement pefilInput = AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaCadastroClientes.PerfilUsuario");
			pefilInput.click();
			pefilInput.setFocus();
			for (String perfil : perfis) {			
				pefilInput = AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaCadastroClientes.PerfilUsuario");
				pefilInput.click();
				pefilInput.setFocus();
				pefilInput.waitForProperty("visible", true);
				pefilInput.typeKeys(perfil,0);
				pefilInput.typeKeys("\n");
			}
			System.out.println("HMC: AUT INFO: CONFIGURAR PERFIL DE ACESSO USUARIO VA");
			return true;
		} catch (java.lang.Exception e) {
			System.out.println("HMC: AUT ERROR: CONFIGURAR PERFIL DE ACESSO USUARIO VA");
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 
	 * CADASTRO DE USUARIO B2B CUSTOMER
	 * 
	 */
	@Test
	public void autCadastrarUsuarioHMC() {

		autStartLoginDefault(usuario, senha);

		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaInicial.ListaIdiomas").click();
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaInicial.ListaIdiomas").select("Português do Brasil");

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.MenuLateralUsuarios").click();

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.Clientes").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.NovoItem").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.SubMenuClienteDropDown").click();

		autAdicionarPerfisUsuario(new String[] { unidadeB2B, "LB01", "channel_store", "32_ATV", "GERENTE COMERCIAL",
				"35_ATV", "50000425-PROJETO 3D VENDA ASSISTIDA" });

		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.IdUsuario").setText(userID);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.NomeUsuario").setText(userName.concat(userID));
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.DescricaoUsuario")
		.setText(userName.concat(userID));

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaRemetentes.AbaRemetentes").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaRemetentes.Email").setText(email);

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaSenha.AbaSenha").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaSenha.NovaSenha").setText(novaSenha);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaSenha.Senha").setText(novaSenha);

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.AbaAdministracao").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Canal").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Canal").typeKeys(canal);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Canal").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Tipo").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Tipo").typeKeys(tipo);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.UnidadeB2BPadrao").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.UnidadeB2BPadrao").typeKeys(unidadeB2B);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.UnidadeB2BPadrao").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Departamento").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Departamento").typeKeys(departamento);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Departamento").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoria").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoria").typeKeys("\r");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoria").typeKeys(codigoCategoria);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoria").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.NumeroDepartamento").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.NumeroDepartamento").typeKeys(departamento);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.NumeroDepartamento").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoDepartamento").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoDepartamento").typeKeys(codigoDepartamento);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoDepartamento").typeKeys("\n");
		//AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoriaEmpPrivada").setFocus();
		//AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoriaEmpPrivada").typeKeys(codigoCategoria);
		//AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoriaEmpPrivada").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Loja").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Loja").typeKeys(loja);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Loja").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.GerenteAssociado").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.GerenteAssociado").typeKeys(gestorArea);

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaCadastroClientes.Geral").click();

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.MenuCriarUsuario").click();
		
		DomElement botaolSalvar = AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CheckPointBotaoSalvar");
		Assert.assertEquals(true, botaolSalvar.isVisible());
		Assert.assertEquals("Salvar", botaolSalvar.getText());
		
		AUT_USUARIO_CADASTRO_OUTPUT = userID;
		AUT_USUARIO_CADASTRO_PWD_OUTPUT = novaSenha;
		
	}

	public void autCadastrarUsuarioHMC(String lojaCadastro) {

		String formatLoja = String.format("%s_LMStore",lojaCadastro);
		
		autStartLoginDefault(usuario, senha);

		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaInicial.ListaIdiomas").click();
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaInicial.ListaIdiomas").select("Português do Brasil");

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.MenuLateralUsuarios").click();

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.Clientes").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.NovoItem").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.SubMenuClienteDropDown").click();

		autAdicionarPerfisUsuario(new String[] { lojaCadastro, "LB01", "channel_store", "32_ATV", "GERENTE COMERCIAL",
				"35_ATV", "50000425-PROJETO 3D VENDA ASSISTIDA" });

		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.IdUsuario").setText(userID);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.NomeUsuario").setText(userName.concat(userID));
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.DescricaoUsuario")
		.setText(userName.concat(userID));

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaRemetentes.AbaRemetentes").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaRemetentes.Email").setText(email);

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaSenha.AbaSenha").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaSenha.NovaSenha").setText(novaSenha);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaSenha.Senha").setText(novaSenha);

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.AbaAdministracao").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Canal").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Canal").typeKeys(canal);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Canal").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Tipo").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Tipo").typeKeys(tipo);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.UnidadeB2BPadrao").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.UnidadeB2BPadrao").typeKeys(lojaCadastro);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.UnidadeB2BPadrao").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Departamento").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Departamento").typeKeys(departamento);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Departamento").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoria").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoria").typeKeys("\r");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoria").typeKeys(codigoCategoria);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoria").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.NumeroDepartamento").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.NumeroDepartamento").typeKeys(departamento);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.NumeroDepartamento").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoDepartamento").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoDepartamento").typeKeys(codigoDepartamento);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoDepartamento").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Loja").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Loja").typeKeys(formatLoja);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Loja").typeKeys("\n");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.GerenteAssociado").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.GerenteAssociado").typeKeys(gestorArea);

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaCadastroClientes.Geral").click();

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.MenuCriarUsuario").click();
		
		DomElement botaolSalvar = AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CheckPointBotaoSalvar");
		Assert.assertEquals(true, botaolSalvar.isVisible());
		Assert.assertEquals("Salvar", botaolSalvar.getText());
		
		AUT_USUARIO_CADASTRO_OUTPUT = userID;
		AUT_USUARIO_CADASTRO_PWD_OUTPUT = novaSenha;
		
	}

}

