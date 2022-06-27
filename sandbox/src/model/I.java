package model;

public interface I {

	String MSG = "Hello";
	void sayHello();
	
	default void direBonjour() {
		System.out.println("Hello");
		message();
	}

	static int add(int a, int b) {
		return a+b;
	}
	
	private String message() {
		return "Message";
	}
}
