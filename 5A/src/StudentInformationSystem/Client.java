package StudentInformationSystem;

public class Client {
    public static void main(String[] args) {
        Student student1 = new Student("Rushank", "S001");
        Student student2 = new GraduateStudent("Mohit", "S002");

        Course course1 = new Course("C001", "Mathematics");
        Course course2 = new Course("C002", "Physics");

        EnrollmentManager enrollmentManager = new EnrollmentManager();
        SIS sis = new SIS(enrollmentManager);

        sis.enrollStudentInCourse(student1, course1);
        sis.enrollStudentInCourse(student2, course2);

        System.out.println(student1.getName() + " enrolled in: " + student1.getCourses().get(0).getCourseName());
        System.out.println(student2.getName() + " enrolled in: " + student2.getCourses().get(0).getCourseName());
    }
}

