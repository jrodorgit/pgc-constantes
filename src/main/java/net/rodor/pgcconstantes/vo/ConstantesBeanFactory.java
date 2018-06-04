package net.rodor.pgcconstantes.vo;

//Fichero generado automaticamente por PGC.

import java.sql.ResultSet;
import java.sql.SQLException;


public class ConstantesBeanFactory{

	private  volatile static ConstantesBeanFactory instance;
	private ConstantesBeanFactory(){}
	public  static ConstantesBeanFactory getInstance(){
		if(instance == null){
			synchronized (ConstantesBeanFactory.class){
				if(instance == null){
					instance = new ConstantesBeanFactory();
				}
			}
		}
		return instance;
	}
	public ConstantesBean mapRow(ResultSet rs) throws SQLException {
		
		ConstantesBean miEntity= new ConstantesBean() ;
		miEntity.clave = rs.getString(ConstantesBean.CLAVE);
		miEntity.descripcion = rs.getString(ConstantesBean.DESCRIPCION);
		miEntity.fechaInicio = rs.getTimestamp(ConstantesBean.FECHA_INICIO);
		miEntity.fechaFin = rs.getTimestamp(ConstantesBean.FECHA_FIN);
		
		return miEntity;
	}
	
}