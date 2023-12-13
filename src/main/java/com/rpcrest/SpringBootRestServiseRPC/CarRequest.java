package com.rpcrest.SpringBootRestServiseRPC;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CarRequest {
    private List<Car> carsShowroom;

    public CarRequest() {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("ShowroomCars.json");
        try {
            this.carsShowroom = objectMapper.readValue(jsonFile, new TypeReference<List<Car>>() {
            });
        } catch (IOException e) {
            System.out.println("Read file error:\n" + e);
            this.carsShowroom = new ArrayList<>();
        }
    }

    private void saveList() {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File("ShowroomCars.json");
        try {
            objectMapper.writeValue(new File("ShowroomCars.json"), this.carsShowroom);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public boolean addCar(Car newCar) {
        try {
            newCar.setCarId(this.carsShowroom.size());
            this.carsShowroom.add(newCar);
            saveList();
            return true;
        } catch (Exception e) {
            System.out.println("addCarById: " + newCar + "\n" + e);
            return false;
        }
    }

    public Car getCarById(int id) {
        try {
            return this.carsShowroom.get(id);
        } catch (Exception e) {
            System.out.println("getCarById out IndexOutOfBoundsException: " + id + "\n" + e);
            return null;
        }
    }

    public boolean setCarById(int id, Car newCar) {
        try {
            this.carsShowroom.set(id, newCar);
            saveList();
            return true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("setCarById out IndexOutOfBoundsException: " + id + "\n" + e);
            return false;
        }
    }

    public boolean removeCarById(int id) {
        try {
            this.carsShowroom.remove(id);
            saveList();
            return true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("removeCarById out IndexOutOfBoundsException: " + id + "\n" + e);
            return false;
        }
    }
}
