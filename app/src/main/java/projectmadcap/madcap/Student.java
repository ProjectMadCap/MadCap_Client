package projectmadcap.madcap;

public class Student {
    private String studentName;
    private String id;

    public Student(String stuName, String id) {
        this.studentName = stuName;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
