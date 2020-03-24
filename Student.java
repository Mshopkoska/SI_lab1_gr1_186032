import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Student {
    String index;
    String firstName;
    String lastName;
    ArrayList<Integer> labPoints;

    public Student(String index, String firstName, String lastName, ArrayList<Integer> labPoints) {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        this.labPoints = labPoints;
    }

    public String getIndex() {
        return index;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public ArrayList<Integer> getLabPoints() {
        return labPoints;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLabPoints(ArrayList<Integer> labPoints) {
        this.labPoints = labPoints;
    }

    public double getAverage() {
        int sum = labPoints.stream().mapToInt(Integer::intValue).sum();
        return (double) sum / labPoints.size();
    }

    public boolean hasSignature() {
        return labPoints.size() >= 8;
    }
}

class Course {
    List<Student> students;

    public Course() {
        this.students = new LinkedList<>();
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public int getSignatureCount() {
        int count = 0;
        for (Student s : students) {
            if (s.hasSignature())
                count++;
        }
        return count;
    }

    public double getAvgLabPoints() {
        double sum = 0.0;
        for (Student s : students) {
            sum += s.getAverage();
        }
        return (double) sum / students.size();
    }
}