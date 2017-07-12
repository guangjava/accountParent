package com.typeinfo.supperclass;


public abstract class Individual implements Comparable<Individual>{
	int id;
	String name;
	@Override
	public int compareTo(Individual o) {
		if (o == null) {
			return 1;
		}
		if (this.equals(o)) {
			return 0;
		}
		if (this.id == o.id) {
			return 0;
		}
		return this.id>o.id ? 1 : -1;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Individual)) {
			return false;
		}
		Individual individual = (Individual)obj;
		if (this.id==individual.id && (this.name==null && individual.name==null)||(this.name!=null&&this.name.equals(individual.name))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return 17+id;
	}

	public Individual(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Individual() {
		super();
	}

}
