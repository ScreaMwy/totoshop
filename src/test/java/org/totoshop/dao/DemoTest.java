package org.totoshop.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

@SuppressWarnings({"unused"})
public class DemoTest {
	@Test
	public void test() {
		Example e1 = Example.getInstance();
		Example e2 = Example.getInstance();
		if (e1.hashCode() == e2.hashCode()) {
			System.out.printf("%s : %d = %d", "HashCode", e1.hashCode(), e2.hashCode());
		} else {
			System.out.printf("%s : %d != %d", "HashCode", e1.hashCode(), e2.hashCode());
		}
	}
}
