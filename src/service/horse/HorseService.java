package service.horse;

import config.jdbc.JdbcConnection;
import domain.dto.horse.FindAllHorse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HorseService {
    public void findAllHorse() {
        List<FindAllHorse> findAllHorses = new ArrayList<>();
        String sql = "select * from horse";
        Connection conn = new JdbcConnection().getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                findAllHorses.add(new FindAllHorse(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getFloat("height"),
                        resultSet.getFloat("weight"),
                        resultSet.getFloat("winRate")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (FindAllHorse findAllHorse : findAllHorses)
            System.out.println(findAllHorses);
    }
}
