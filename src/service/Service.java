package service;

public class Service {
    public void update(int id){
        // dto id name rank injury
        // 1. repo 에서 select * from table where id = id;
        // -> entity
//        2. entity -> dto
//        내가 바꿀것만 setter
//        update table set name = ? where id =id
//        3. update table set name =? , rank =? , injury=? where id =id
    }
}
