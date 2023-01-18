package day3Task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHome {
	
	@Autowired
	private EmployeeFilteringFacade eff;

	@GetMapping("/home")
    public String home(@RequestParam(value = "day", defaultValue = "1") char day) {
    	
    	System.out.println("inside hello");
        switch (day) {
            case '3':
                eff.day3();
            	break;
		default:
                return "none is executed";
        }

        return String.format("Executed Day: %s!", day);
    }
}