package service.game;

import config.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class gameService {
    public void insertWinner(List<String> winningUsers, List<String> winnerHorseNames){
        Connection conn = new JdbcConnection().getConnection();
        String sql = "insert into gameresult(winUser, winHorse) " +
                "values(?, ?)";
        for (int i = 0; i < winnerHorseNames.size(); i++) {
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1,winningUsers.get(i) );
                pst.setString(2, winnerHorseNames.get(i));
                pst.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
