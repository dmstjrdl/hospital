package hello.hospital.doctor.controller;

import hello.hospital.doctor.dto.RequestCreateDoctorDTO;
import hello.hospital.doctor.dto.ResponseDoctorDTO;
import hello.hospital.doctor.dto.ResponseInfoDoctorDTO;
import hello.hospital.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("")
    public ResponseEntity<ResponseDoctorDTO> listDoctors(@RequestParam(required = false) String hospitalName, @RequestParam(required = false) String departmentName) {
        return ResponseEntity.ok(doctorService.listDoctors(hospitalName, departmentName));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseInfoDoctorDTO> createDoctor(@RequestBody RequestCreateDoctorDTO requestCreateDoctorDTO) {
        return ResponseEntity.ok(doctorService.createDoctor(requestCreateDoctorDTO));
    }
}
