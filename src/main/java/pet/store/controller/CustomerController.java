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
import pet.store.controller.model.PetStoreCustomer;
import pet.store.entity.Customer;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
@Slf4j
public class CustomerController {

    private final PetStoreService petStoreService;

    public CustomerController(PetStoreService petStoreService) {
        this.petStoreService = petStoreService;
    }

    @PostMapping("/{petStoreId}/customer")
    @ResponseStatus(code = HttpStatus.CREATED)
    public PetStoreCustomer addCustomerToPetStore(@PathVariable Long petStoreId,
           @RequestBody PetStoreCustomer petStoreCustomer) {
        log.info("Adding customer to pet store with ID={}", petStoreId);
        log.info("Customer details: {}", petStoreCustomer);

        return petStoreService.saveCustomer(petStoreId, petStoreCustomer);
    }
    
	@GetMapping("/{petStoreId}/customer/{customerId}")
	@ResponseStatus(code = HttpStatus.OK)
	public Customer getCustomerFromPetStore(@PathVariable Long petStoreId, @PathVariable Long customerId) {
		log.info("Retrieving customer with ID={} from pet store with ID={}", customerId, petStoreId);

		return petStoreService.findCustomerById(petStoreId, customerId);
	}
}
