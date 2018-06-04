package net.rodor.pgcconstantes.vo;

//Fichero generado automaticamente por PGC.

import java.sql.Timestamp;
/**
 * Constantes Bean
 * @author www.rodor.net
 *
 */
public class ConstantesBean implements  java.io.Serializable  {
	
	private static final long serialVersionUID = 4169581525744332370L;
	public static final String CLAVE = "clave";
	public static final String DESCRIPCION = "descripcion";
	public static final String FECHA_INICIO = "fechini";
	public static final String FECHA_FIN = "fechfin";
	
	public  String clave;
	public  String descripcion;
	public  Timestamp fechaInicio;
	public  Timestamp fechaFin;
	
	public  String  toJSONFormat (){ return "{\r\n \"clave\" : \""+this.clave+"\" \r\n \"descripcion\" : \""+this.descripcion+"\" \r\n \"fechaInicio\" : \""+this.fechaInicio+"\" \r\n \"fechaFin\" : \""+this.fechaFin+"\" \r\n\r\n}";}
	public  String  toString(){ return  toJSONFormat ();}
}