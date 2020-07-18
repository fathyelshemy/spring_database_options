package com.database.demo.demo.jdbc;

import com.database.demo.demo.Entities.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.util.ReflectionTestUtils;

import javax.sql.DataSource;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@Import(PersonJDBCDao.class)
class PersonJDBCDaoTest {

    @Mock
    PersonJDBCDao personJDBCDao;

    @Mock
    JdbcTemplate jdbcTemplate;

    @Test
    void findAllPersons() {
        Mockito.when(personJDBCDao.findAllPersons()).thenReturn(Arrays.asList(
                new Person(10001,"Fathy","London",new Date()),
                new Person(10002,"Ahmed","Paris",new Date()),
                new Person(10003,"Jory","Cairo",new Date())
        ));
        List<Person>persons= personJDBCDao.findAllPersons();
        assertEquals(persons.size(),3);
        assertEquals(10001,persons.get(0).getId());
        assertEquals(10002,persons.get(1).getId());
        assertEquals(10003,persons.get(2).getId());

    }

    @Test
    void findById() {
        Mockito.when(personJDBCDao.findById(Mockito.anyLong())).thenReturn(new Person(10001,"fathy","london",new Date()));

        Person person= personJDBCDao.findById(10001);
        assertNotNull(person);
        assertEquals(10001,person.getId());
        assertEquals("fathy",person.getName());
        assertEquals("london",person.getLocation());



    }

    @Test
    void deleteById() {
        Mockito.when(personJDBCDao.DeleteById(Mockito.anyLong())).thenReturn(1);
        assertEquals(personJDBCDao.DeleteById(10001),1);
    }

    @Test
    void insertPerson() {
        Mockito.when(personJDBCDao.insertPerson(Mockito.any())).thenReturn(1);
        assertEquals(personJDBCDao.insertPerson(new Person(10001,"Fathy","London",new Date())),1);
    }
}