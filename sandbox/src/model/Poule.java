package model;

public class Poule extends Animal {
	@Override
	public void crie() {
		System.out.println(this.getClass().getSimpleName() + " : Je fais cot cot");
	}
}
