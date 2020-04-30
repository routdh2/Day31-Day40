package java_stream;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import java.util.function.Consumer;
public class StreamDemo {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>(Arrays.asList("Dhananjay","tanmay","Simon","Peter"));
		//Filter all the names except tanmay
		//traditional method
		for(String name : names) {
			if(name.contentEquals("tanmay"))
				continue;
			System.out.print(name+" ");
		}
		//or we could use iterator if we want to modify the list
		Iterator itr = names.iterator();
		while(itr.hasNext()) {
			if(itr.next().equals("tanmay"))
				itr.remove();
		}
		System.out.println(names);
		
		//functional method using stream API
		Stream nameStream = names.stream();//get the stream object of names
		//filter API takes a Predicate function which is a functional interface having one method test
		//The predicate function returns a boolean saying the object should be filtered or not
		System.out.println(nameStream.toString());
		Stream filteredStream = nameStream.filter(new Predicate() { 
			@Override
			public boolean test(Object name) {
				return !name.equals("tanmay");
			}
		});
		//forEach API takes a Consumer function which is a functional interface having one method accept(Object t)
		//But it doesn't return any thing
		filteredStream.forEach(new Consumer() {
			@Override
			public void accept(Object name) {
				System.out.println(name);
			}
		});
		
		//we can use lambda expressions for shorthand notation for anonymous inner class or functional interfaces
		names.stream().filter(name->!name.equals("tanmay")).forEach(System.out::println); //just one lilne
		names.stream().filter(name->!name.contentEquals("tanmay")).forEach(name->System.out.println(name));
		
	}

}
