package net.rodor.pgcconstantes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import net.rodor.pgcconstantes.bbdd.DataBaseConnFactory;
import net.rodor.pgcconstantes.bbdd.PreparedStatementFactory;
import net.rodor.pgcconstantes.logging.LoggerRodor;
import net.rodor.pgcconstantes.vo.ConstantesBean;
import net.rodor.pgcconstantes.vo.ConstantesBeanFactory;

public class ConstantesBeanDAOImpl implements ConstantesBeanDAOInt {
	
	protected LoggerRodor logger = new LoggerRodor(getClass().getName());
	public ConstantesBeanDAOImpl() {
		super();
	}

	public Collection<ConstantesBean> getAllByDate(Timestamp fecha) throws SQLException {
		logger.debug("ConstantesBeanDAOImpl.getAllByDate() en fecha:"+fecha);
		Collection<ConstantesBean> beans = new ArrayList<ConstantesBean>();
		
		Connection conn = DataBaseConnFactory.getInstance().getConnection();
		
		PreparedStatementFactory psf = PreparedStatementFactory.getInstance();
		String sql = psf.getSQL(ConstantesBeanDAOInt.CONSTANTES_SELECT_ALL_BY_DATE);
		logger.debug("SQL:"+sql);
		java.sql.Date fechaActivo = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		if(fecha != null){
			fechaActivo = new java.sql.Date(fecha.getTime());
		}
		
		PreparedStatement ps=null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setDate(1, fechaActivo);
			ps.setDate(2, fechaActivo);
			
			ResultSet rs = ps.executeQuery();
			ConstantesBeanFactory fac = ConstantesBeanFactory.getInstance();
			while(rs.next()){
				beans.add(fac.mapRow(rs));
			}
			
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		logger.debug("Se han cargado:"+beans.size()+" constantes");
		return beans;
	}

}
