package br.lry.components.tests;

import java.lang.reflect.Field;
import java.util.HashMap;

import br.lry.functions.AUTProjectsFunctions;
import br.lry.functions.AUTProjectsFunctions.AUT_TYPE_STATE_INSCRIPTION;
import br.lry.functions.AUTProjectsFunctions.AUT_TYPE_DOCUMENT_GENERATOR;

public class AUTProcessRuntimeData extends AUTParent {
	
	public static enum AUT_TYPE_OF_SUITE_OBJECTS{
		AUT_STRING,
		AUT_OBJECT,
		AUT_HASH_DATA,
		AUT_ENUMERATION,
		AUT_TEST_OBJECT,
		AUT_SCENARIO_OBJECT,
		AUT_SUITE_OBJECT,
		AUT_ALL_OBJECT;

		@Override
		public String toString() {
			switch(this) {
			case AUT_HASH_DATA:{
				return "java\\.util\\.HashMap.*";
			}
			case AUT_OBJECT:{
				return "java\\.lang\\.Object.*";
			}
			case AUT_STRING:{
				return "java\\.lang\\.String.*";
			}
			case AUT_ENUMERATION:{
				return "java\\.lang\\.Enum.*";
			}
			case AUT_TEST_OBJECT:{
				return "AUT\\_OBJECT\\_.*";
			}
			case AUT_ALL_OBJECT:{
				String outTypes = "(?i:";
				for(java.lang.Enum enu : this.getClass().getEnumConstants()) {
					if(enu.name()!=AUT_ALL_OBJECT.name()) {
						outTypes+=enu.toString().concat("|");
					}
				}
				outTypes+=")";	
				outTypes = outTypes.replaceAll("\\|\\)", ")");
				return outTypes;
			}
			case AUT_SCENARIO_OBJECT:{
				return "AUT_SCENARIO_.*";
			}
			case AUT_SUITE_OBJECT:{
				return "AUT_SUITE_.*";
			}
			default:{
				return this.getClass().getName();
			}
			}
		}		
	}
	
	
	
	public <TAUTObject extends br.lry.components.AUTBaseComponent> java.util.HashMap<String,Object> autGetDataObjects(TAUTObject classObject,AUT_TYPE_OF_SUITE_OBJECTS typesOutput) throws IllegalArgumentException, IllegalAccessException{
		java.util.HashMap<String,Object> dataObjs = new java.util.HashMap<String,Object>();
		String searchObject = typesOutput.toString();
		java.util.regex.Pattern regExp = java.util.regex.Pattern.compile(searchObject);
		
		java.util.regex.Matcher verifExp = null;
		java.util.regex.Matcher verifTypeExp = null;
		
		for(java.lang.reflect.Field fld : classObject.getClass().getFields()) {
			String name = fld.getName();
			verifExp = regExp.matcher(name);
			verifTypeExp = regExp.matcher(fld.getType().getName());
			boolean bVerifName = verifExp.find();
			boolean bVerifType = verifTypeExp.find();
			
			if(bVerifName || bVerifType) {
				
				if(bVerifName) {
					System.out.println("AUT INFO: FIND BY NAME : NAME");				
				}
				else {
					System.out.println("AUT INFO: FIND BY TYPE : NAME");									
				}

				System.out.println("AUT INFO: DATA OBJECT : NAME");
				System.out.println(fld.getName());
				System.out.println("AUT INFO: DATA OBJECT : TYPE");
				System.out.println(fld.getType().getName());		
				System.out.println("AUT INFO: DATA OBJECT : VALUE");
				System.out.println(fld.get(classObject));	

				if(dataObjs.containsKey(name)) {
					dataObjs.remove(name);
					dataObjs.put(name, fld.get(classObject));
				}
				else {
					dataObjs.put(name, fld.get(classObject));				
				}
			}
		}
		return dataObjs;
	}
	
	
	/**
	 * 
	 * Retorna os definidos em tempo de execução
	 * 
	 * 
	 * @return java.util.HashMap - Dados gerados em tempo de execução
	 * 
	 */
	public <TAUTObject extends br.lry.components.AUTBaseComponent> java.util.HashMap<String,Object> autGetRuntimeDataObject(TAUTObject runtimeClass,AUT_TYPE_OF_SUITE_OBJECTS typeObject){
		java.util.HashMap<String,Object> dataOut = new java.util.HashMap<String,Object>();
		try {
			autGetDataObjects(runtimeClass, typeObject);			
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataOut;
	}
	
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		
		/*		 
		AUTProcessRuntimeData chl = new AUTProcessRuntimeData();
		System.out.println("AUT INFO : CHILD CLASS");
		chl.autGetRuntimeDataObject(chl,AUT_TYPE_OF_SUITE_OBJECTS.AUT_OBJECT);		
		*/
		System.out.println(AUTProjectsFunctions.autGetNewDocument(AUT_TYPE_DOCUMENT_GENERATOR.INSCRIPTION, AUT_TYPE_STATE_INSCRIPTION.PR_PARANA));
	
	}
	
	public AUTProcessRuntimeData() {
		// TODO Auto-generated constructor stub
	}

}
