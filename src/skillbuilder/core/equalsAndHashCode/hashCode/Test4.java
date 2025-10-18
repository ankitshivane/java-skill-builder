package skillbuilder.core.equalsAndHashCode.hashCode;

import java.util.HashSet;

public class Test4 {
    public static void main(String[] args) {
        // Case 1:
        HashSet<Animal> set = new HashSet<>();
        set.add(new Animal("dog"));
        System.out.println(set.contains(new Animal("dog"))); // false,
        /*
        because even if we overidden the equals() method but hashCode is not overrided from Object to Animal. so here the object class hashCode() method
         will be invoke which will give different hashcode number resulting in different bucket location
         */
    }
}

class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public boolean equals(Object animal) {
        System.out.println("Animal class equals() method called..");
        if (animal == null || getClass() != animal.getClass()) {
            return false;
        }
        Animal animal1 = (Animal) animal;
        return this.name.equals(animal1.name);
    }
}