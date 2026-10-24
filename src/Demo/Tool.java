package Demo;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Tool {
    //构造方法注入
    private Scanner sc;
    public Tool(Scanner sc) {
        this.sc = sc;
    }

    public int readInt(String prompt) {
        // 提示用户输入
        // 循环读，读到数字就返回；读到非法就提示重来
        while (true){
            System.out.println(prompt);
            try {
                return sc.nextInt();
            }catch (InputMismatchException e){
                System.out.println("====================");
                System.out.println("💀输入错误,请输入数字!");
                System.out.println("====================");
                sc.next();
            }
        }
    }
    public String readSex(String prompt){
        while (true){
            System.out.println(prompt);
            String sex = sc.next();
            if ("男".equals(sex) || "女".equals(sex)) {
                return sex;
            }else {
                System.out.println("====================");
                System.out.println("💀性别只能是【男】或【女】，请重新输入!");
                System.out.println("====================");
            }
        }
    }

}
