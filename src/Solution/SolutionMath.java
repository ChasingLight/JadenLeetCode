package Solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by JadenOliver on 2017/12/28.
 */
public class SolutionMath {

    /**
     * 快乐数
     * @param n
     * @return
     */
    public static boolean isHappy(int n) {

        //特殊情况处理
        if(n <= 0){
            return false;
        }

        List<Integer> list = new ArrayList<>();
        while(n != 1){
            list.add(n);

            n = calculateNewN(n);
            if(list.contains(n)) return false; //end loop
        }

        return true;
    }

    public static int calculateNewN(int n){
        int newN = 0;
        while(n > 0){
            newN += Math.pow(n % 10, 2);
            n = n / 10;
        }

        return newN;
    }

}
