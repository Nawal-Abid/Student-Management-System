package StudentManagementSystem;

public class Student_Employee extends Student {
    private String employeeType;
    private String job;

    /* getters */
    public String getEmployeeType() {
        return employeeType;
    }

    public String getJob() {
        return job;
    }

    /* setters */
    public void setJob(String job) {
        this.job = job;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }
}

