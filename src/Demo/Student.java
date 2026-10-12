package Demo;

public class Student extends Person {
    private int sid;   //学号
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Student(String name, String sex, int sid, int age, int score) {
        super(name, sex, age);
        setScore(score);
        this.sid = sid;
    }
    @Override
    public void display(){
        System.out.println("学号:"+getSid()+" 姓名:"+getName()+" 性别:"+
                getSex()+" 年龄:"+getAge()+" 分数:"+getScore());
    }
}