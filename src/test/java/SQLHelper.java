import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private static QueryRunner runner = new QueryRunner();

    private SQLHelper() {}

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/TravelShopDB", "TravelShop", "BuyTour");
            }

    public static String returnStatusOfTransaction() {
        var codeSQL = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
               try (var conn = getConn()) {
                    var status = runner.query(conn, codeSQL, new ScalarHandler<>());
                    return String.valueOf(status);

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    public static void cleanDataBase() {
        var connection = getConn();
        runner.update(connection, "DELETE FROM order_entity");
        runner.update(connection, "DELETE FROM payment_entity");
        runner.update(connection, "DELETE FROM credit_request_entity");
    }
}
