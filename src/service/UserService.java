package service;
import domain.dto.insertUserDto;
import repository.UserRepository;
public class UserService {
    public static void insertUser(insertUserDto dto){
        new UserRepository().insertUser(dto);
    }public void findAllUser(){
        new UserRepository().findAllUser();
    }
    public void updateMoney(String name, int money){

        new UserRepository().updateMoney(name,money);
    }
    public void deleteUser(String userName){
        new UserRepository().deleteUser(userName);
    }

}
