package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import dao.RideSharingDao;
import main.entity.User;
import service.UserService;
import service.UserServiceImpl;

public class UserServiceTest {

    User user1, user2,user3;
    RideSharingDao rideSharingDao;

    @Before
    public void createUser(){
        rideSharingDao = RideSharingDao.getInstance();
        user1 = new User("Rohan", "M", 36);
        user2 = new User("Shashank", "M", 29);
        user3 = new User("Nandini", "M", 29);
    }

    @Test
    public void registerUserTest(){
        UserService userService = new UserServiceImpl();
        createUser();
        userService.registerUser(user1);
        User actualUser = rideSharingDao.getUserDetails(user1.getName());
        assertEquals(user1.getName(), actualUser.getName());
        assertEquals(user1.getAge(), actualUser.getAge());
        assertEquals(user1.getGender(), actualUser.getGender());
    }
    
}
