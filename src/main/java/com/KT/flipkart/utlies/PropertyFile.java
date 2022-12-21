package com.KT.flipkart.utlies;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
	


public static String getValueForKey(String Key) throws IOException
{
	Properties p=new Properties();
	FileInputStream fi=new FileInputStream(System.getProperty("user.dir")+"\\Properties\\environmet.properties");
	
	p.load(fi);
	return p.getProperty(Key);
	
	
	
}
}
