package Demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class StudentView {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Student> studentHashMap = new HashMap<>();

    //start方法用于展示界面以及调用对应功能
    public void start() {
        while (true) {
            System.out.println("========学生信息管理系统v3.1========");
            System.out.println("1.添加学生信息");
            System.out.println("2.修改学生信息");
            System.out.println("3.删除学生信息");
            System.out.println("4.查看学生信息");
            System.out.println("5.按学号查询");
            System.out.println("0.退出程序");
            System.out.println("------------------------------");
            System.out.print("输入栏(0-5): ");
            int n = sc.nextInt();
            switch (n) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    findAllStudents();
                    break;
                case 5:
                    findAllById();
                    break;
                case 0:
                    System.out.println("请您确认是否退出程序?");
                    System.out.println("按6取消 / 按9确认");
                    int key = sc.nextInt();
                    if (key == 9) {
                        System.out.println("-----您已退出程序-----");
                        return;
                    } else if (key == 6) {
                        break;
                    }
            }
        }
    }

    private void addStudent() {
        System.out.println("请输入学生学号:");
        int sid = sc.nextInt();
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生性别:");
        String sex = sc.next();
        System.out.println("请输入学生年龄:");
        int age = sc.nextInt();
        System.out.println("请输入学生分数:");
        int score = sc.nextInt();
        //重复添加判断
        if (studentHashMap.containsKey(sid)) {
            System.out.println("**该学号已存在!**");
            return;
        }
        //将学生信息封装到Student对象当中
        Student student = new Student(name, sex, sid, age, score);
        //将封装好的Student对象放到students数组中
        studentHashMap.put(sid, student);
        System.out.println("添加完成!");
    }

    private void updateStudent() {
        System.out.println("请选择要修改的学生学号");
        int sid = sc.nextInt();
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生性别:");
        String sex = sc.next();
        System.out.println("请输入学生年龄:");
        int age = sc.nextInt();
        System.out.println("请输入学生分数:");
        int score = sc.nextInt();
        //构建新学生对象
        Student student = new Student(name, sex, sid, age, score);
        if (studentHashMap.containsKey(sid)) {
            studentHashMap.put(sid, student);
            System.out.println("修改完成!");
        } else {
            System.out.println("该学号不存在,修改失败!");
        }
    }

    private void deleteStudent() {
        System.out.println("请输入需要删除学生学号:");
        int sid = sc.nextInt();
        if (studentHashMap.containsKey(sid)) {
            studentHashMap.remove(sid);
            System.out.println("删除完成!");
        } else {
            System.out.println("该学号不存在,删除失败!");

        }
    }

    private void findAllStudents() {
        if (studentHashMap.isEmpty()) {
            System.out.println("---系统还未录入学生信息---");
            System.out.println("--请先录入,再查询!--");
        } else {
            ArrayList<Student> list = new ArrayList<>(studentHashMap.values());
            Collections.sort(list, (s1, s2) -> s1.getSid() - s2.getSid());
            System.out.println("---[已录入学生信息]---");
            list.forEach(s -> System.out.println(s));
        }
    }

    private void findAllById(){
        System.out.println("请输入要查询的学生学号：");
        int sid = sc.nextInt();
        if (!studentHashMap.containsKey(sid)) {
            System.out.println("该学号不存在,查询失败!");
        }else {
            System.out.println(studentHashMap.get(sid));
        }
    }
}