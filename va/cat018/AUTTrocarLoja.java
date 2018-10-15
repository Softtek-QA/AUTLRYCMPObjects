package br.lry.components.va.cat018;

import java.util.HashMap;

import com.borland.silktest.jtf.xbrowser.DomButton;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.components.AUTVABaseComponent;

public class AUTTrocarLoja extends AUTVABaseComponent {
	
	

	public enum AUT_VA_SELECAO_LOJA{
		LM_0001_INTERLAGOS,
		LM_0002_RIBEIRAO_PRETO,
		LM_0003_CAMPINAS_DOM_PEDRO,
		LM_0004_CONTAGEM,
		LM_0005_RAPOSO_TAVARES,
		LM_0007_RIO_NORTE,
		LM_0008_TIETE,		
		LM_0009_CURITIBA,
		LM_0010_SC_DO_SUL,
		LM_0011_RIO_BARRA,
		LM_0012_MORUMBI,
		LM_0013_BRASILIA_SUL,
		LM_0015_SJ_DOS_CAMPOS,
		LM_0016_RICARDO_JAFET,
		LM_0017_BANGU,
		LM_0018_GOIANIA,
		LM_0019_PORTO_ALEGRE,
		LM_0020_BH_SUL,
		LM_0021_NITEROI,
		LM_0022_ANHANGUERA,
		LM_0023_TAGUATINGA,
		LM_0024_LAR_CENTER,
		LM_0026_JACAREPAGUA,
		LM_0027_SOROCABA,
		LM_0028_BRASILIA_NORTE,
		LM_0029_UBERLANDIA,
		LM_0032_SAO_LEOPOLDO,
		LM_0033_LONDRINA,
		LM_0034_SJ_DO_RIO_PRETO,
		LM_0035_CURITIBA,
		LM_0036_BELO_HORIZONTE,
		LM_0038_FORTALEZA,
		LM_0039_SAO_JOSE_SC,
		LM_0041_TATUAPE,
		LM_0042_JAGUARE,
		LM_0043_ECOMMERCE,
		LM_0044_CAMPO_GRANDE,
		LM_0045_SAO_BERNARDO_DO_CAMPO,
		LM_0046_TAMBORE,
		LM_0049_PARNAMIRIM,
		LM_0050_LOJA_MACEIO,
		LM_0053_JORDANESIA,
		LM_0055_LOJA_TAUBATE,
		LM_0058_LOJA_TIETE_II,
		LM_0060_MARKETPLACE;
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			switch(this) {
			case LM_0001_INTERLAGOS: {
				return "0001 - Interlagos";
			}
			case LM_0002_RIBEIRAO_PRETO: {
				return "0002 - Ribeirão Preto";
			}
			case LM_0003_CAMPINAS_DOM_PEDRO: {
				return "0003 - Campinas Dom Pedro";
			}
			case LM_0004_CONTAGEM: {
				return "0004 - Contagem";
			}
			case LM_0005_RAPOSO_TAVARES: {
				return "0005 - Raposo Tavares";
			}
			case LM_0007_RIO_NORTE: {
				return "0007 - Rio Norte";
			}
			case LM_0008_TIETE: {
				return "0008 - Tietê";
			}
			case LM_0009_CURITIBA: {
				return "0009 - Curitiba";
			}
			case LM_0010_SC_DO_SUL: {
				return "0010 - S.C. do Sul";
			}
			case LM_0011_RIO_BARRA: {
				return "0011 - Rio Barra";
			}
			case LM_0012_MORUMBI: {
				return "0012 - Morumbi";
			}
			case LM_0013_BRASILIA_SUL: {
				return "0013 - Brasília Sul";
			}
			case LM_0015_SJ_DOS_CAMPOS: {
				return "0015 - S.J dos Campos";
			}
			case LM_0016_RICARDO_JAFET: {
				return "0016 - Ricardo Jafet";
			}
			case LM_0017_BANGU: {
				return "0017 - Bangu";
			}
			case LM_0018_GOIANIA: {
				return "0018 - Goiânia";
			}
			case LM_0019_PORTO_ALEGRE: {
				return "0019 - Porto Alegre";
			}
			case LM_0020_BH_SUL: {
				return "0020 - BH Sul";
			}
			case LM_0021_NITEROI: {
				return "0021 - Niterói";
			}
			case LM_0022_ANHANGUERA: {
				return "0022 - Anhanguera";
			}
			case LM_0023_TAGUATINGA: {
				return "0023 - Taguatinga";
			}
			case LM_0024_LAR_CENTER: {
				return "0024 - Lar Center";
			}
			case LM_0026_JACAREPAGUA: {
				return "0026 - Jacarepagua";
			}
			case LM_0027_SOROCABA: {
				return "0027 - Sorocaba";
			}
			case LM_0028_BRASILIA_NORTE: {
				return "0028 - Brasília Norte";
			}
			case LM_0029_UBERLANDIA: {
				return "0029 - Uberlândia";
			}
			case LM_0032_SAO_LEOPOLDO: {
				return "0032 - São Leopoldo";
			}
			case LM_0033_LONDRINA: {
				return "0033 - Londrina";
			}
			case LM_0034_SJ_DO_RIO_PRETO: {
				return "0034 - S.J. do Rio Preto";
			}
			case LM_0035_CURITIBA: {
				return "0035 - Curitiba";
			}
			case LM_0036_BELO_HORIZONTE: {
				return "0036 - Belo Horizonte";
			}
			case LM_0038_FORTALEZA: {
				return "0038 - Fortaleza";
			}
			case LM_0039_SAO_JOSE_SC: {
				return "0039 - São José SC";
			}
			case LM_0041_TATUAPE: {
				return "0041 - Tatuapé";
			}
			case LM_0042_JAGUARE: {
				return "0042 - Jaguaré";
			}
			case LM_0043_ECOMMERCE: {
				return "0043 - E-commerce";
			}
			case LM_0044_CAMPO_GRANDE: {
				return "0044 - Campo Grande";
			}
			case LM_0045_SAO_BERNARDO_DO_CAMPO: {
				return "0045 - São Bernardo do Camp";
			}
			case LM_0046_TAMBORE: {
				return "0046 - Tamboré";
			}
			case LM_0049_PARNAMIRIM: {
				return "0049 - Parnamirim";
			}
			case LM_0050_LOJA_MACEIO: {
				return "0050 - Loja Maceió";
			}
			case LM_0053_JORDANESIA: {
				return "0053 - Jordanésia";
			}
			case LM_0055_LOJA_TAUBATE: {
				return "0055 - Loja Taubaté";
			}
			case LM_0058_LOJA_TIETE_II: {
				return "0058 - Loja Tietê II";
			}
			case LM_0060_MARKETPLACE: {
				return "0060 - Marketplace";
			}
			}
			return super.toString();
		}
		
	}
	
	/**
	 * Realizar troca de loja para usuários Televendas
	 * @param <AUT_VA_SELECAO_LOJA>
	 * 
	 * @param usuario - Usuário Televendas
	 * @param senha - Senha para acesso ao sistema VA
	 * @param lojaSelecionada - Loja selecionada
	 */
	public  boolean autTrocaDeLoja(String usuario, String senha, AUT_VA_SELECAO_LOJA lojaSelecionada) {
		try {
			autLoginVATelevendas(usuario, senha);
			AUT_AGENT_SILK4J.<DomElement>find("VA.TelaInicialLoja.BotaoLoja").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.Televendas.SelecionarLoja").click();
			AUT_AGENT_SILK4J.<DomElement>find("VA.Televendas.CampoSelecaoLoja").click();
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Televendas.CampoSelecaoLoja").typeKeys(lojaSelecionada.toString());
			AUT_AGENT_SILK4J.<DomTextField>find("VA.Televendas.CampoSelecaoLoja").typeKeys("\n");
			AUT_AGENT_SILK4J.<DomButton>find("VA.Televendas.BotaoEscolher").click();
			return true;
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
	}
	
	
	
}
