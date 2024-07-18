package com.project.BlogApplication;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
		
//		int[] nums= {1,1,2,2,3,3,4};
//		Set<Integer> setis =Arrays.stream(nums).filter(item->Collections.frequency(nums, item)<=1).collect(Collectors.toSet());;

		
		
//		List<String> list=List.of("Prerna","Bab","ank","pram","bhumi");
//		Comparator<String> com= new Comparator<String>() {
//			
//			@Override
//			public int compare(String o1, String o2) {
//				if(o1.length()>o2.length()) {
//					return 1;
//				}
//				else {
//				return -1;
//			}}
//		};
//		Collections.sort(list,com);
//		Class<?> name=String.class;
//		System.out.println(name.getName());
//		System.out.println(name.getCanonicalName()+ "modifier name is "+name.getModifiers());
//		List<String> str=List.of("a","ab","abc");
//		str.stream().forEach(System.out::print);
//		List<Integer> list= new ArrayList<>(List.of(1,2,3,4,4,4));
//		int ans=list.stream().filter(item->item%2==0).reduce(0,(a,b)->a+b);
//		System.out.println(ans);
//		List<List<Integer>> listnew= new ArrayList<>(List.of(List.of(1,2,3,4),List.of(2,3,4)));
//		listnew.stream().flatMap(Collection::stream).forEach(System.out::print);
//	List<Integer> list= new ArrayList();
//	List<Integer> list1= new ArrayList(List.of(1,2,3,4,5,6));
//	for(int i=0;i<5;i++) {
//		list.add(i+1);
//	}
//	System.out.println(list.hashCode());
//	System.out.println(list.equals(list1));
//
//	System.out.println(list.containsAll(list1));
//	System.out.println(list.addAll(list1));
//	list.clear();
//	System.out.println(list.toString());

	
	
	
//	list.forEach(System.out::println);
//	System.out.println("0 th index has element : "+list.remove(0));
//	Iterator<Integer> itr=list.iterator();
//	while(itr.hasNext()) {
//		System.out.println(itr.next());
//	}
//	
	
	}
	
	
	
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	
	

}
