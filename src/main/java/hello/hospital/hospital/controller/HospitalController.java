package hello.hospital.hospital.controller;

import hello.hospital.hospital.dto.RequestCreateHospitalDTO;
import hello.hospital.hospital.dto.RequestUpdateHospitalDTO;
import hello.hospital.hospital.dto.ResponseHospitalDTO;
import hello.hospital.hospital.dto.ResponseInfoHospitalDTO;
import hello.hospital.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hospital")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @GetMapping("/")
    public ResponseEntity<ResponseHospitalDTO> listHospitals() {
        return ResponseEntity.ok(hospitalService.listHospitals());
    }

    @GetMapping("/{hospitalId}")
    public ResponseEntity<ResponseInfoHospitalDTO> infoHospital(@PathVariable Long hospitalId) {
        return ResponseEntity.ok(hospitalService.infoHospital(hospitalId));
    }

    @GetMapping("/search")
    public ResponseEntity<ResponseHospitalDTO> searchHospital(@RequestParam String hospitalName) {
        return ResponseEntity.ok(hospitalService.searchHospital(hospitalName));
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseInfoHospitalDTO> createHospital(@RequestBody RequestCreateHospitalDTO requestCreateHospitalDTO) {
        return ResponseEntity.ok(hospitalService.createHospital(requestCreateHospitalDTO));
    }

    @PutMapping("/{hospitalId}/update")
    public ResponseEntity<ResponseInfoHospitalDTO> updateHospital(@PathVariable Long hospitalId, @RequestBody RequestUpdateHospitalDTO requestUpdateHospitalDTO) {
        return ResponseEntity.ok(hospitalService.updateHospital(hospitalId, requestUpdateHospitalDTO));
    }
}
