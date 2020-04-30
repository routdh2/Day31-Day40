package java_stream;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
class User {
	private String name;
	private int age;
	
	public User(String name) {
		this.name=name;
		this.age=30;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
	
}
public class MapAndCollect {

	public static void main(String[] args) {
		
		List<String> names = new ArrayList<>(Arrays.asList("Dhananjay","Hari","Ganesh","Ajay"));
		//traditional way of creating objects from this list
		for(String name: names) {
			System.out.println(new User(name));
		}
		//Using stream API
		List<User> userList = names.stream().filter(name->!name.equals("tanmay")).map(new Function<String, User>() {
			@Override
			public User apply(String name) {
				return new User(name);
			}
		}).collect(Collectors.toList());
		System.out.println(userList);
		
		userList=names.stream().map(name->new User(name)).collect(Collectors.toList());
		System.out.println(userList);
	}

}
