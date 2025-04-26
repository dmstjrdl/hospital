package hello.hospital.doctor.service;

import hello.hospital.doctor.domain.Doctor;
import hello.hospital.doctor.dto.ResponseDoctorDTO;
import hello.hospital.doctor.repository.DoctorRepository;
import hello.hospital.exception.DoctorNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;

    @Override
    public ResponseDoctorDTO listDoctors(String hospitalName, String departmentName) {
        List<Doctor> doctors;

        if (hospitalName != null && departmentName != null) {
            doctors = doctorRepository.findByHospitalNameContainingAndDepartmentNameContaining(hospitalName, departmentName);
        } else if (hospitalName != null) {
            doctors = doctorRepository.findByHospitalNameContaining(hospitalName);
        } else if (departmentName != null) {
            doctors = doctorRepository.findByDepartmentNameContaining(departmentName);
        } else {
            doctors = doctorRepository.findAll();
        }

        return ResponseDoctorDTO.from(doctors);
    }

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(DoctorNotFound::new);
    }
}
