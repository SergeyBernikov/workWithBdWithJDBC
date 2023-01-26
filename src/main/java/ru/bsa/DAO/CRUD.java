package ru.bsa.DAO;

import java.sql.SQLException;
import java.util.List;
public interface CRUD <T> {
    void createPerson(T t) throws SQLException;
    List<T> showPersons() throws SQLException;
    void removePerson(Long id) throws SQLException;
}
