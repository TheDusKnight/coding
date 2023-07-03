package OOD.MyHashMap;

import java.util.HashMap;

// 通过改写hashcode实现map student去重，id一样的student就是同一个student
public class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student that = (Student) obj;
            return this.id == that.id;
        }

        return false;
    }

    public static void main(String[] args) {
        Student s1 = new Student(233, "Tom");
        Student s2 = new Student(666, "Jerry");
        Student s3 = new Student(233, "Tom");

        HashMap<Student, String> map = new HashMap<>();
        map.put(s1, "s1");
        map.put(s2, "s2");
        map.put(s3, "s3");

        System.out.println(map.get(s1));
    }
}
