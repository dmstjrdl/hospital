package hello.hospital.availabletime.service;

import hello.hospital.availabletime.domain.AvailableTime;
import hello.hospital.availabletime.dto.RequestCreateAvailableTimeDTO;
import hello.hospital.availabletime.dto.RequestUpdateAvailableTimeDTO;
import hello.hospital.availabletime.dto.ResponseInfoAvailableTime;
import hello.hospital.availabletime.repository.AvailableTimeRepository;
import hello.hospital.doctor.domain.Doctor;
import hello.hospital.doctor.service.DoctorService;
import hello.hospital.exception.*;
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
    public ResponseInfoAvailableTime createAvailableTime(Long userId, RequestCreateAvailableTimeDTO createAvailableTimeDTO) {
        Doctor doctor = doctorService.getDoctorById(createAvailableTimeDTO.getDoctorId());
        if (!doctor.getUser().getId().equals(userId)) throw new InvalidAccess();
        if (existsByDayOfWeek(createAvailableTimeDTO.getDoctorId(), createAvailableTimeDTO.getDayOfWeek())) throw new AvailableTimeAlreadyExist();

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
    public ResponseInfoAvailableTime updateAvailableTime(Long userId, Long doctorId, RequestUpdateAvailableTimeDTO updateAvailableTimeDTO) {
        AvailableTime availableTime = getAvailableTimeById(updateAvailableTimeDTO.getAvailableTimeId());

        if (!availableTime.getDoctor().getUser().getId().equals(userId)) throw new InvalidAccess();
        if (existsByDayOfWeek(doctorId, updateAvailableTimeDTO.getDayOfWeek()) && !availableTime.getDayOfWeek().equals(updateAvailableTimeDTO.getDayOfWeek())) throw new AvailableTimeAlreadyExist();

        if (updateAvailableTimeDTO.getDayOfWeek() != null) availableTime.setDayOfWeek(updateAvailableTimeDTO.getDayOfWeek());
        if (updateAvailableTimeDTO.getStartTime() != null) availableTime.setStartTime(updateAvailableTimeDTO.getStartTime());
        if (updateAvailableTimeDTO.getEndTime() != null) availableTime.setEndTime(updateAvailableTimeDTO.getEndTime());

        return ResponseInfoAvailableTime.from(availableTime);
    }

    public boolean existsByDayOfWeek(Long doctorId, DayOfWeek dayOfWeek) {
        return availableTimeRepository.existsByDoctorIdAndDayOfWeek(doctorId, dayOfWeek);
    }

    public AvailableTime getAvailableTimeById(Long availableTimeId) {
        return availableTimeRepository.findById(availableTimeId).orElseThrow(AvailableTimeNotFound::new);
    }
}
