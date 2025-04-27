package hello.hospital.doctor.service;

import hello.hospital.doctor.domain.Doctor;
import hello.hospital.doctor.dto.RequestCreateDoctorDTO;
import hello.hospital.doctor.dto.ResponseDoctorDTO;
import hello.hospital.doctor.dto.ResponseInfoDoctorDTO;

public interface DoctorService {

    Doctor getDoctorById(Long id);
    ResponseDoctorDTO listDoctors(String hospitalName, String departmentName);
    ResponseInfoDoctorDTO createDoctor(RequestCreateDoctorDTO requestCreateDoctorDTO);
}
