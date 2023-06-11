package service;
import domain.dto.InsertUserDto;
import repository.UserRepository;
public class UserService {
    public static void insertUser(InsertUserDto dto){
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
