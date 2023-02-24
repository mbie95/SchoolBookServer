package Project1.model.Subject;

import Project1.model.Person.Teacher.Teacher;

/**
 *
 * @author marcin
 */
public class Subject {
    private int id;
    private String name;
    private Teacher teacher;
    
    private static int counter;
    
    Subject(){
        this.id = counter++;
    }
    Subject(String name, Teacher teacher){
        this.name = name;
        this.teacher = teacher;
        this.id = counter++;
    }
    
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public Teacher getTeacher(){
        return teacher;
    }
    
    public void setName(String name){
        this.name = name;
    }
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if(this.name == ((Subject)obj).name && this.teacher.equals(((Subject)obj).teacher))
            return true;
        return false;
    }
}
