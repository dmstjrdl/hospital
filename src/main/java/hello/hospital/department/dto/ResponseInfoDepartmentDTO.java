package hello.hospital.department.dto;

import hello.hospital.department.domain.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseInfoDepartmentDTO {

    private Long id;
    private String departmentName;

    public static ResponseInfoDepartmentDTO from(Department department) {
        return new ResponseInfoDepartmentDTO(
                department.getId(),
                department.getName()
        );
    }
}
