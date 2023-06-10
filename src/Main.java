import config.JdbcConnection;
import controller.HorseController;
import domain.entity.Game;
import service.HorseService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new HorseController().HorseView();
    }
}