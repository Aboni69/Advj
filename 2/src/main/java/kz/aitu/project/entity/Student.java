package kz.aitu.project.entity;

public class Student {
    public int id;
    public String name;
    public int group_id;
    public String phone;

    public  Student (int id, String name, int group_id,String phone){
        this.id = id;
        this.name = name;
        this.group_id = group_id;
        this.phone = phone;
    }
    public String toString(){
        return this.id + " " + this.name + " " + this.phone + " " + this.group_id;
    }
}
