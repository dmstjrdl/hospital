package hello.hospital.availabletime.controller;

import hello.hospital.availabletime.dto.RequestCreateAvailableTimeDTO;
import hello.hospital.availabletime.dto.RequestUpdateAvailableTimeDTO;
import hello.hospital.availabletime.dto.ResponseInfoAvailableTime;
import hello.hospital.availabletime.service.AvailableTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/available")
@RequiredArgsConstructor
public class AvailableTimeController {

    private final AvailableTimeService availableTimeService;

    @PostMapping("/add")
    public ResponseEntity<ResponseInfoAvailableTime> createAvailableTime(@RequestBody RequestCreateAvailableTimeDTO createAvailableTimeDTO) {
        return ResponseEntity.ok(availableTimeService.createAvailableTime(createAvailableTimeDTO));
    }

    @PutMapping("/{availableTimeId}/update")
    public ResponseEntity<ResponseInfoAvailableTime> updateAvailableTime(@PathVariable Long availableTimeId, @RequestBody RequestUpdateAvailableTimeDTO updateAvailableTimeDTO) {
        return ResponseEntity.ok(availableTimeService.updateAvailableTime(availableTimeId, updateAvailableTimeDTO));
    }
}
