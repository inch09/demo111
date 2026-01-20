package samostoyatelnaya;

public class Student {
    private long id;
    private String fullName;
    private int grade;
    private String email;
    private boolean active;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Student(long id, String fullName, int grade, String email, boolean active) {
        this.id = id;
        this.fullName = fullName;
        this.grade = grade;
        this.email = email;
        this.active = active;
    }
}
