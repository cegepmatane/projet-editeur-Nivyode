package modele;



public class Animal {
	public enum ANIMAL{animal1, animal2, animal3, animal4, animal5}
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
