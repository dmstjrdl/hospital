package hello.hospital.availabletime.service;

import hello.hospital.availabletime.domain.AvailableTime;
import hello.hospital.availabletime.dto.RequestCreateAvailableTimeDTO;
import hello.hospital.availabletime.dto.RequestUpdateAvailableTimeDTO;
import hello.hospital.availabletime.dto.ResponseInfoAvailableTime;
import hello.hospital.availabletime.repository.AvailableTimeRepository;
import hello.hospital.doctor.domain.Doctor;
import hello.hospital.doctor.service.DoctorService;
import hello.hospital.exception.AvailableTimeNotFound;
import hello.hospital.exception.BaseException;
import hello.hospital.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.DayOfWeek;

@Service
@RequiredArgsConstructor
public class AvailableTimeServiceImpl implements AvailableTimeService {

    private final AvailableTimeRepository availableTimeRepository;
    private final DoctorService doctorService;

    @Override
    public ResponseInfoAvailableTime createAvailableTime(RequestCreateAvailableTimeDTO createAvailableTimeDTO) {
        Doctor doctor = doctorService.getDoctorById(createAvailableTimeDTO.getDoctorId());
        if (existsByDayOfWeek(createAvailableTimeDTO.getDayOfWeek())) throw new BaseException(ErrorCode.AVAILABLE_TIME_ALREADY_EXIST);

        AvailableTime availableTime = AvailableTime.builder()
                .doctor(doctor)
                .dayOfWeek(createAvailableTimeDTO.getDayOfWeek())
                .startTime(createAvailableTimeDTO.getStartTime())
                .endTime(createAvailableTimeDTO.getEndTime())
                .build();

        availableTimeRepository.save(availableTime);
        return ResponseInfoAvailableTime.from(availableTime);
    }

    @Transactional
    @Override
    public ResponseInfoAvailableTime updateAvailableTime(Long availableTimeId, RequestUpdateAvailableTimeDTO updateAvailableTimeDTO) {
        AvailableTime availableTime = getAvailableTimeById(availableTimeId);
        if (existsByDayOfWeek(updateAvailableTimeDTO.getDayOfWeek())) throw new BaseException(ErrorCode.AVAILABLE_TIME_ALREADY_EXIST);

        if (updateAvailableTimeDTO.getDayOfWeek() != null) {
            availableTime.setDayOfWeek(updateAvailableTimeDTO.getDayOfWeek());
        }

        if (updateAvailableTimeDTO.getStartTime() != null) {
            availableTime.setStartTime(updateAvailableTimeDTO.getStartTime());
        }

        if (updateAvailableTimeDTO.getEndTime() != null) {
            availableTime.setEndTime(updateAvailableTimeDTO.getEndTime());
        }

        return ResponseInfoAvailableTime.from(availableTime);
    }

    public boolean existsByDayOfWeek(DayOfWeek dayOfWeek) {
        return availableTimeRepository.existsByDayOfWeek(dayOfWeek);
    }

    public AvailableTime getAvailableTimeById(Long availableTimeId) {
        return availableTimeRepository.findById(availableTimeId).orElseThrow(AvailableTimeNotFound::new);
    }
}
