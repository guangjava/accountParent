package com.typeinfo.supperclass;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator{
	private static List<Class<? extends Pet>> allTypes = Collections.unmodifiableList(Arrays.asList(Pet.class,Cat.class,Dog.class,EgyptianMau.class,Mutt.class));
	private static List<Class<? extends Pet>> types = allTypes.subList(allTypes.indexOf(EgyptianMau.class), allTypes.size());
	@Override
	public List<Class<? extends Pet>> getTypes() {
		return types;
	}
	}
