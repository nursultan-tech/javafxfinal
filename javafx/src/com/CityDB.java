package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityDB {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "12345";

    public Connection connect(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL successfully!");
        } catch (SQLException e) {
            System.out.println(e.getCause());
        }
        return connection;
    }

    public List<City> getCities() {
        String SQL = "SELECT nameOfCountry, nameOfCity FROM cities";
        List<City> cities = new ArrayList<>();
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                City city = new City();
                city.setCountry(rs.getString("nameOfCountry"));
                city.setName(rs.getString("nameOfCity"));
                cities.add(city);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return cities;
    }
    public City createCity(City city){
        String SQL = "INSERT INTO cities (nameOfCountry, nameOfCity) values ('"+city.getCountry()+"', '"+city.getName()+"')";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(SQL);
            System.out.println("City created! = " + city);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return city;
    }
    public void deleteAll(){
        String SQL = "DELETE FROM cities";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(SQL);
            System.out.println("All records were deleted!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
