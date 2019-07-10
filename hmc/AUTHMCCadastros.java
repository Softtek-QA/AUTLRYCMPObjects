package br.lry.components.hmc;

import org.junit.Test;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.common.types.MouseButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomListBox;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.dataflow.AUTDataFlow.AUT_HMC_PERFIL_ACESSO;
import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;
import br.stk.framework.tests.AUTFWKTestObjectBase;

import org.junit.Assert;

public class AUTHMCCadastros extends AUTHMCLogin {
	public String AUT_USUARIO_CADASTRO_OUTPUT=null;
	public String AUT_USUARIO_CADASTRO_PWD_OUTPUT=null;
	public String host = "127.0.0.1";

	String usuario = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_USER").toString();
	String senha = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_PASSWORD").toString();
	String userID = autGetCurrentParameterDataFlowLocal(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_USER_ID").toString();
	String userName = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_USER_NAME").toString();
	String email = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_USER_EMAIL").toString();
	String novaSenha = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_NOVA_SENHA").toString();
	String canal = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_CANAL").toString();
	String tipo = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_TIPO").toString();
	String unidadeB2B = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_UNIDADE_B2B_PADRAO").toString();
	String departamento = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_DEPARTAMENTO").toString();
	String codigoCategoria = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_CODIGO_CATEGORIA").toString();
	String codigoDepartamento = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_CODIGO_DEPARTAMENTO").toString();
	String loja = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_LOJA").toString();
	String gestorArea = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_GESTOR").toString();

	String paisUsuario = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_PAIS_USUARIO").toString();
	String moedaPadraoUsuario = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_MOEDA_PADRAO").toString();
	

	public void autSetHostExecutionService(String host) {
		AUT_AGENT_SILK4J = new Desktop(host);
	}
	
	/**
	 * 
	 * Executa procedimentos para configuração de perfis de usuário
	 * 
	 */
	public boolean autAdicionarPerfisUsuario(String[] perfis) {
		try {
			DomTextField pefilInput = AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.PerfilUsuario");
			pefilInput.click();
			pefilInput.setFocus();
			for (String perfil : perfis) {			
				pefilInput = AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.PerfilUsuario");
				pefilInput.click();
				pefilInput.setFocus();
				pefilInput.waitForProperty("visible", true);
				//pefilInput.setFocus();
				//pefilInput.typeKeys(perfil,800);
					
				autSetContentHMC(perfil,pefilInput);
				pefilInput.typeKeys(" \n");
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

	
	public void autSetContentHMC(String content,DomElement objTest) {
		Character chrItem = null;
		for(Character chr : content.toCharArray()) {
			chrItem = chr;
		}
		objTest.setFocus();
		objTest.setProperty("value", content.substring(0, content.length()-1));
		objTest.typeKeys(chrItem.toString());
	}
	
	
	public void autCadastrarUsuarioHMCV2(String lojaCadastro) {

		String formatLoja = String.format("%s_LMStore",lojaCadastro);
		
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_USER_ID", usuario);
		autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_PASSWORD", senha);
		autStartLoginDefault(usuario, senha);
		
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaInicial.ListaIdiomas").click();
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaInicial.ListaIdiomas").select("Português do Brasil");
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.MenuLateralUsuarios").click();

		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.Clientes").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.NovoItem").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.SubMenuClienteDropDown").click();
		
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaCadastroClientes.ListaOpcoesPais").click();
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaCadastroClientes.ListaOpcoesPais").select(paisUsuario);
		
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaCadastroClientes.ListaOpcoesMoedas").click();
		AUT_AGENT_SILK4J.<DomListBox>find("HMC.TelaCadastroClientes.ListaOpcoesMoedas").select(moedaPadraoUsuario);
		
		AUT_HMC_PERFIL_ACESSO hmcPerf = AUT_HMC_PERFIL_ACESSO.valueOf(autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_PERFIL_ACESSO").toString());		
		switch(hmcPerf) {
		case APROVADOR_COMERCIAL:{
			autAdicionarPerfisUsuario(new String[] { lojaCadastro,"employee_type_employee", "LB01", "channel_store", "32_ATV", "GERENTE COMERCIAL",
					"35_ATV","41_ATV","42_ATV","50000425-PROJETO 3D VENDA ASSISTIDA"});
			autSetCurrentParameter(AUT_CURRENT_PARAMETERS_TABLE_NAME.AUT_HMC_LOGIN,"AUT_CANAL", lojaCadastro);
			
			break;
		}
		case PJ_CADASTRO_EXCECAO:{
			autAdicionarPerfisUsuario(new String[] { lojaCadastro, "LB01", "channel_store", "32_ATV","67_ATV", "GERENTE COMERCIAL",
					"35_ATV", "50000425-PROJETO 3D VENDA ASSISTIDA" , "14_ATV", "50_Cadastro_PJ_excecao", "98_ATV"});
			break;
		}
		case USUARIO_LOJA:{
			canal = "channel_store";
			autAdicionarPerfisUsuario(new String[] { lojaCadastro, "LB01", "channel_store","ASSESSOR DE VENDAS", "32_ATV","35_ATV",
					"b2bgroup", "employee_type_employee","50000425-PROJETO 3D VENDA ASSISTIDA"});
			break;
		}
		case USUARIO_TELEVENDAS:{
			canal = "channel_telesales";
			lojaCadastro = formatLoja;
			autSetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN,"AUT_CANAL", canal);		
			autAdicionarPerfisUsuario(new String[] {"b2bgroup","employee_type_employee","ASSESSOR DE TELEVENDAS","50000425-PROJETO 3D VENDA ASSISTIDA","LB01","32_ATV","35_ATV", "67_ATV"});
			
			break;
		}		
		default:{
			autAdicionarPerfisUsuario(new String[] { lojaCadastro, "LB01","b2bgroup","employee_type_employee", "channel_store", "32_ATV","67_ATV",
					"35_ATV", "50000425-PROJETO 3D VENDA ASSISTIDA" });			
			break;
		}
		}
		
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.IdUsuario").setText(userID);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.NomeUsuario").setText(userName.concat(userID));
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaCadastroClientes.DescricaoUsuario")
		.setText(userName.concat(userID));
				
		AUT_USUARIO_CADASTRO_OUTPUT = userID;
		AUT_USUARIO_CADASTRO_PWD_OUTPUT = novaSenha;


		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaRemetentes.AbaRemetentes").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaRemetentes.Email").setText(email);
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaSenha.AbaSenha").click();
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaSenha.NovaSenha").setText(novaSenha);
		AUT_AGENT_SILK4J.<DomTextField>find("HMC.TelaSenha.Senha").setText(novaSenha);
				
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.AbaAdministracao").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Canal").setFocus();
		
		autSetContentHMC(canal,AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Canal"));
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Canal").typeKeys("\n");
		
		autSetContentHMC(tipo,AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Tipo"));
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Tipo").typeKeys("\n");
		
		autSetContentHMC(( hmcPerf == AUT_HMC_PERFIL_ACESSO.USUARIO_TELEVENDAS ? "TELEVENDAS" : lojaCadastro),AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.UnidadeB2BPadrao"));
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.UnidadeB2BPadrao").typeKeys("\n");
		
		autSetContentHMC(departamento,AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Departamento"));
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Departamento").typeKeys("\n");

		autSetContentHMC(codigoCategoria,AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoria"));
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoCategoria").typeKeys("\n");

		autSetContentHMC(departamento,AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.NumeroDepartamento"));		
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.NumeroDepartamento").typeKeys("\n");
		
		autSetContentHMC(codigoDepartamento,AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoDepartamento"));				
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CodigoDepartamento").typeKeys("\n");

		autSetContentHMC(formatLoja,AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Loja"));								
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.Loja").typeKeys("\n");
		
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.GerenteAssociado").setFocus();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.GerenteAssociado").typeKeys(gestorArea);
		autInsertScreenByScenario();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaCadastroClientes.Geral").click();

		
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.MenuCriarUsuario").click();
		autInsertScreenByScenario();
		DomElement botaolSalvar = AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaAdministracao.CheckPointBotaoSalvar");
		Assert.assertEquals(true, botaolSalvar.isVisible());
		Assert.assertEquals("Salvar", botaolSalvar.getText());
		autInsertScreenByScenario();
		
	}

}

