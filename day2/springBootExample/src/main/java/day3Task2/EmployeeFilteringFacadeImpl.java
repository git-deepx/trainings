package day3Task2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class EmployeeFilteringFacadeImpl implements EmployeeFilteringFacade {
	
	@Autowired
	private EmployeeFilteringService efs;
	
	public void day3() {

		System.out.println("in day3");
		efs.addData();
		efs.scenerio1();
		efs.scenerio2();
		efs.scenerio3();
		efs.scenerio4();
		efs.scenerio5();
		efs.scenerio6();
		efs.scenerio7();
		efs.scenerio8();
		efs.scenerio9();
		efs.scenerio10();

	}
}
