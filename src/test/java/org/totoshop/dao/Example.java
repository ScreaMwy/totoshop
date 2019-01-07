package org.totoshop.dao;

public class Example {
	public static final class e {
		private Integer i = 0;

		public e() {
			i += 1;
		}

		public void show() {
			System.out.printf("%1.2f", i);
		}
	}

	public static final transient Example INSTANCE = new Example();
	
	private Example() {}

	public static Example getInstance() {
		return INSTANCE;
	}

	public static void main(String[] args) {
		Example.e ine = new Example.e();
	}
}