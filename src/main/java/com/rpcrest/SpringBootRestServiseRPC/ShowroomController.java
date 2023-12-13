package com.rpcrest.SpringBootRestServiseRPC;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.security.PublicKey;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/cars/showroom")
public class ShowroomController {

    private final String sharedKey = "SHARED_KEY";

    private static final String SUCCESS_STATUS = "success";
    private static final String ERROR_STATUS = "error";
    private static final int CODE_SUCCESS = 100;
    private static final int AUTH_FAILURE = 102;

    @GetMapping
    public BaseResponse showStatus() {
        return new BaseResponse(SUCCESS_STATUS, 1);
    }

    @GetMapping("/show")
    public List<Car> getCarsShowroom() {
        final List<Car> response;
        CarRequest carRequest = new CarRequest();
        response = carRequest.getCarsShowroom();
        return response;
    }

    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        final Car response;
        CarRequest carRequest = new CarRequest();
        response = carRequest.getCarById(id);
        return response;
    }
//    public static class Statistic{
//        @Value("${spring.application.name}")
//        String applicationName;
//        @Value("${spring.application.version}")
//        String applicationVersion;
//        String address = InetAddress.getLocalHost();
//    }
    @GetMapping("/statistic")
    public Statistic getStatistic() {
        final Car response;
        CarRequest carRequest = new CarRequest();
        response = carRequest.getCarById(id);
        return response;
    }

    @PostMapping("/add")
    public BaseResponse addCar(@RequestBody Car newCar) {
        final BaseResponse response;
        CarRequest carRequest = new CarRequest();
        if (newCar.getCarPrice() != null &&
                !Objects.equals(newCar.getBrand(), "") &&
                !Objects.equals(newCar.getEngineCapacity(), "") &&
                !Objects.equals(newCar.getManufacturerCountry(), "") &&
                newCar.getManufactureYear() != null &&
                carRequest.addCar(newCar)) {

            response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse removeCar(@PathVariable int id) {
        final BaseResponse response;
        CarRequest carRequest = new CarRequest();
        if (carRequest.removeCarById(id)) {
            response = new BaseResponse(SUCCESS_STATUS, CODE_SUCCESS);
        } else {
            response = new BaseResponse(ERROR_STATUS, AUTH_FAILURE);
        }
        return response;
    }
}