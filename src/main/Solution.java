package main;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> coursesOfJoe = new ArrayList<String>();
		coursesOfJoe.add("ECON1901");
		coursesOfJoe.add("COMP1201");
		coursesOfJoe.add("ARTC1901");
		User joe = new User("Joe", coursesOfJoe);
		
		List<String> coursesOfSue = new ArrayList<String>();
		coursesOfSue.add("ENGE2602");
		coursesOfSue.add("MATH1345");
		coursesOfSue.add("BUSI1025");
		coursesOfSue.add("PHYS2052");
		User sue = new User("Sue", coursesOfSue);
		
		List<String> coursesOfAmy = new ArrayList<String>();
		coursesOfAmy.add("ARTC1250");
		coursesOfAmy.add("ENGE2602");
		coursesOfAmy.add("ECON2713");
		User amy = new User("Amy", coursesOfAmy);
		
		List<String> coursesOfEric = new ArrayList<String>();
		coursesOfEric.add("ECON1901");
		coursesOfEric.add("BUSI1025");
		coursesOfEric.add("ENGE2602");
		coursesOfEric.add("COMP2112");
		User eric = new User("Eric", coursesOfEric);
		
		List<String> coursesOfLuke = new ArrayList<String>();
		coursesOfLuke.add("ARTC1250");
		coursesOfLuke.add("BUSI1025");
		coursesOfLuke.add("BUSI1003");
		coursesOfLuke.add("COMP1026");
		coursesOfLuke.add("ENGE1036");
		User luke = new User("Luke", coursesOfLuke);
		
		List<String> coursesOfCody = new ArrayList<String>();
		coursesOfCody.add("MATH1651");
		coursesOfCody.add("BUSI2042");
		coursesOfCody.add("ENGE1036");
		User cody = new User("Cody", coursesOfCody);
		
		List<String> coursesOfWang = new ArrayList<String>();
		coursesOfWang.add("ECON1256");
		coursesOfWang.add("CHEM2510");
		coursesOfWang.add("MATH1345");
		coursesOfWang.add("BUSI1025");
		User wang = new User("Wang", coursesOfWang);
		
		List<String> coursesOfChen = new ArrayList<String>();
		coursesOfChen.add("MATH1651");
		coursesOfChen.add("COMP1201");
		User chen = new User("Chen", coursesOfChen);
		
		// Set Joe's friends
		List<User> friends = new ArrayList<User>();
		friends.add(sue);
		friends.add(amy);
		joe.setFriends(friends);
		
		List<User> sueFriends = new ArrayList<User>();
		sueFriends.add(eric);
		sueFriends.add(luke);
		sueFriends.add(cody);
		sueFriends.add(amy);
		sue.setFriends(sueFriends);
		
		List<User> amyFriends = new ArrayList<User>();
		amyFriends.add(wang);
		amyFriends.add(chen);
		amy.setFriends(amyFriends);
		
		
		List<Map.Entry<String, Integer>> rankedCourses = User.getRankedCourses(joe);
		
		for(int i = 0; i < rankedCourses.size(); i++) {
			System.out.print(rankedCourses.get(i).getKey() + ": " +rankedCourses.get(i).getValue() + "\n");
		}
		

	}

}
