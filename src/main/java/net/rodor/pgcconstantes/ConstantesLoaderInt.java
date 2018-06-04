package net.rodor.pgcconstantes;

import java.util.Hashtable;

import net.rodor.pgcconstantes.vo.ConstantesBean;

public interface ConstantesLoaderInt {
	public Hashtable<String,ConstantesBean> getActiveConstantes();
	public Hashtable<String,ConstantesBean> reLoadActiveConstantes();
	public Hashtable<String,ConstantesBean> loadActiveConstantes();
}
