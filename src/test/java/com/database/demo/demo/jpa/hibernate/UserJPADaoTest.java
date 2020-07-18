package com.database.demo.demo.jpa.hibernate;

import com.database.demo.demo.Entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.annotation.Import;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Import(UserJPADao.class)
class UserJPADaoTest {

    @Mock
    UserJPADao userJPADao;

    @Test
    void findById() {
        Mockito.when(userJPADao.findById(10001)).thenReturn(new User(10001,"Fathy","London",new Date()));
        assertNotNull(userJPADao.findById(10001));
    }

    @Test
    void findAllUsers() {
        Mockito.when(userJPADao.findAllUsers()).thenReturn(Arrays.asList(
                new User(10001,"Fathy","London",new Date()),
                new User(10002,"Ahmed","Paris",new Date()),
                new User(10003,"Jory","Cairo",new Date())
        ));
        assertEquals(userJPADao.findAllUsers().size(),3);
        assertEquals(10001,userJPADao.findAllUsers().get(0).getId());
        assertEquals(10002,userJPADao.findAllUsers().get(1).getId());
        assertEquals(10003,userJPADao.findAllUsers().get(2).getId());
    }

    @Test
    void saveUser() {
        Mockito.when(userJPADao.saveUser(Mockito.any())).thenReturn(new User(10001,"Fathy","London",new Date()));

        assertNotNull(userJPADao.saveUser(new User(10001,"Fathy","London",new Date())));
    }

}