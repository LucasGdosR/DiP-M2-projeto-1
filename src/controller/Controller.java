package controller;

import model.*;
import repository.PersonRepository;
import java.util.stream.Stream;

public class Controller {
    private final PersonRepository<Doctor> doctorRepository;
    private final PersonRepository<Nurse> nurseRepository;
    private final PersonRepository<Patient> patientRepository;

    public Controller(PersonRepository<Doctor> doctorRepository, PersonRepository<Nurse> nurseRepository, PersonRepository<Patient> patientRepository) {
        this.doctorRepository = doctorRepository;
        this.nurseRepository = nurseRepository;
        this.patientRepository = patientRepository;
    }

    public void registerDoctor() {
        Person person = ControllerHelper.getPersonData();
        String schoolAttended = ControllerHelper.getString("a Instituição de Ensino da Formação");
        String councilId = ControllerHelper.getString("o CRM/UF");
        String specialization = ControllerHelper.getSpecialization();
        Boolean active = ControllerHelper.getBoolean("se está ativo ou não (S/N)");
        Doctor doctor = new Doctor(person.getFullName(), person.getGender(), person.getBirthday(), person.getCpf(), person.getTelephone(), schoolAttended, councilId, specialization, active);
        doctorRepository.add(doctor);
    }

    public void registerNurse() {
        Person person = ControllerHelper.getPersonData();
        String schoolAttended = ControllerHelper.getString("a Instituição de Ensino da Formação");
        String councilId = ControllerHelper.getString("o COFEN/UF");
        Nurse nurse = new Nurse(person.getFullName(), person.getGender(), person.getBirthday(), person.getCpf(), person.getTelephone(), schoolAttended, councilId);
        nurseRepository.add(nurse);
    }

    public void registerPatient() {
        Person person = ControllerHelper.getPersonData();
        String emergencyContact = ControllerHelper.getString("o contato de emergência");
        Status status = ControllerHelper.getStatus();
        Patient patient = new Patient(person.getFullName(), person.getGender(), person.getBirthday(), person.getCpf(), person.getTelephone(),emergencyContact, status);
        if (ControllerHelper.hasAllergies())
            patient.setAllergies(ControllerHelper.getList("alergias"));
        if (ControllerHelper.hasSpecialNeeds())
            patient.setSpecialCares(ControllerHelper.getList("cuidados específicos"));
        if (ControllerHelper.hasInsurance()) {
            patient.setInsurance(ControllerHelper.getString("o convênio médico"));
            patient.setInsuranceNumber(ControllerHelper.getString("o número do convênio"));
            patient.setInsuranceExpiryDate(ControllerHelper.getExpiryDate());
        }
        patientRepository.add(patient);
    }

    public void performMedicalProcedure() {
        getDoctorById().performTreatment();
        getPatientById("Informe o código do paciente do atendimento: ").receiveTreatment();
    }

    private Doctor getDoctorById() {
        while (true) {
            try {
                Integer doctorId = ControllerHelper.getId("Informe o código do médico do atendimento: ");

                Doctor doctor = doctorRepository
                        .getRepository()
                        .parallelStream()
                        .filter(d -> d.getId() == doctorId)
                        .findFirst()
                        .get();

                return doctor;

            } catch (Exception e) {
                System.out.println("Erro: não existe médico com esse código.");
            }
        }
    }

    private Patient getPatientById(String string) {
        while (true) {
            try {
                Integer patientId = ControllerHelper.getId(string);

                Patient patient = patientRepository
                        .getRepository()
                        .parallelStream()
                        .filter(p -> p.getId() == patientId)
                        .findFirst()
                        .get();

                return patient;

            } catch (Exception e) {
                System.out.println("Erro: não existe paciente com esse código.");
            }
        }
    }

    public void updatePatientStatus() {
        Patient patient = getPatientById("Informe o código do paciente para mudar o status: ");
        Status status = ControllerHelper.getStatus();
        patient.setStatus(status);
    }

    public void listAll() {
        listDoctors();
        listNurses();
        listPatients();
    }

    public void listDoctors() {
        doctorRepository.getRepository().forEach(doctor -> System.out.println(doctor.basicToString()));
    }

    public void listNurses() {
        nurseRepository.getRepository().forEach(nurse -> System.out.println(nurse.basicToString()));
    }

    public void listPatients() {
        patientRepository.getRepository().forEach(patient -> System.out.println(patient.basicToString()));
    }

    public void patientReport() {
        Stream<Patient> patientStream = patientRepository.getRepository().parallelStream();

        if (ControllerHelper.wantsByStatus()) {
            Status status = ControllerHelper.getStatus();
            patientStream = patientStream.filter(patient -> patient.getStatus().equals(status));
        }

        patientStream.forEach(patient -> System.out.println(patient.fullToString()));
    }

    public void doctorReport() {
        Stream<Doctor> doctorStream = doctorRepository.getRepository().parallelStream();

        if (ControllerHelper.wantsSpecialization()){
            String specialization = ControllerHelper.getSpecialization();
            doctorStream = doctorStream.filter(doctor -> doctor.getSpecialization().equals(specialization));
        }

        doctorStream.forEach(doctor -> System.out.println(doctor.fullToString()));
    }
}
