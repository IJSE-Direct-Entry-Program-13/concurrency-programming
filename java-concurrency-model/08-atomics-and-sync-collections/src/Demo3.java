import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Demo3 {

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(20);
        nums.add(30);
        nums.add(40);

        List<Integer> threadSafeList = Collections.synchronizedList(nums);

        CopyOnWriteArrayList<Integer> superThreadSafeList =
                new CopyOnWriteArrayList<>();

        CopyOnWriteArraySet<Integer> superThreadSafeSet =
                new CopyOnWriteArraySet<>();

        ConcurrentHashMap<String, String> superThreadSafeMap =
                new ConcurrentHashMap<>();
    }
}
