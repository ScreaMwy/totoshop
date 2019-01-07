package org.totoshop.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.totoshop.util.annotation.Values;

@SuppressWarnings({"unused"})
public class AnnotationParse {	
	private String annotatedClass;
	
	Class<?> annotationClass;
	
	Field[] fields;
	
	private AnnotationParse() {}
	
	public AnnotationParse(String annotatedClass) {
		this.annotatedClass = annotatedClass;
	}
	
	public static AnnotationParse getParseForClassName(String annotatedClass) {
		return new AnnotationParse(annotatedClass);
	}
	
	public String annotationParseToString() {
		try {
			annotationClass = Class.forName(this.annotatedClass);
			Annotation[] annotations = annotationClass.getAnnotations();
			fields = annotationClass.getFields();
			String annotationValue = "";
			for (Annotation annotation : annotations) {
				if (annotation instanceof Values) {
					Values value = (Values) annotation;
					annotationValue = value.name();
					break;
				}
	     	}
			
			for (Field field : fields) {
				if (field.getName().equals("name")) {
					
				}
			}
			return annotationValue;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Class<?> annotationParseTosClass() {
		try {
			annotationClass = Class.forName(this.annotatedClass);
			Annotation[] annotations = annotationClass.getAnnotations();
			Class<?> annotationValue = null;
			for (Annotation annotation : annotations) {
				if (annotation instanceof Values) {
					Values value = (Values) annotation;
					annotationValue = value.classValue();
					break;
				}
			}
			return annotationValue;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
