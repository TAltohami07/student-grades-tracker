package studenttracker;

import java.util.ArrayList;
import java.util.List;

public class Student {


    private String name;
    private List<Integer>grades;

    public Student(String name){

        this.name= name;
        this.grades= new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addGrades(int grade){
        grades.add(grade);
    }

    public List<Integer> getGrades() {
        return grades;
    }

   public double getAverage() {
        if(grades.isEmpty()) return 0;
        int sum= 0;
        for (int g :grades) sum+=g;
        return (double) sum/grades.size();

   }

    @Override
    public String toString() {
        return name + " - Average: " + String.format("%.2f", getAverage());
    }
}
