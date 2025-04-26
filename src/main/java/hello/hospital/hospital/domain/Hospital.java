package hello.hospital.hospital.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import hello.hospital.department.domain.Department;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hospital_id")
    private Long id;

    private String name;
    private String address;

    @OneToMany(mappedBy = "hospital")
    @JsonIgnore
    @Builder.Default
    private List<Department> departments = new ArrayList<>();

    public Hospital(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
