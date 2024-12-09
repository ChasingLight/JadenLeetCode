import java.util.ArrayList;
import java.util.List;

/**
 * @author jinhaodong
 * @date 2024/12/9 14:18
 */
public class StockSpanner {

    List<Integer> priceList;

    public StockSpanner() {
        priceList = new ArrayList<>();
    }

    public int next(int price) {
        priceList.add(price);
        // 计算 当日价格 的跨度
        int res = 0;
        int n = priceList.size();
        boolean flag = true;
        for (int i = n-1; i >= 0; i--) {
            if (flag && priceList.get(i) <= price) {
                res++;
            }else{
                flag = false;
            }
        }
        return res;
    }//end method
}
