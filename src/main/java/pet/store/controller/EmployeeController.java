package pet.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreEmployee;
import pet.store.entity.Employee;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class EmployeeController {

	private final PetStoreService petStoreService;

	public EmployeeController(PetStoreService petStoreService) {
		this.petStoreService = petStoreService;
	}

	@PostMapping("/{petStoreId}/employee")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreEmployee addEmployeeToPetStore(@PathVariable Long petStoreId,
			@RequestBody PetStoreEmployee petStoreEmployee) {
		log.info("Adding employee to pet store with ID={}", petStoreId);
		log.info("Employee details: {}", petStoreEmployee);

		return petStoreService.saveEmployee(petStoreId, petStoreEmployee);
	}

	@GetMapping("/{petStoreId}/employee/{employeeId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Employee getEmployeeFromPetStore(@PathVariable Long petStoreId, @PathVariable Long employeeId) {
		log.info("Retrieving employee with ID={} from pet store with ID={}", employeeId, petStoreId);

		return petStoreService.findEmployeeById(petStoreId, employeeId);
	}
}