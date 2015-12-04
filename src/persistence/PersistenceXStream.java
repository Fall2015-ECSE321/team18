package persistence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.thoughtworks.xstream.XStream;

public class PersistenceXStream {

	private static XStream xstream = new XStream();
	private static String filename = "data.xml";
	
	public static boolean saveToXMLwithXStream(Object obj){
		xstream.setMode(XStream.ID_REFERENCES);
		String xml = xstream.toXML(obj); //save our XML file
		
		try{
			FileWriter writer = new FileWriter(filename);
			writer.write(xml);
			writer.close();
			return true;
		} catch(IOException e){
			createNewFile();
			//e.printStackTrace();
			return false;
		}
	}
	
	public static Object loadFromXMLwithXStream(){
		xstream.setMode(XStream.ID_REFERENCES);
		try{
			FileReader fileReader = new FileReader(filename);
			return xstream.fromXML(fileReader);
		} catch(IOException e){
			createNewFile();
			//e.printStackTrace();
			return null;
		}
	}
	
	public static void setAlias(String xmlTagName, Class<?> className){
		xstream.alias(xmlTagName, className);
	}
	
	public static void setFilename(String fn){
		filename = fn;
	}
	
	public static void createNewFile(){
		try{
			PrintWriter writer = new PrintWriter(filename, "UTF-8");
			writer.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
