package Demo;

public class Student {
    private int sid;   //学号
    private String name;
    private String sex;   //性别
    private int age;
    private int score;

    public Student() {
    }

    public Student(String name, int sid, String sex, int age, int score) {
        this.name = name;
        this.sid = sid;
        this.sex = sex;
        setAge(age);
        setScore(score);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age>0 && age<120) {
            this.age = age;
        }else {
            System.out.println("年龄不合法!");
        }
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if (score>0) {
            this.score = score;
        }else {
            System.out.println("分数不合法!");
        }
    }
}

