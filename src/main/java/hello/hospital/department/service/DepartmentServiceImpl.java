package hello.hospital.department.service;

import hello.hospital.department.domain.Department;
import hello.hospital.department.repository.DepartmentRepository;
import hello.hospital.exception.DepartmentNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(DepartmentNotFound::new);
    }
}
