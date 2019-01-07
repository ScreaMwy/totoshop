package org.totoshop.util.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Target;

import java.lang.annotation.Retention;
import java.lang.annotation.Documented;

@Target({TYPE, FIELD, METHOD, PARAMETER})
@Retention(RUNTIME)
@Documented
public @interface Values {
	String name() default "";
	
	Class<?> classValue() default Object.class;
}
