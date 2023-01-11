import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student{
	int id;
	String name;
	int marks;
	
	Student(int id, String name, int marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public int getMarks() {
		// TODO Auto-generated method stub
		return marks;
	}
	
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	@Override
	public String toString() {
		return id + " " + name + " " + marks;	
	}
}

public class PartitioningExample {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student(1, "yasir", 59));
		students.add(new Student(1, "deepak", 69));
		students.add(new Student(1, "shubham", 19));
		students.add(new Student(1, "yasir", 59));
		
		Map<Boolean, List<Student>> passingFailing = students.stream()
		        .collect(Collectors.partitioningBy(s -> s.getMarks() >= 35));
		System.out.println(passingFailing);
		
		//counting example
		Map<Integer, Long> counting = students.stream().collect(
				Collectors.groupingBy(Student::getMarks, Collectors.counting()));
		
		System.out.println(counting);

	}
}
