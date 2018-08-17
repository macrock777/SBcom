package com.mudra.mboss.master.services.impl.client;

public class TestGetter {
	
	public static void main(String arg[]) {
		String input = "carrot,mango,papiya,dhikdu,puchdu";
		
		 
		 StringBuffer output=new StringBuffer();
		 
		 String temp[]=input.split(",");
		 
		 for(String val:temp) {
			 String result = upperCaseFirst(val);
			 output.append("if(null!=bean.get"+result+"() && bean.get"+result+"().trim().length()>0) \n"+
					    "sm.setPannumber(bean.get"+result+"()); \n\n");
		 }
		 
	
	System.out.println(output.toString());
		 
		
	}
	public static String upperCaseFirst(String value) {

        // Convert String to char array.
        char[] array = value.toCharArray();
        // Modify first element in array.
        array[0] = Character.toUpperCase(array[0]);
        // Return string.
        return new String(array);
    }


}
