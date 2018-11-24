package sample.test.bean;

public class EmployeeInfo {
	public EmployeeInfo(String name, int age, String sports) {
		this.name = name;
		this.age = age;
		this.sports = sports;
	}
	public EmployeeInfo(int id, String name, int age, String sports) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.sports = sports;
	}
	private int id;
	private String name;
	private int age;
	private String sports;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
}
