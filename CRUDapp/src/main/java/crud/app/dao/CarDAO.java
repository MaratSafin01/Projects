package crud.app.dao;

import crud.app.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Car> getAll() {
        return jdbcTemplate.query("SELECT * FROM cars", new BeanPropertyRowMapper<>(Car.class));
    }

    public Car findById(int id) {
        return jdbcTemplate.query("SELECT * FROM cars WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Car.class))
                .stream().findAny().orElse(null);
    }

    public void update(int id, Car car) {
        jdbcTemplate.update("UPDATE cars SET model=?, year=?, color=? WHERE id=?", car.getModel(), car.getYear(), car.getColor(), id);
    }

    public void save(Car car) {
        jdbcTemplate.update("INSERT INTO cars (model, year, color) VALUES (?,?,?)", car.getModel(), car.getYear(), car.getColor());
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM cars WHERE id=?", id);
    }
}
