package org.eclipse.classes;

public class TestThread implements Runnable {
	private MyCount TC;
	private String name;

	public TestThread(MyCount tC, String name) {
		super();
		TC = tC;
		this.name = name;
	}

	public void run() {
		try {
			for (int i = 0; i < 3; i++) {
				synchronized (TC) {
					if (TC.getCount() > 0) {
						TC.decreaseCount();
						System.out.println("Operation reussie " + TC.getCount() + " demandee par " + name);
						Thread.sleep(500);
					} else
						System.out.println("Echec " + TC.getCount() + " demandee par " + name);
				}
			}

		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

}