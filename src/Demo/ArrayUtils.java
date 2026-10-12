package Demo;

public class ArrayUtils {
    public ArrayUtils() {
    }

    public static int findIndexById(Student[] students,int sid,int count){
        for (int i = 0; i < count; i++) {
            if (students[i].getSid() == sid){
                return i;
            }
        }
        return -1;
    }
}
