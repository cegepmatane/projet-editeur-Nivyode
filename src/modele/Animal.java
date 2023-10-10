package modele;



public class Animal {
	public enum ANIMAL{ANIMAL1, ANIMAL2, ANIMAL3, ANIMAL4, ANIMAL5}
	protected ANIMAL animal;
	
	public Animal(){
		super();
	}
	
	public Animal(ANIMAL animal) {
		super();
		this.animal = animal;
	}
	
	public ANIMAL getAnimal() {
		return animal;
	}

	public void setAnimal(ANIMAL animal) {
		this.animal = animal;
	}

}
