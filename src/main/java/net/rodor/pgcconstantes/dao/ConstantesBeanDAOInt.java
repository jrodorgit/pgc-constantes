package net.rodor.pgcconstantes.dao;

import java.sql.SQLException;
import java.util.Collection;

import net.rodor.pgcconstantes.vo.ConstantesBean;

//Fichero generado automaticamente por PGC.

public interface ConstantesBeanDAOInt{

	public static final String CONSTANTES_SELECT_ALL_BY_DATE = "CONSTANTES_SELECT_ALL_BY_DATE";
	
	/**
	 * Devuelve la relacion de constantes activas para una fecha.
	 * Si la fecha es nula devuelve los activos a fecha de sistema
	 * @param fecha
	 * @return
	 */
	public Collection<ConstantesBean> getAllByDate(java.sql.Timestamp fecha) throws SQLException;
	
}