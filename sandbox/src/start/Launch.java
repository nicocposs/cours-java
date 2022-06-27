package start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Animal;
import model.Chat;
import model.Felin;
import model.Poule;

public class Launch {

	public static void main(String[] args) {
		List<Animal> animaux = Arrays.asList(new Chat(), new Felin(), new Animal(), new Poule());
		
		for(Animal a : animaux) {
			a.crie();
		}
	}

}
