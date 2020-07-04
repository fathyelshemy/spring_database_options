package com.database.demo.demo.jdbc;

import com.database.demo.demo.Entities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonJDBCDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class PersonRowMapper implements RowMapper<Person>{

        @Override
        public Person mapRow(ResultSet resultSet, int i) throws SQLException {
            Person person = new Person();
            person.setId(resultSet.getLong("id"));
            person.setName(resultSet.getString("name"));
            person.setBirthDate(resultSet.getDate("birth_date"));
            person.setLocation(resultSet.getString("location"));
            return person;
        }
    }

    public List<Person> findAllPersons(){
        return jdbcTemplate.query("SELECT * FROM PERSON",new PersonRowMapper());
    }

    public Person findById(long id){
        return jdbcTemplate.queryForObject("SELECT * FROM PERSON WHERE ID=?"
                ,new Object[]{id}
                ,new PersonRowMapper());
    }

    public int DeleteById(long id){
        return jdbcTemplate.update("DELETE FROM PERSON WHERE PERSON.id=?",new Object[]{id});
    }

    public int insertPerson(Person person){
        return jdbcTemplate.update("INSERT INTO PERSON (ID, NAME, LOCATION, BIRTH_DATE ) VALUES(?,  ?, ?,?);"
                ,new Object[]{
                        person.getId(),
                        person.getName(),
                        person.getLocation(),
                        person.getBirthDate()
        });
    }

}
