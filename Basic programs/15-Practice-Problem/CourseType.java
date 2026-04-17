import java.util.*;

abstract class CourseType {}
class ExamCourse extends CourseType {}
class AssignmentCourse extends CourseType {}
class ResearchCourse extends CourseType {}

class Course<T extends CourseType> {
    T type;
    Course(T type){this.type=type;}
}

public class Q14 {
    static void show(List<? extends CourseType> list){
        for(CourseType c:list)
            System.out.println(c.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        show(Arrays.asList(new ExamCourse(), new ResearchCourse()));
    }
}