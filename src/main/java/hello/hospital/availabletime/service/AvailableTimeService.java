package hello.hospital.availabletime.service;

import hello.hospital.availabletime.dto.RequestCreateAvailableTimeDTO;
import hello.hospital.availabletime.dto.RequestUpdateAvailableTimeDTO;
import hello.hospital.availabletime.dto.ResponseInfoAvailableTime;
import hello.hospital.user.domain.CustomUserDetails;

public interface AvailableTimeService {

    ResponseInfoAvailableTime createAvailableTime(Long userId, RequestCreateAvailableTimeDTO createAvailableTimeDTO);
    ResponseInfoAvailableTime updateAvailableTime(Long userId, Long doctorId, RequestUpdateAvailableTimeDTO updateAvailableTimeDTO);
}
