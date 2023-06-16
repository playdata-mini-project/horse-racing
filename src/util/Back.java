package util;

import controller.home.HomeController;

public class Back {
    public static void back(){
        HomeController homeController = new HomeController();
        homeController.homeView();
    }
}
