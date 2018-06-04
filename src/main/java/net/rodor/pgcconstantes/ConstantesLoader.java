package net.rodor.pgcconstantes;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Hashtable;

import net.rodor.pgcconstantes.dao.ConstantesBeanDAOImpl;
import net.rodor.pgcconstantes.dao.ConstantesBeanDAOInt;
import net.rodor.pgcconstantes.logging.LoggerRodor;
import net.rodor.pgcconstantes.vo.ConstantesBean;

public class ConstantesLoader implements ConstantesLoaderInt{

	protected LoggerRodor logg = new LoggerRodor(getClass().getName());
	//private static final Logger logger = LoggerFactory.getInstance().getLogger(ConstantesLoader.class.getName());
	private  static ConstantesLoader instance = new ConstantesLoader();
	private static Hashtable<String,ConstantesBean> ConstantesSet = new Hashtable<String,ConstantesBean>();
	
	private ConstantesLoader(){}
	public  static ConstantesLoader getInstance(){
		return instance;
	}
	
	public Hashtable<String,ConstantesBean> getActiveConstantes(){
		if( !ConstantesSet.isEmpty()){
			logg.debug("Devolviendo constantes."+ConstantesSet.toString());
			return ConstantesSet;
		}
		return loadActiveConstantes();
	}

	public Hashtable<String,ConstantesBean> reLoadActiveConstantes(){
		logg.debug("Recargando constantes");
		return loadActiveConstantes();
	}
	public Hashtable<String,ConstantesBean> loadActiveConstantes(){
		
		Collection<ConstantesBean> constantesActivas = null;
		logg.debug("Cargando constantes");
		try{
			ConstantesBeanDAOInt cbdao = new ConstantesBeanDAOImpl();
			constantesActivas = cbdao.getAllByDate(null);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			
		}
			
		for(ConstantesBean ca: constantesActivas ){
			ConstantesSet.put(ca.clave, ca);
		}
		logg.debug("Constantes Cargadas Correctamente");
		return ConstantesSet;
		
	}
}
