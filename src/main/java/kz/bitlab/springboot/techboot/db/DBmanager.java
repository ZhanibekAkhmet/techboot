package kz.bitlab.springboot.techboot.db;

import java.util.ArrayList;

public class DBmanager {
   private static final ArrayList<Items>items=new ArrayList<>();
   private static Long id = 7L;
  static {
      items.add(new Items(1L,"Mac Book PRO","8gb",1199.99));
      items.add(new Items(2L,"Mac Book PRO","9gb",1191.99));
      items.add(new Items(3L,"Mac Book PRO","10gb",1192.99));
      items.add(new Items(4L,"Mac Book PRO","11gb",1193.99));
      items.add(new Items(5L,"Mac Book PRO","12gb",1194.99));
      items.add(new Items(6L,"Mac Book PRO","13gb",1195.99));
  }
  public static ArrayList<Items> getItems(){
      return items;
  }
  public static void addItem(Items item){
      item.setId(id);
      id++;
      items.add(item);
  }
  public static Items getItem(long id){
      for(Items item:items){
          if(item.getId()==id){
              return item;
          }
      }
      return null;
  }
  private static final ArrayList<Student> students = new ArrayList<>();
  static {
      students.add(new Student(1L,"Ilias","Zhuanishev",99,"A"));
      students.add(new Student(2L,"Kuanish","Berikov",78,"B"));
      students.add(new Student(3L,"Berik","Serikov",66,"C"));
      students.add(new Student(4L,"Serik","Berikov",55,"D"));
      students.add(new Student(5L,"Ermek","Aityshev",45,"F"));
  }
  public static ArrayList<Student> getStudents(){
      return students;
  }
    public static void addStudent(Student student){
        student.setId(id);
        id++;
        if(student.getExam()>90&&student.getExam()<=100){
            student.setMark("A");
        } else if (student.getExam()<90&&student.getExam()>74) {
            student.setMark("B");
        } else if (student.getExam()<75&&student.getExam()>59) {
            student.setMark("C");
        }else if (student.getExam()<60&&student.getExam()>49){
            student.setMark("D");
        }else if(student.getExam()<50&&student.getExam()>=0) {
            student.setMark("F");
        }else student.setMark("Не правильная оценка");
        students.add(student);
    }
}
