package hello.hospital.doctor.service;

import hello.hospital.doctor.domain.Doctor;
import hello.hospital.doctor.dto.ResponseDoctorDTO;

public interface DoctorService {

    Doctor getDoctorById(Long id);
    ResponseDoctorDTO listDoctors(String hospitalName, String departmentName);
}
