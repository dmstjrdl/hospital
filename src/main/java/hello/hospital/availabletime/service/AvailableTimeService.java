package hello.hospital.availabletime.service;

import hello.hospital.availabletime.dto.RequestCreateAvailableTimeDTO;
import hello.hospital.availabletime.dto.RequestUpdateAvailableTimeDTO;
import hello.hospital.availabletime.dto.ResponseInfoAvailableTime;

public interface AvailableTimeService {

    ResponseInfoAvailableTime createAvailableTime(RequestCreateAvailableTimeDTO createAvailableTimeDTO);
    ResponseInfoAvailableTime updateAvailableTime(Long availableTimeId, RequestUpdateAvailableTimeDTO updateAvailableTimeDTO);
}
