package hello.hospital.doctor.service;

import hello.hospital.availabletime.dto.RequestCreateAvailableTimeDTO;
import hello.hospital.department.domain.Department;
import hello.hospital.department.service.DepartmentService;
import hello.hospital.doctor.domain.Doctor;
import hello.hospital.doctor.dto.RequestCreateDoctorDTO;
import hello.hospital.doctor.dto.ResponseDoctorDTO;
import hello.hospital.doctor.dto.ResponseInfoDoctorDTO;
import hello.hospital.doctor.repository.DoctorRepository;
import hello.hospital.exception.DoctorNotFound;
import hello.hospital.hospital.domain.Hospital;
import hello.hospital.hospital.service.HospitalService;
import hello.hospital.user.domain.Role;
import hello.hospital.user.domain.User;
import hello.hospital.user.repository.UserRepository;
import hello.hospital.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService{

    private final DoctorRepository doctorRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final HospitalService hospitalService;
    private final DepartmentService departmentService;

    @Override
    public ResponseInfoDoctorDTO createDoctor(RequestCreateDoctorDTO requestCreateDoctorDTO) {
        User user = userService.getUserById(requestCreateDoctorDTO.getUserId());
        Hospital hospital = hospitalService.getHospitalById(requestCreateDoctorDTO.getHospitalId());
        Department department = departmentService.getDepartmentById(requestCreateDoctorDTO.getDepartmentId());

        Doctor doctor = Doctor.builder()
                .user(user)
                .hospital(hospital)
                .department(department)
                .build();

        user.setRole(Role.DOCTOR);
        userRepository.save(user);
        doctorRepository.save(doctor);
        return ResponseInfoDoctorDTO.from(doctor);
    }

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
