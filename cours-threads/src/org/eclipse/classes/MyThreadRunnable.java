package org.eclipse.classes;

public class MyThreadRunnable implements Runnable {

	private String name;
	
	
	
	public MyThreadRunnable(String name) {
		this.name = name;
	}



	public MyThreadRunnable() {
	}



	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			
			System.out.print(this.getName() + " ");
		}
	}



	public String getName() {
		return name;
	}
	
	

}
