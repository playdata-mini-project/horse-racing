package controller.user;

import service.User.UserService;
import util.Back;
import util.view.UserViewInput;

public class UserController {
    public void userView(){
        UserViewInput.menu();

    String mode = UserViewInput.selectMode();

        if (mode.equals("1")) {
            new UserService().findAllUser();
    }

        if (mode.equals("2")) {

    }
        if(mode.equals("3")){
            Back.back();
        }

    }
}
