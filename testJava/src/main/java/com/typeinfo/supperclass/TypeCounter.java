package com.typeinfo.supperclass;

import java.util.HashMap;
import java.util.List;

public class TypeCounter extends HashMap<Class<?>,Integer>{
	private Class<?> baseType;
	private static final long serialVersionUID = 4838210745378842262L;
	public void countType(Object obj) {
		Class<? extends Object> type = obj.getClass();
		if (!baseType.isAssignableFrom(type)) {
			throw new RuntimeException(
	                obj + " incorrect type " + type + ", should be type or subtype of " + baseType);
	        }
		
		countClass(type);
	}
	private void countClass(Class<?> type) {
		put(type, get(type)==null?1:get(type)+1);
		Class<?> superclass = type.getSuperclass();
		if (superclass!=null && baseType.isAssignableFrom(superclass)) {
			countClass(superclass);
		}
	}
	public void setBaseType(Class<?> baseClass) {
		this.baseType = baseClass;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(java.util.Map.Entry<Class<?>, Integer> entry:entrySet()){
			builder.append(entry.getKey().getSimpleName());
			builder.append("=");
			builder.append(entry.getValue());
			builder.append(", ");
		}
		builder.delete(builder.length()-2, builder.length());
		builder.append("}");
		return builder.toString();
	}
	public static void main(String[] args) {
		TypeCounter typeCounter = new TypeCounter();
		typeCounter.setBaseType(Individual.class);
		PetCreator petCreator = new LiteralPetCreator();
		List<Pet> petList = petCreator.arrayList(5);
		for (Pet pet : petList) {
			System.out.println(pet+" "+pet.id()+"");
			typeCounter.countType(pet);
		}
		System.out.println(typeCounter);
	}
}
