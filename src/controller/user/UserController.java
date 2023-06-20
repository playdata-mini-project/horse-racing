package controller.user;

import service.user.UserService;
import util.Back;
import util.view.UserViewInput;

public class UserController {
    public void userView(){
        UserViewInput.menu();

    String mode = UserViewInput.selectMode();

        if (mode.equals("1")) {
            new UserService().insertUser();
    }

        if (mode.equals("2")) {
            new UserService().findAllUser();

    }
        if(mode.equals("3")){
            new UserService().updateUserMoney();
        }
        if(mode.equals("4")){
            Back.back();
        }

    }
}
