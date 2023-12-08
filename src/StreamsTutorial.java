import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsTutorial {

	public static void main(String[] args) {
		//Count the number of names starting with alphabet A in list.
		ArrayList<String> names = new ArrayList<String>();
		names.add("Amazon");
		names.add("Baron");
		names.add("Carrot");
		names.add("Apple");
		names.add("Dan");
		
		int count=0;
		for(int i=0; i<names.size(); i++) {
			String name = names.get(i);
			if(name.startsWith("A")) {
				count++;
			}
		}
		System.out.println(count);
		
		// Java 8 introduces stream concept.
		long c = names.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		
		long d = Stream.of("Amazon", "Baron", "Carrot", "Apple", "Danie").filter(s->
		{
			if (s.startsWith("A")) {
				return true; 
			}
			return false;
		}).count();
		System.out.println(d);
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		
		StreamsTutorial s = new StreamsTutorial();
		s.streamMap();
		s.streamCollect();
	}
	
	@Test
	public void streamMap() {
		Stream.of("Amazon", "Baron", "Carrot", "Apple", "Danie").filter(s->s.endsWith("e")).map(s->s.toUpperCase())
				.forEach(s->System.out.println(s));
		
		
		List<String> names1 = new ArrayList<String>();
		names1.add("man");
		names1.add("women");
		names1.add("Apple");
		
		//Array to List to Stream.
		
		String[] e = {"Amazon", "Baron", "Azza", "Apple", "Danie"};
		List<String> names = Arrays.asList(e);
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		Stream<String> concatList = Stream.concat(names.stream(), names1.stream()).sorted();
				
//		concatList.forEach(s->System.out.println(s));
		
		boolean flag = concatList.anyMatch(s->s.equalsIgnoreCase("Apple"));
		Assert.assertTrue(flag);
	}
	
	public void streamCollect() {
		
		// Stream back to List.
		List<String> ls = Stream.of("Amazon", "Baron", "Carrot", "Apple", "Danie").filter(s->s.endsWith("e")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		
		// Array to List to Stream.
		List<Integer> ls1 = Arrays.asList(3,2,2,7,5,1,9,7);
		Stream<Integer> si = ls1.stream().sorted().distinct();
		
		//Stream back to List.
		List<Integer> ls2 = si.collect(Collectors.toList());
		System.out.println(ls2.get(2));
	}
}
