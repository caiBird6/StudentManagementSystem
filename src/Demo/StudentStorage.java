package Demo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentStorage {
    //构造方法注入
    private HashMap<Integer,Student> students;

    public StudentStorage(HashMap<Integer, Student> students) {
        this.students = students;
    }

    public void load()throws IOException {
        File file = new File("students.txt");
        if (!file.exists()){
            return;
        }
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null){
            //用,拆分
            String[] parts = line.split(",");
            //检查长度
            if (parts.length != 5) {
                continue;
            }

            int sid = Integer.parseInt(parts[0]);
            String name = parts[1];
            String sex = parts[2];
            int age = Integer.parseInt(parts[3]);
            int score = Integer.parseInt(parts[4]);
            //将学生信息封装到Student对象当中
            Student student = new Student(name,sex,sid,age,score);
            students.put(sid,student);
        }
        br.close();
    }

    public void save()throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"));
        for (Student s : students.values()){
            bw.write(s.getSid() + "," + s.getName() + "," + s.getSex()
                    + "," + s.getAge() + "," + s.getScore());
            bw.newLine();
        }
        bw.close();
    }
}