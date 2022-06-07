package org.eclipse.classes;

public class Operation<T> {
	private T var1;
	private T var2;

	public Operation(T var1, T var2) {
		this.var1 = var1;
		this.var2 = var2;
	}

	public void plus() {
		if (var1.getClass().getSimpleName().equals("Double"))
			System.out.println(Double.parseDouble(var1.toString()) + Double.parseDouble(var2.toString()));
		else if (var1.getClass().getSimpleName().equals("Integer"))
			System.out.println(Integer.parseInt(var1.toString()) + Integer.parseInt(var2.toString()));
		else if (var1.getClass().getSimpleName().equals("Boolean"))
			System.out.println(Boolean.parseBoolean(var1.toString()) || Boolean.parseBoolean(var2.toString()));
		else
			System.out.println(var1.toString() + var2.toString());
	}
}
