package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

@Data
@NoArgsConstructor
public class PetStoreEmployee {
    private Long employeeId;
    private String employeeFirstName;
    private String employeeLastName;
    private String employeePhone;
    private String employeeJobTitle;
    private String employeeEmail;
	private PetStore petStore;

    public PetStoreEmployee(Employee employee) {
        this.employeeId = employee.getEmployeeId();
        this.employeeFirstName = employee.getEmployeeFirstName();
        this.employeeLastName = employee.getEmployeeLastName();
        this.employeePhone = employee.getEmployeePhone();
        this.employeeJobTitle = employee.getEmployeeJobTitle(); 
        this.employeeEmail = employee.getEmployeeEmail();
        this.petStore = employee.getPetStore();
    }
    
    public PetStore getPetStore() {
        return petStore;
    }

    public void copyEmployeeFields(Employee employee) {
        PetStore petStore = this.getPetStore();

        employee.setPetStore(petStore);
        employee.setEmployeeId(this.getEmployeeId());
        employee.setEmployeeFirstName(this.getEmployeeFirstName());
        employee.setEmployeeLastName(this.getEmployeeLastName());
        employee.setEmployeePhone(this.getEmployeePhone());
        employee.setEmployeeJobTitle(this.getEmployeeJobTitle());
        employee.setEmployeeEmail(this.getEmployeeEmail());
    }

}
