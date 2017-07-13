package com.typeinfo.supperclass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class PetCreator {
	Random ran = new Random(47);
	 // The List of the different getTypes of Pet to create:
	public abstract List<Class<? extends Pet>> getTypes();
	public Pet randomPet() {
		int n = ran.nextInt(getTypes().size());
		try {
			return getTypes().get(n).newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException();
		}
	}
	public Pet[] createarray(int size) {
		Pet[] array = new Pet[size];
		for(int i=0;i<size;i++){
			array[i] = randomPet();
		}
		return array;
	}
	public List<Pet> arrayList(int size) {
		Pet[] array = createarray(size);
		List<Pet> list = new ArrayList<>();
		Collections.addAll(list, array);
		return list;
	}
}
