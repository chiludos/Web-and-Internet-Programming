package final_sample_model;

public class QCourse {

	private int id;
	private String name;
	
	public QCourse(int idIn, String nameIn) {
		id = idIn;
		name = nameIn;
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
}
