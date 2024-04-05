import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        TreeSet<Alpha> set = new TreeSet<Alpha>(new Comparator<Alpha>(){

            @Override
            public int compare(Alpha o1, Alpha o2) {
                return 0;
            }
        });

    }


}

class Alpha{
    char c;
    int t;
    Alpha(char cc , int tt){
        c = cc;
        t = tt;
    }
}