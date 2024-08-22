package StudentInformationSystem;

public class EnrollmentManager {
    public void enrollStudentInCourse(Student student, Course course) {
        student.enrollInCourse(course);
        course.enrollStudent(student);
    }
}

