import java.util.ArrayList;
import java.util.List;

/**
 * @author jinhaodong
 * @date 2024/8/29 17:54
 */
public class MainTest {

    public static void main(String[] args) {
        int[] candies = {4,2,1,1,2};
        int extraCandies = 1;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        // 找到max
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) {
            if (candies[i] > max){
                max = candies[i];
            }
        }
        // 增加额外糖果，比对
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }//end method

}
