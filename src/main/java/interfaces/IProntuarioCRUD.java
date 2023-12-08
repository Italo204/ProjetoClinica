package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IProntuarioCRUD<T> {
    void saveProntuario(T entity) throws SQLException;

    int updateProntuario(T entity) throws SQLException;

    ArrayList<T> findAllProntuario() throws SQLException;

    int deleteProntuario(long id) throws SQLException;

    T searchProntuario(long id) throws SQLException;
}
