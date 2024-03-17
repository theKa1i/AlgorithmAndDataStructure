package LCR;

import java.util.Stack;

public class LCR_037 {
    public static int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length < 1) return new int[]{};
        Stack<Integer> s = new Stack<>();
        for (int i:asteroids){
            boolean alive = true;
            while (alive && i < 0 && !s.empty() && s.peek() > 0){
                alive = s.peek() < -i;
                if (s.peek() <= -i) s.pop();
            }
            if (alive) s.push(i);
        }
        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0 ; i--) {
            res[i] = s.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        asteroidCollision(new int[]{-2,-2,1,-2});
    }
}
