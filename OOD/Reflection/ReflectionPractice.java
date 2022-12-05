package OOD.Reflection;

import java.lang.reflect.Field;

public class ReflectionPractice {
    public static void main(String[] args) throws Exception {
        Class stdClass = Student.class;
        // 获取public字段"score":
        System.out.println(stdClass.getField("score"));
        // 获取继承的public字段"name":
        System.out.println(stdClass.getField("name"));
        // 获取private字段"grade":
        System.out.println(stdClass.getDeclaredField("grade"));

        Student student = new Student("XiaoMing");
        Class xiaominClass = student.getClass();
        Field f = xiaominClass.getField("name");
        f.set(student, "XiaoHong");
        Object o = f.get(student);
        System.out.println(o);
        
    }

    static class Student extends Person {
        public int score;
        private int grade;

        public Student(String name) {
            super(name);
        }
    }

    static class Person {
        public String name;

        public Person(String name) {
            this.name = name;
        }
    }
}
