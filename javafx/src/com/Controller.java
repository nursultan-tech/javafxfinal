package com;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class Controller {
    @FXML
    TextField countryNameCreate;
    @FXML
    TextField cityNameCreate;
    @FXML
    Label city1;
    @FXML
    Label city2;
    @FXML
    Label city3;
    @FXML
    Label city4;
    @FXML
    Label country1;
    @FXML
    Label country2;
    @FXML
    Label country3;
    @FXML
    Label country4;
    @FXML
    Label citiesInDatabase;
    @FXML
    Label createCity;


    int count = 0;

    public Controller(){
//        refresh();
    }
    public void create(){
        if(count<4){
            CityDB cityDB = new CityDB();
            cityDB.createCity(new City(cityNameCreate.getText(), countryNameCreate.getText()));
            refresh();
        }else{
            createCity.setText("Reached max 4");
        }

    }
    public void refresh(){
        createCity.setText("Create city");
        CityDB cityDB = new CityDB();
        List<City> cityList = cityDB.getCities();
        count = cityList.size();
        citiesInDatabase.setText(cityList.size() + " cities in database");
        if(cityList.size()==1){
            city1.setText(cityList.get(0).getName());
            country1.setText(cityList.get(0).getCountry());
        }
        if(cityList.size()==2){
            city1.setText(cityList.get(0).getName());
            country1.setText(cityList.get(0).getCountry());
            city2.setText(cityList.get(1).getName());
            country2.setText(cityList.get(1).getCountry());
        }
        if(cityList.size()==3){
            city1.setText(cityList.get(0).getName());
            country1.setText(cityList.get(0).getCountry());
            city2.setText(cityList.get(1).getName());
            country2.setText(cityList.get(1).getCountry());
            city3.setText(cityList.get(2).getName());
            country3.setText(cityList.get(2).getCountry());
        }
        if(cityList.size()==4){
            city1.setText(cityList.get(0).getName());
            country1.setText(cityList.get(0).getCountry());
            city2.setText(cityList.get(1).getName());
            country2.setText(cityList.get(1).getCountry());
            city3.setText(cityList.get(2).getName());
            country3.setText(cityList.get(2).getCountry());
            city4.setText(cityList.get(3).getName());
            country4.setText(cityList.get(3).getCountry());
        }
        if(cityList.size()==0){
            citiesInDatabase.setText("0 cities in database");
        }

    }
    public void deleteAll(){
        citiesInDatabase.setText("0 cities in database");
        CityDB cityDB = new CityDB();
        cityDB.deleteAll();
        city1.setText("");
        country1.setText("");
        city2.setText("");
        country2.setText("");
        city3.setText("");
        country3.setText("");
        city4.setText("");
        country4.setText("");
    }
}
