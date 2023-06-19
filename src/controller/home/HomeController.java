package controller.home;

import controller.horse.HorseController;
import controller.user.UserController;
import controller.game.GameController;
import util.generator.RandomNumberGenerator;
import util.view.HomeViewInput;

public class HomeController {
    public void homeView() {
        HomeViewInput.menu();

        String mode = HomeViewInput.selectMode();

        if (mode.equals("1")) {
            new UserController().userView();
        }

        if (mode.equals("2")) {
            new HorseController();
        }

        if (mode.equals("3")) {
            new GameController(new RandomNumberGenerator()).gameStart();
        }
    }
}
