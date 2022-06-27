package model;

public class Chat extends Felin {
	public void ronronne() {
		System.out.println("Je ronronne");
	}
	
	@Override
	public void crie() {
		System.out.println(this.getClass().getSimpleName() + " : Je miaule");
	}
}
