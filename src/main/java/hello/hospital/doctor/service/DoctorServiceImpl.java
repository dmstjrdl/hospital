package hello.hospital.doctor.service;

import hello.hospital.doctor.domain.Doctor;
import hello.hospital.doctor.repository.DoctorRepository;
import hello.hospital.exception.BaseException;
import hello.hospital.exception.DoctorNotFound;
import hello.hospital.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(DoctorNotFound::new);
    }
}
