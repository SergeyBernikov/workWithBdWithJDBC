package ru.bsa.service;

import org.springframework.stereotype.Service;
import ru.bsa.DAO.CRUD;
import ru.bsa.models.Person;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Service                                                               // spring создаст бин этого класса и данный бин будет внедрен в контроллер
public class PersonMethods implements CRUD <Person> {                  // класс с методами для работы с пользователями (клиентами)
    private final Connection connection;                                                    // установка соединения с БД
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/person",
                    "root",
                    "root"
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void createPerson(Person person) throws SQLException {                                          // добавить пользователя (клиента) в БД person
        PreparedStatement preparedStatement = connection.prepareStatement("insert into person (id,  name, email) values (?,?,?)");
        preparedStatement.setLong(1, person.getId());
        preparedStatement.setString(2, person.getName());
        preparedStatement.setString(3, person.getEmail());
        preparedStatement.executeUpdate();
    }
    @Override
    public List<Person> showPersons() throws SQLException {                                          // показать всех пользователей (клиентов) в БД person
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM person");
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Person> personInBD = new ArrayList<>();

        Long id;
        String email;
        String name;

        while (resultSet.next()) {
            id = resultSet.getLong("id");
            name = resultSet.getString("name");
            email = resultSet.getString("email");

            Person person = new Person(id,name,email);
            personInBD.add(person);
        }
        return personInBD;
    }
    @Override
    public void removePerson(Long id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM person WHERE id=?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }
}

