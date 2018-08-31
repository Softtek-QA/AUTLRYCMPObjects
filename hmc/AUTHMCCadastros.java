package br.lry.components.hmc;

import org.junit.Test;

import com.borland.silktest.jtf.Desktop;
import com.borland.silktest.jtf.xbrowser.DomElement;
import com.borland.silktest.jtf.xbrowser.DomLink;
import com.borland.silktest.jtf.xbrowser.DomTextField;

import br.lry.dataflow.AUTDataFlow.AUT_TABLE_PARAMETERS_NAMES;

public class AUTHMCCadastros extends AUTHMCLogin {
	
	
	private Desktop AUT_AGENT_SILK4J = new Desktop();
	
	
	public enum autTipeOfCutomer{
		CUSTUMER,
		LM_CUSTOMER,
		lM_JURICAL_PERSON,
		B2B_CUSTOMER;
		
		@Override
		public String toString() {
			switch(this) {
			case CUSTUMER: {
				return "Customer";
			}
			case LM_CUSTOMER: {
				return "[LMCustomer]";
			}
			case lM_JURICAL_PERSON: {
				return "[LMJuricalPerson]";
			}
			case B2B_CUSTOMER: {
				return "B2B Customer";
			}
			}
			return super.toString();
		}
	}
	
	
	//String userID = autGetCurrentParameter(AUT_TABLE_PARAMETERS_NAMES.AUT_HMC_LOGIN, "AUT_USER_ID").toString();
	//String userName = autGetCurrentParameter("AUT_USER_NAME").toString();
	
	
	@Test
	public void autCadastrarUsuarioHMC() {
		
		autStartLoginDefault();
		
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.User").click();
		AUT_AGENT_SILK4J.<DomLink>find("HMC.TelaInicial.Customers").click();
		AUT_AGENT_SILK4J.<DomElement>find("HMC.TelaInicial.New").click();
				
		


	
	}

	
}

