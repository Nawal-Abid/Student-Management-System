package StudentManagementSystem;

public class Student {
                           // protected variables
		protected Integer ID;
	    protected String firstName;
	    protected String lastName;
	    protected String studentLevel;
	    protected boolean active = true;

	    /* getters */
	    public Integer getID() {
	        return ID;
	    }

	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public String getStudentLevel() {
	        return studentLevel;
	    }

	    public boolean isActive() {
	        return active;
	    }

	    /* setters */
	    public void setActive(boolean active) {
	        this.active = active;
	    }

	    public void setStudentLevel(String studentLevel) {
	        this.studentLevel = studentLevel;
	    }

	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }

	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }

	    public void setID(Integer iD) {
	        this.ID = iD;
	    }
		
}
