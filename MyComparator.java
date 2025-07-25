import java.util.*;


//class StudentComparator implements Comparator<Student>{
//
//    //First Way
//    @Override
//    public int compare(Student o1, Student o2) {
//        if (o1.age==o2.age){
//            return o1.name.compareTo(o2.name);
//        }
//        return o1.age-o2.age;
//    }
//}


public class MyComparator{
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(15,"XYZ",15));
        students.add(new Student(16,"Abc",15));
        students.add(new Student(17,"mnb",16));
        students.add(new Student(18,"jkl",11));
        for(Student student : students){
            System.out.println(student);
        }
//      First Way  Collections.sort(students, new StudentComparator());

//      Second Way  Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.getId() - o1.getId();
//            }
//        });

//      Third Way  Collections.sort(students, (a,b)-> a.getName().compareTo(b.getName()));

        Collections.sort(students,
                Comparator.comparing(Student::getAge)
                        .thenComparing(Student::getId)
                        .reversed());

        for(Student student : students){
            System.out.println(student);
        }
    }
}
class Student{
    int id;
    String name;
    int age;
    public Student(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public String toString(){
        return "ID: "+id + " Name: " + name + " Age: " + age;
    }
}
