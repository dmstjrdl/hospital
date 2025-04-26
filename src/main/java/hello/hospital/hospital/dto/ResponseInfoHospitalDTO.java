package hello.hospital.hospital.dto;

import hello.hospital.department.dto.ResponseInfoDepartmentDTO;
import hello.hospital.hospital.domain.Hospital;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResponseInfoHospitalDTO {

    private String name;
    private String address;
    private List<ResponseInfoDepartmentDTO> departments;

    public static ResponseInfoHospitalDTO from(Hospital hospital) {
        List<ResponseInfoDepartmentDTO> departments = hospital.getDepartments().stream()
                .map(ResponseInfoDepartmentDTO::from)
                .toList();

        return new ResponseInfoHospitalDTO(
                hospital.getName(),
                hospital.getAddress(),
                departments
        );
    }
}
