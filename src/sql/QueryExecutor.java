package sql;

import config.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QueryExecutor {

    private Connection connection;

    private boolean checkConnection() throws SQLException {
        return connection == null || connection.isClosed();
    }

    public ResultSet execute(String query) throws SQLException {
        if (checkConnection()) {
            connection = JdbcConnection.getConnection();
        }

        PreparedStatement psmt = connection.prepareStatement(query);

        return psmt.executeQuery();
    }

    public void execute(String query, SQLConsumer<ResultSet> consumer) throws SQLException {
        ResultSet resultSet = execute(query);

        consumer.accept(resultSet);

        resultSet.close();
        resultSet.getStatement().close();
        connection.close();
    }

    public int insertOrUpdate(String query) throws SQLException {
        if (checkConnection()) {
            connection = JdbcConnection.getConnection();
        }

        PreparedStatement psmt = connection.prepareStatement(query);

        int i = psmt.executeUpdate();

        psmt.close();

        return i;
    }
}

