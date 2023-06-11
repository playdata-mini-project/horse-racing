package util;

import controller.HomeController;

public class Back {
    public static void back(){
        HomeController homeController = new HomeController();
        homeController.homeView();
    }
}
