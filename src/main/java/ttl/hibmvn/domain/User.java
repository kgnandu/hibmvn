package ttl.hibmvn.domain;

public class User {
	private int id;
	private String name;
	private int total;
	private int goal;
	
	
	public User() {
		super();
	}
	public User(String name, int total, int goal) {
		super();
		this.name = name;
		this.total = total;
		this.goal = goal;
	}
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
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", total=" + total + ", goal=" + goal + "]";
	}
	

}
