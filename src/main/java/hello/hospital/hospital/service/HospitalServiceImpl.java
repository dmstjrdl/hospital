package hello.hospital.hospital.service;

import hello.hospital.exception.BaseException;
import hello.hospital.exception.ErrorCode;
import hello.hospital.exception.HospitalNotFound;
import hello.hospital.hospital.domain.Hospital;
import hello.hospital.hospital.dto.RequestCreateHospitalDTO;
import hello.hospital.hospital.dto.RequestUpdateHospitalDTO;
import hello.hospital.hospital.dto.ResponseInfoHospitalDTO;
import hello.hospital.hospital.dto.ResponseHospitalDTO;
import hello.hospital.hospital.repository.HospitalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    @Override
    public ResponseHospitalDTO listHospitals() {
        List<Hospital> hospitals = hospitalRepository.findAll();
        if (hospitals.isEmpty()) throw new BaseException(ErrorCode.HOSPITAL_NOT_FOUND);

        return ResponseHospitalDTO.from(hospitals);
    }

    @Override
    public ResponseInfoHospitalDTO infoHospital(Long hospitalId) {
        return ResponseInfoHospitalDTO.from(getHospitalById(hospitalId));
    }

    @Override
    public ResponseHospitalDTO searchHospital(String hospitalName) {
        List<Hospital> hospitals = hospitalRepository.findByNameContaining(hospitalName);
        if (hospitals.isEmpty()) throw new BaseException(ErrorCode.HOSPITAL_NOT_FOUND);

        return ResponseHospitalDTO.from(hospitals);
    }

    @Override
    public ResponseInfoHospitalDTO createHospital(RequestCreateHospitalDTO requestCreateHospitalDTO) {
        Hospital hospital = Hospital.builder()
                .name(requestCreateHospitalDTO.getHospitalName())
                .address(requestCreateHospitalDTO.getHospitalAddress())
                .build();

        hospitalRepository.save(hospital);

        return ResponseInfoHospitalDTO.from(hospital);
    }

    @Transactional
    @Override
    public ResponseInfoHospitalDTO updateHospital(Long hospitalId, RequestUpdateHospitalDTO requestUpdateHospitalDTO) {
        Hospital hospital = getHospitalById(hospitalId);

        if (requestUpdateHospitalDTO.getHospitalName() != null) {
            hospital.setName(requestUpdateHospitalDTO.getHospitalName());
        }
        if (requestUpdateHospitalDTO.getHospitalAddress() != null) {
            hospital.setAddress(requestUpdateHospitalDTO.getHospitalAddress());
        }

        return ResponseInfoHospitalDTO.from(hospital);
    }

    public Hospital getHospitalById(Long hospitalId) {
        return hospitalRepository.findById(hospitalId).orElseThrow(HospitalNotFound::new);
    }
}
