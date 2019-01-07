package org.totoshop.util.pool;

import java.util.List;
import java.util.Vector;

public class PooledObjectFactory {
	static {
		List<Object> objects = new Vector<Object>();
	}
	
	private static final PooledObjectFactory POOLED_OBJECT_FACTORY = new PooledObjectFactory();
	
	private int maxPoolSize = 10;
	
	private PooledObjectFactory() {}
	
	public static PooledObjectFactory getInstance() {
		return POOLED_OBJECT_FACTORY;
	}
	
	
}
