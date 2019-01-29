package br.lry.components.tests;

import org.junit.Test;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import br.lry.components.sap.AUTSAPBaseServices;



@RunWith(com.borland.silktest.jtf.SilkTestCategories.class)
@SuiteClasses(AUTSAPBusiness.class)
public class AUTSAPTests extends AUTSAPBaseServices{	
	public AUTSAPTests() {
		// TODO Auto-generated constructor stub
	}
}
