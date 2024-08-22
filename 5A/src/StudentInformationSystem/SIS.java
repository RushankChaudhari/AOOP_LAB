package StudentInformationSystem;

public class SIS {
    private EnrollmentManager enrollmentManager;

    public SIS(EnrollmentManager enrollmentManager) {
        this.enrollmentManager = enrollmentManager;
    }

    public void enrollStudentInCourse(Student student, Course course) {
        enrollmentManager.enrollStudentInCourse(student, course);
    }
}

