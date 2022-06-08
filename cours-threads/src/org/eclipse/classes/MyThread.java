package org.eclipse.classes;

public class MyThread extends Thread {

	public MyThread() {
			// TODO Auto-generated constructor stub
	}

	public MyThread(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			if(!isInterrupted()) {
				System.out.print(this.getName() + " ");
			}
		}
	}
	
	
}
