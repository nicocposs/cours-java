package model;

public class Felin extends Animal {
	@Override
	public void crie() {
		System.out.println(this.getClass().getSimpleName() + " : Je feule");
	}
}
