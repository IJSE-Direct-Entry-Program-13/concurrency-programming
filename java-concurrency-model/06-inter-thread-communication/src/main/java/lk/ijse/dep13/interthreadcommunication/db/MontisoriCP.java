package lk.ijse.dep13.interthreadcommunication.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

public class MontisoriCP {
    private static final int DEFAULT_POOL_SIZE = 4;

    private final HashMap<Integer, Connection> MAIN_POOL = new HashMap<>();
    private final HashMap<Integer, Connection> CONSUMER_POOL = new HashMap<>();
    private final int poolSize;

    public MontisoriCP() {
        this(DEFAULT_POOL_SIZE);
    }

    public MontisoriCP(int poolSize) {
        this.poolSize = poolSize;
        try {
            initializePool();
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getPoolSize() {
        return poolSize;
    }

    private void initializePool() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(getClass().getResourceAsStream("/application.properties"));

        String host = properties.getProperty("app.db.host");
        String port = properties.getProperty("app.db.port");
        String database = properties.getProperty("app.db.database");
        String user = properties.getProperty("app.db.user");
        String password = properties.getProperty("app.db.password");

        for (int i = 0; i < poolSize; i++) {
            Connection connection = DriverManager.getConnection("jdbc:mysql://%s:%s/%s"
                    .formatted(host, port, database), user, password);
            MAIN_POOL.put((i + 1) * 10, connection);
        }
    }

    public ConnectionWrapper getConnection() {
        if (!MAIN_POOL.isEmpty()) {
            Integer key = MAIN_POOL.keySet().stream().findFirst().get();
            Connection connection = MAIN_POOL.get(key);
            MAIN_POOL.remove(key);
            CONSUMER_POOL.put(key, connection);
            return new ConnectionWrapper(key, connection);
        } else {
            throw new RuntimeException("No Connections Available");
        }
    }

    public void releaseConnection(Integer id){
        if (!CONSUMER_POOL.containsKey(id)) throw new RuntimeException("Invalid Connection ID");
        Connection connection = CONSUMER_POOL.get(id);
        CONSUMER_POOL.remove(id);
        MAIN_POOL.put(id, connection);
    }

    public void releaseAllConnections(){
        CONSUMER_POOL.forEach(MAIN_POOL::put);
        CONSUMER_POOL.clear();
    }

    public record ConnectionWrapper(Integer id, Connection connection) {
    }
}
