package Demo;

import java.util.Scanner;

public class StudentView { //界面
    Scanner sc = new Scanner(System.in);
    Student[] students = new Student[50];
    //定义一个变量,记录数组对象,用于遍历,避免空指针
    int count = 0;
    //start方法用于展示界面以及调用对应功能
    public void start() {
        while (true) {
            System.out.println("========学生信息管理系统v1.0========");
            System.out.println("1.添加学生信息");
            System.out.println("2.修改学生信息");
            System.out.println("3.删除学生信息");
            System.out.println("4.查看学生信息");
            System.out.println("0.退出程序");
            System.out.println("------------------------------");
            System.out.print("输入栏(0-4): ");
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
                    findAllStudent();
                    break;
                case 0:
                    System.out.println("请您确认是否退出程序?");
                    System.out.println("按5取消 / 按9确认");
                    int key = sc.nextInt();
                    if (key == 9) {
                        System.out.println("-----您已退出程序-----");
                        return;
                    }else if (key == 5){
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
        //将学生信息封装到Student对象当中
        Student student = new Student(name, sex, sid, age, score);
        //将封装好的Student对象放到students数组中
        students[count] = student;
        count++;
        System.out.println("添加完成!");
    }

    private void updateStudent() {
        System.out.println("请选择要修改的学生学号");
        int sid = sc.nextInt();
        //根据id查询对应的学生在数组中的索引位置
        int updateIndex = ArrayUtils.findIndexById(students, sid, count);
        if (updateIndex == -1){
            System.out.println("该学生不存在");
            return;
        }
        System.out.println("请输入学生姓名:");
        String name = sc.next();
        System.out.println("请输入学生性别:");
        String sex = sc.next();
        System.out.println("请输入学生年龄:");
        int age = sc.nextInt();
        System.out.println("请输入学生分数:");
        int score = sc.nextInt();
        Student student = new Student(name, sex, sid, age, score);
        students[updateIndex] = student;
        System.out.println("修改完成!");
    }

    private void deleteStudent() {
        System.out.println("请输入需要删除学生学号:");
        int sid = sc.nextInt();
        int removeIndex = ArrayUtils.findIndexById(students, sid, count);
        if (removeIndex == -1){
            System.out.println("该学生不存在!");
            return;
        }
        //定义新数组,存老数组执行删除后剩下的元素
        Student[] newstudents = new Student[count - 1];
        //复制被删除元素前面一部分
        for (int i = 0; i < removeIndex; i++) {
            newstudents[i] = students[i];
        }
        //复制被删除元素后面一部分
        for (int i = removeIndex; i < count - 1; i++) {
            newstudents[i] = students[i + 1];
        }

        students = newstudents;
        count--;
        System.out.println("删除完成!");
    }

    private void findAllStudent() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - 1 - i; j++) {
                if (students[j].getSid() > students[j + 1].getSid()) {
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
        if (count == 0) {
            System.out.println("---系统还未录入学生信息---");
            System.out.println("--请先录入,再查询!--");
        } else {
            System.out.println("---[已录入学生信息]---");
            for (int i = 0; i < count; i++) {
                students[i].display();
            }
        }
    }
}