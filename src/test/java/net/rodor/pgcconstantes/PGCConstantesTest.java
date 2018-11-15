package net.rodor.pgcconstantes;

import java.sql.SQLException;
import java.util.Hashtable;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;
import net.rodor.pgcconstantes.ConstantesLoader;
import net.rodor.pgcconstantes.ConstantesLoaderInt;
import net.rodor.pgcconstantes.vo.ConstantesBean;

public class PGCConstantesTest extends TestCase{

	
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args)  {
		
		//PGCConstantesTest test = new PGCConstantesTest();
		//test.testApp();
	}
	
	public void testApp(){
		//System.out.println("Lanzando pruebas...");
		//
		ConstantesLoaderInt constLoader = ConstantesLoader.getInstance();
		Hashtable<String, ConstantesBean> constantes = constLoader.getActiveConstantes();
		//System.out.println("constA:"+constantes.toString());
		
		constantes = constLoader.getActiveConstantes();
		assertTrue("constA".equalsIgnoreCase(constantes.get("constA").clave));
		//System.out.println("constA:"+constantes.get("constA"));
		constantes = constLoader.reLoadActiveConstantes();
		assertTrue("constA".equalsIgnoreCase(constantes.get("constA").clave));
		//System.out.println("constA:"+constantes.get("constA"));
		
		
		//System.out.println("Fin");
		
	}
	
	public void testSpring(){
		//System.out.println("Lanzando pruebas spring...");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net/rodor/pgcconstantes/Beans.xml");
		ConstantesLoaderInt constLoader = (ConstantesLoaderInt) context.getBean("idConstantesLoader");
		Hashtable<String, ConstantesBean> constantes = constLoader.getActiveConstantes();
		constantes = constLoader.getActiveConstantes();
		assertTrue("constA".equalsIgnoreCase(constantes.get("constA").clave));
		
		//System.out.println("Fin");
		
	}
}
