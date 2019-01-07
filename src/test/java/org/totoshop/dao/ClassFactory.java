package org.totoshop.dao;

public class ClassFactory {
	private static ClassFactory CLASS_FACTORY_INSTANCE;

	private ClassFactory() {}

	public static ClassFactory getInstance() {
		if (null == CLASS_FACTORY_INSTANCE) {
			CLASS_FACTORY_INSTANCE = new ClassFactory();
		}
		return CLASS_FACTORY_INSTANCE;
	}

	public Files getFile(String className) {
		try {
			Class<?> c = Class.forName(className);
			Files files;
			files = (Files) c.newInstance();
			return files;
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
			return null;
		}
	}
}
