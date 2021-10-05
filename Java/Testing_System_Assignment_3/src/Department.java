
public class Department implements Comparable<Department> {
	int id;
	String name;

	public Department(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public void Department() {

	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Department obj) {
		if (obj == null) {
			return -1;
		}
		if (name.compareTo(obj.name) > 0) {
			return 1;
		} else if (name.compareTo(obj.name) < 0) {
			return -1;
		}

		return 0;
	}
}
