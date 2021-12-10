package StudentManagementSystem;

public class Course {
	private Integer ID;

    public Course() {
    }
    public Course(Integer iD, String courseName) {
        ID = iD;
        this.courseName = courseName;   //this method
    }

    private String courseName;

    /* getters */
    public Integer getID() {
        return ID;
    }

    public String getCourseName() {
        return courseName;
    }

    /* setters */
    public void setID(Integer iD) {
        this.ID = iD;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
}
