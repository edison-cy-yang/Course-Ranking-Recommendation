package main;

import java.util.*;
import java.util.Map.Entry;

public class User {
	public String name;
	private List<String> courses;
	private List<User> friends;
	
	public User(String name, List<String> courses) {
		this.name = name;
		this.courses = courses;
	}
	
	public List<String> getAttendedCoursesForUser() {
		return this.courses;
	}
	
	public List<User> getDirectFriendsForUser() {
		return this.friends;
	}
	
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	public static List<Map.Entry<String, Integer>> getRankedCourses(User user) {
		List<Map.Entry<String, Integer>> rankedC = new ArrayList<Map.Entry<String, Integer>>(); // A list to store the ranked courses
		HashMap<String, Integer> hashC = new HashMap<String, Integer>(); //hashmap to store the list of courses we checked so far
		HashSet<String> hashU = new HashSet<String>(); //hashset to store the list of users we visited so far
		HashSet<String> hashUC = new HashSet<String>(); //hashset to store the courses taken by the original user so we dont put these courses in answer
		
		
		List<String> courses = user.getAttendedCoursesForUser(); 
		for(String c : courses) {  // Add the courses taken by the original user to the set
			hashUC.add(c); 
		}
		
		List<User> friends = user.getDirectFriendsForUser();
		for(User f : friends) { // Go through the friend list
			String name = f.name;
			if(!hashU.contains(name)) { // only go through the course list if this friend has not been checked
				hashU.add(name); // add friends visited to hashU if not already existed
				
				List<String> coursesOfFriend = f.getAttendedCoursesForUser();
				for(String c: coursesOfFriend) {
					if(!hashUC.contains(c)) { // only the the course not taken by the original user
						if(!hashC.containsKey(c)) { // if c has not been added, add it
							hashC.put(c, 1);
						}
						else {
							hashC.put(c, hashC.get(c) + 1); // else add the course value by 1
						}
					}
				}
			}
			
			// Now this part will work on friends of friend
			List<User> f_friends = f.getDirectFriendsForUser();
			for(User ff: f_friends) {
				String fName = ff.name;
				if(!hashU.contains(fName)) {
					hashU.add(fName);
					
					List<String> coursesOfFF = ff.getAttendedCoursesForUser();
					for(String fc: coursesOfFF) {
						if(!hashUC.contains(fc)) {
							if(!hashC.containsKey(fc)) {
								hashC.put(fc, 1);
							}
							else {
								hashC.put(fc, hashC.get(fc) + 1);
							}
							
						}
					}
				}
			}
		}
		
		Set set = hashC.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
	    Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
	    {
	        public int compare( Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2 )
	        {
	            return (e2.getValue()).compareTo( e1.getValue() );
	        }
	    } );
	    
	    for(Map.Entry<String, Integer> entry: list) {
	        rankedC.add(entry);
	    }
	    
	    return rankedC;
		
		
	}
	
	

}
