package controller.horse;


import service.horse.HorseService;
import util.Back;
import util.view.HorseViewInput;


public class HorseController {
    public void horseView(){
        HorseViewInput.menu();

        String mode = HorseViewInput.selectMode();

        if (mode.equals("1")) {
            new HorseService().findAllHorse();
        }

        if (mode.equals("2")) {

        }
        if(mode.equals("3")){
            Back.back();
        }

    }
}
