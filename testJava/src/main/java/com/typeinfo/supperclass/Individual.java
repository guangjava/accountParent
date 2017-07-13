package com.typeinfo.supperclass;


public abstract class Individual implements Comparable<Individual>{
	private static long count = 0;
	private final long id = count++;
	String name; // name is optional
	@Override
	public int compareTo(Individual o) {
		 // Compare by class name first:
		
		if (o == null) {
			return 1;
		}
		String first = getClass().getSimpleName();
		String oFirst = o.getClass().getSimpleName();
		int firstCompare = first.compareTo(oFirst);
		if (firstCompare != 0) {
			return firstCompare;
		}
		if (name!=null && o.name!=null) {
			int secondCompare = name.compareTo(o.name);
			if (secondCompare != 0) {
				return secondCompare;
			}
		}
		return id>o.id ? 1 :id==o.id ? 0 : -1;
	}

	@Override
	public boolean equals(Object obj) {
		return obj instanceof Individual && id==((Individual)obj).id;
	}

	@Override
	public int hashCode() {
		int result = 17;
		if (name != null) {
			result = result * 37 + name.hashCode();
		}
		result = result * 37 + (int)id;
		return result;
	}

	public Individual(String name) {
		super();
		this.name = name;
	}

	public Individual() {
		super();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName()+name==null?"":" "+name;
	}
	public long id() {
		return id;
	}
}
