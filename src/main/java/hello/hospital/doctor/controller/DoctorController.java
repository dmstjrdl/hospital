package hello.hospital.doctor.controller;

import hello.hospital.doctor.dto.ResponseDoctorDTO;
import hello.hospital.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping("")
    public ResponseEntity<ResponseDoctorDTO> listDoctors(@RequestParam(required = false) String hospitalName, @RequestParam(required = false) String departmentName) {
        return ResponseEntity.ok(doctorService.listDoctors(hospitalName, departmentName));
    }
}
