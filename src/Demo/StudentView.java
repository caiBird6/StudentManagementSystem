package Demo;

import java.io.IOException;
import java.util.*;

public class StudentView {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Student> studentHashMap = new HashMap<>();
    Tool tool = new Tool(sc);
    StudentStorage storage = new StudentStorage(studentHashMap);
    //start方法用于展示界面以及调用对应功能
    public void start(){
        try {
            storage.load();
        } catch (IOException e) {
            System.out.println("⚠ 存档读取失败,将以空数据启动");
            System.out.println("  原因: " + e.getMessage());
        }
        while (true) {
            System.out.println("========学生信息管理系统v4.0========");
            System.out.println("1.添加学生信息");
            System.out.println("2.修改学生信息");
            System.out.println("3.删除学生信息");
            System.out.println("4.查看学生信息");
            System.out.println("5.按学号查询");
            System.out.println("0.退出程序");
            System.out.println("------------------------------");
            int n = tool.readInt("输入栏(0-5): ");
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
                    findAllStudentById();
                    break;
                case 0:
                    System.out.println("请您确认是否退出程序?");
                    int key = tool.readInt("按6取消 / 按9确认");
                    if (key == 9) {
                        saveQuietly();
                        System.out.println("-----您已退出程序-----");
                        return;
                    } else if (key == 6) {
                        break;
                    }
            }
        }
    }

    private void addStudent(){
        int sid = tool.readInt("请输入学生学号: ");
        //重复添加判断
        if (studentHashMap.containsKey(sid)) {
            System.out.println("**该学号:" + sid + " 已存在!**");
            return;
        }
        System.out.println("请输入学生姓名: ");
        String name = sc.next();
        String sex = tool.readSex("请输入学生性别: ");
        int age = tool.readInt("请输入学生年龄: ");
        int score = tool.readInt("请输入学生分数: ");

        //将学生信息封装到Student对象当中
        Student student = new Student(name, sex, sid, age, score);
        //将封装好的Student对象放到students数组中
        studentHashMap.put(sid, student);
        System.out.println("添加完成!");
        saveQuietly();
    }

    private void updateStudent() {
        int sid = tool.readInt("请选择要修改的学生学号: ");
        if (studentHashMap.containsKey(sid)) {
            System.out.println("请输入学生姓名: ");
            String name = sc.next();
            String sex = tool.readSex("请输入学生性别: ");
            int age = tool.readInt("请输入学生年龄: ");
            int score = tool.readInt("请输入学生分数: ");
            //构建新学生对象
            Student student = new Student(name, sex, sid, age, score);

            studentHashMap.put(sid, student);
            System.out.println("修改完成!");
            saveQuietly();
        } else {
            System.out.println("该学号:" + sid + " 不存在,修改失败!");
        }
    }

    private void deleteStudent() {
        int sid = tool.readInt("请输入需要删除学生学号: ");
        if (studentHashMap.containsKey(sid)) {
            studentHashMap.remove(sid);
            System.out.println("删除完成!");
            saveQuietly();
        } else {
            System.out.println("学号:" + sid + " 不存在,删除失败!");

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

    private void findAllStudentById() {
        int sid = tool.readInt("请输入要查询的学生学号: ");
        if (!studentHashMap.containsKey(sid)) {
            System.out.println("学号:" + sid + " 不存在,查询失败!");
        } else {
            System.out.println(studentHashMap.get(sid));
        }
    }

    private void saveQuietly() {
        try {
            storage.save();
        } catch (IOException e) {
            System.out.println("⚠ 保存失败: " + e.getMessage());
        }
    }
}