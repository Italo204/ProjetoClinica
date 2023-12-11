package interfaces;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

public interface IDatabaseCRUDHash<T> {
    int delete(Long id) throws SQLException;

    T search(Long id) throws SQLException;

    void save(T entity) throws SQLException;

    int update(long id, Map<String, Object> atualizacoes) throws SQLException;

    ArrayList<T> findAll() throws SQLException;
}
