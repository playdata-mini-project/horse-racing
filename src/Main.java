import config.JdbcConnection;
import controller.HomeController;
import controller.HorseController;
import controller.UserController;
import domain.entity.Game;
import repository.UserRepository;
import service.HorseService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new HomeController().homeView();
    }
}