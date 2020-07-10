package com.database.demo.demo;

import com.database.demo.demo.Entities.Client;
import com.database.demo.demo.Entities.Person;
import com.database.demo.demo.Entities.User;
import com.database.demo.demo.config.aspect.TraceTime;
import com.database.demo.demo.jdbc.PersonJDBCDao;
import com.database.demo.demo.jpa.hibernate.UserJPADao;
import com.database.demo.demo.jpa.springjpa.ClientDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

    private static Logger logger= LoggerFactory.getLogger(DatabaseDemoApplication.class);

    @Autowired
    private PersonJDBCDao personJDBCDao;
    @Autowired
    private UserJPADao userJPADao;
    @Autowired
    private ClientDao clientDao;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("========================jdbc example==============================");
        jdbcExample();
        logger.info("-------------------------------------------------------------------");
        logger.info("-------------------------------------------------------------------");
        logger.info("-------------------------------------------------------------------");

        logger.info("========================jpa example==============================");
        jpaExample();

        logger.info("-------------------------------------------------------------------");
        logger.info("-------------------------------------------------------------------");
        logger.info("-------------------------------------------------------------------");

        logger.info("========================spring jpa example==============================");

        springJpaExample();
    }

    @TraceTime
     void jdbcExample(){
        Person person10004 = new Person(10004, "fathy", "london", new Date());
        personJDBCDao.insertPerson(person10004);
        logger.info("==============================insert============");
        logger.info("save new person with the following data {} ",person10004.toString());

        logger.info("==================find all======================");
        List<Person> persons=personJDBCDao.findAllPersons();
        logger.info("Persons -> {}", persons.toString());

        logger.info("========================find by ID====================");
        Person person = personJDBCDao.findById(10001);
        logger.info("person 1001 data is => {} ",person.toString());

        logger.info("======================delete==================");
        logger.info("Deleting person number 1002 number of deleted row is => {} ",personJDBCDao.DeleteById(10002));
    }
    @TraceTime
     void jpaExample(){
         User user10004 = new User(10004, "fathy", "london", new Date());
         userJPADao.saveUser(user10004);
         logger.info("==============================insert============");
         logger.info("save new person with the following data {} ",user10004.toString());

         logger.info("========================find by ID====================");
         User user = userJPADao.findById(10001);
         logger.info("person 1001 data is => {} ",user.toString());

         logger.info("======================delete==================");
         userJPADao.deleteUserById(10002);
         logger.info("==================find all======================");
         List<User> users=userJPADao.findAllUsers();
         logger.info("Persons -> {}", users.toString());

     }

     void springJpaExample(){
         Client client10004 = new Client(10004, "fathy", "london", new Date());
         clientDao.save(client10004);
         logger.info("==============================insert============");
         logger.info("save new person with the following data {} ",client10004.toString());

         logger.info("========================find by ID====================");
         Optional<Client> client10001 = clientDao.findById((long)10001);
         logger.info("person 1001 data is => {} ",client10001.toString());

         logger.info("======================delete==================");
         clientDao.deleteById((long)10002);
         logger.info("==================find all======================");
         List<Client> clients=clientDao.findAll();
         logger.info("Persons -> {}", clients.toString());

     }

}
