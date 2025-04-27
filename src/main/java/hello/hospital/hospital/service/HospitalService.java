package hello.hospital.hospital.service;

import hello.hospital.hospital.domain.Hospital;
import hello.hospital.hospital.dto.RequestCreateHospitalDTO;
import hello.hospital.hospital.dto.RequestUpdateHospitalDTO;
import hello.hospital.hospital.dto.ResponseHospitalDTO;
import hello.hospital.hospital.dto.ResponseInfoHospitalDTO;


public interface HospitalService {

    ResponseHospitalDTO listHospitals();
    ResponseInfoHospitalDTO infoHospital(Long hospitalId);
    ResponseHospitalDTO searchHospital(String hospitalName);
    ResponseInfoHospitalDTO createHospital(RequestCreateHospitalDTO requestCreateHospitalDTO);
    ResponseInfoHospitalDTO updateHospital(Long hospitalId, RequestUpdateHospitalDTO requestUpdateHospitalDTO);

    Hospital getHospitalById(Long hospitalId);
}
