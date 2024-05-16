import java.util.*;

public class CourseReg {
    private Map<String, Student> students;
    private List<Course> courses;

    public CourseReg() {
        this.students = new HashMap<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(String studentId, String name) {
        students.put(studentId, new Student(studentId, name));
        System.out.println("Student added successfully!");
    }

    public void addCourse(String courseId, String courseName, int maxStudents) {
        courses.add(new Course(courseId, courseName, maxStudents));
        System.out.println("Course added successfully!");
    }

    public void displayCourses() {
        System.out.println("Courses available:");
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    public void registerStudent(String studentId, String courseId) {
        Student student = students.get(studentId);
        Course course = getCourseById(courseId);

        if (student != null && course != null) {
            if (course.registerStudent(student)) {
                System.out.println("Student " + student.getName() + " registered for course " + course.getCourseName());
            } else {
                System.out.println("Course is full. Cannot register student " + student.getName());
            }
        } else {
            System.out.println("Invalid student ID or course ID.");
        }
    }

    private Course getCourseById(String courseId) {
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CourseReg registrationSystem = new CourseReg();
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n1. Add Student");
                System.out.println("2. Add Course");
                System.out.println("3. Display Courses");
                System.out.println("4. Register Student for Course");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();
                sc.nextLine(); 

                switch (choice) {
                    case 1:
                        System.out.print("Enter student ID: ");
                        String studentId = sc.nextLine();
                        System.out.print("Enter student name: ");
                        String studentName = sc.nextLine();
                        registrationSystem.addStudent(studentId, studentName);
                        break;
                    case 2:
                        System.out.print("Enter course ID: ");
                        String courseId = sc.nextLine();
                        System.out.print("Enter course name: ");
                        String courseName = sc.nextLine();
                        System.out.print("Enter maximum students for the course: ");
                        int maxStudents = sc.nextInt();
                        registrationSystem.addCourse(courseId, courseName, maxStudents);
                        break;
                    case 3:
                        registrationSystem.displayCourses();
                        break;
                    case 4:
                        System.out.print("Enter student ID: ");
                        String regStudentId = sc.nextLine();
                        System.out.print("Enter course ID: ");
                        String regCourseId = sc.nextLine();
                        registrationSystem.registerStudent(regStudentId, regCourseId);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Try again.");
                        break;
                }
            }
        }
    }
}

class Student {
    private String studentId;
    private String name;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String courseId;
    private String courseName;
    private int maxStudents;
    private List<Student> enrolledStudents;

    public Course(String courseId, String courseName, int maxStudents) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.maxStudents = maxStudents;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public boolean registerStudent(Student student) {
        if (enrolledStudents.size() < maxStudents) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Course Name: " + courseName +
                ", Enrolled Students: " + enrolledStudents.size() + "/" + maxStudents;
    }
}