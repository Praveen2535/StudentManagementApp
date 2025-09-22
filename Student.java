public class Student{
    private int id;
    private String name;
    private String grade;

    public Student(int id, String name, String grade){
        this.name=name;
        this.id=id;
        this.grade=grade;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getGrade(){
        return grade;
    }
    public String toString(){
        return "ID:"+id+"  Name:"+name+"  Grade:"+grade;
    }
}