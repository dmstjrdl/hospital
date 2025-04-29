package hello.hospital.medicalrecord.service;

import hello.hospital.appointment.domain.Appointment;
import hello.hospital.appointment.domain.AppointmentStatus;
import hello.hospital.appointment.service.AppointmentService;
import hello.hospital.exception.InvalidAccess;
import hello.hospital.exception.MedicalRecordAlreadyExist;
import hello.hospital.exception.MedicalRecordNotFound;
import hello.hospital.medicalrecord.domain.MedicalRecord;
import hello.hospital.medicalrecord.dto.RequestCreateMedicalRecordDTO;
import hello.hospital.medicalrecord.dto.RequestUpdateMedicalRecordDTO;
import hello.hospital.medicalrecord.dto.ResponseInfoMedicalRecordDTO;
import hello.hospital.medicalrecord.repository.MedicalRecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final AppointmentService appointmentService;
    private final MedicalRecordRepository medicalRecordRepository;

    @Transactional
    @Override
    public ResponseInfoMedicalRecordDTO createMedicalRecord(RequestCreateMedicalRecordDTO requestCreateMedicalRecordDTO) {
        Appointment appointment = appointmentService.getAppointmentById(requestCreateMedicalRecordDTO.getAppointmentId());
        if (medicalRecordRepository.existsByAppointmentId(requestCreateMedicalRecordDTO.getAppointmentId())) throw new MedicalRecordAlreadyExist();

        MedicalRecord medicalRecord = MedicalRecord.builder()
                .appointment(appointment)
                .diagnosis(requestCreateMedicalRecordDTO.getDiagnosis())
                .prescription(requestCreateMedicalRecordDTO.getPrescription())
                .symptoms(requestCreateMedicalRecordDTO.getSymptoms())
                .build();

        appointment.setStatus(AppointmentStatus.COMPLETED);
        medicalRecordRepository.save(medicalRecord);
        return ResponseInfoMedicalRecordDTO.from(medicalRecord);
    }

    @Transactional
    @Override
    public ResponseInfoMedicalRecordDTO updateMedicalRecord(Long userId, Long medicalRecordId, RequestUpdateMedicalRecordDTO requestUpdateMedicalRecordDTO) {
        MedicalRecord medicalRecord = getMedicalRecordById(medicalRecordId);
        if (medicalRecord.getAppointment().getDoctor().getUser().getId().equals(userId)) throw new InvalidAccess();

        if (requestUpdateMedicalRecordDTO.getDiagnosis() != null) medicalRecord.setDiagnosis(requestUpdateMedicalRecordDTO.getDiagnosis());
        if (requestUpdateMedicalRecordDTO.getPrescription() != null) medicalRecord.setPrescription(requestUpdateMedicalRecordDTO.getPrescription());
        if (requestUpdateMedicalRecordDTO.getSymptoms() != null) medicalRecord.setSymptoms(requestUpdateMedicalRecordDTO.getSymptoms());

        return ResponseInfoMedicalRecordDTO.from(medicalRecord);
    }

    @Override
    public ResponseInfoMedicalRecordDTO infoMedicalRecord(Long appointmentId) {
        MedicalRecord medicalRecord = medicalRecordRepository.findByAppointmentId(appointmentId).orElseThrow(MedicalRecordNotFound::new);

        return ResponseInfoMedicalRecordDTO.from(medicalRecord);
    }

    public MedicalRecord getMedicalRecordById(Long medicalRecordId) {
        return medicalRecordRepository.findById(medicalRecordId).orElseThrow(MedicalRecordNotFound::new);
    }
}
