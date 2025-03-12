import java.sql.Connection;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Demo4 {

    public static void main(String[] args) {
        ConcurrentHashMap<UUID, String> MAIN_POOL = new ConcurrentHashMap<>();
        MAIN_POOL.put(UUID.randomUUID(), "abc");
        MAIN_POOL.keySet().forEach(uuid -> {
            System.out.println(uuid);
        });
    }
}
