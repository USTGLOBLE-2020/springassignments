package com.StreamOperations.Assignments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class mainClass {

	public static void main(String[] args) {

		Player p1 = new Player();
		p1.setPlayerName("player1");
		p1.setMatchesPlayed(2);
		p1.setHighestScore(120);
		p1.setRuns(2000);
		
		Country c1 = new Country();
		c1.setCountryId(1);
		c1.setCountryName("India");
		p1.setCountry(c1);
		
		
		Player p2 = new Player();
		p2.setPlayerName("BC");
		p2.setMatchesPlayed(2);
		p2.setHighestScore(180);
		p2.setRuns(5001);
		
		Country c2 = new Country();
		c2.setCountryId(1);
		c2.setCountryName("Asia");
		p2.setCountry(c2);
		
		
		Player p3 = new Player();
		p3.setPlayerName("Player3");
		p3.setMatchesPlayed(2);
		p3.setHighestScore(90);
		p3.setRuns(12000);
		p3.setCountry(c2);
		
		
		Player p4 = new Player();
		p4.setPlayerName("player4");
		p4.setMatchesPlayed(2);
		p4.setHighestScore(150);
		p4.setRuns(5000);
		p4.setCountry(c1);
		
		List<Player> playersList = new ArrayList<Player>();
		playersList.add(p1);
		playersList.add(p2);
		playersList.add(p3);
		playersList.add(p4);

//		playersList.forEach(item -> System.out.println(item.getPlayerName()));
		/*
		 * 
		
		//1.Display the names of all players
		playersList.stream().forEach(item -> System.out.println(item.getPlayerName()));
	
		//2.Display the name of players whose highest score is more than 100 and belong to a particular country
		List<Player> newList = playersList.stream()
		.filter(item -> item.getHighestScore() > 100 && item.getCountry().getCountryName().equals("India"))
		.collect(Collectors.toList());
		
		newList.forEach(item -> System.out.println("India Players "+item.getPlayerName()));
		
		//3. Return a LinkedList containing names of all Players, whose have scored more than 5000 runs, sorted in descending order of names
		LinkedList<String> list = new LinkedList<>();
		List<Player> descList = playersList.stream()
				.filter(player -> player.getRuns() > 5000)
				.collect(Collectors.toList());
				
		List<Player> sortedUsers = descList.stream()
				  .sorted(Comparator.comparing(Player::getPlayerName).reversed())
				  .collect(Collectors.toList());
		sortedUsers.forEach(i -> System.out.println(i.getPlayerName()));
		
		System.out.println(sortedUsers);
		for (Player pl : sortedUsers) {
			list.add(pl.getPlayerName());
		}
		System.out.println(list);
		
		//4. Return the average runs scored by players from a particular Country
		OptionalDouble avgList = playersList.stream()
				.filter(player -> player.getCountry().getCountryName().equals("India"))
				.mapToDouble(Player::getRuns)
				.average();
		System.out.println(avgList);
		
		//5. Return a list with names of Players sorted as per country and then by matchesPlayed(descending)
		 * - getPlayerNamesSorted
		Return a list with names of Players sorted as per country and then by matchesPlayed(descending)
	
	- getPlayerCountry
	//	6. return a map with the PlayerName and CountryName of all players who have played more than 200 matches
	
	- getMaxRunsPlayer
	//7.	Return the player who has scored maximum runs
	
	- findPlayer(String name, String country)
		Search and return the player for a given name and country 
	//8.
	- checkHighScorerByCountry(String country)
	 //9. 	Find whether there is any player in the given country who has scored more than 10000 runs. Return a boolean. 

		 */
//		List<Player> matchesList = playersList.stream()
//				.sorted(Comparator.comparing(c2.getCountryName().compareTo(c1.getCountryName())))
//				.collect(Collectors.toList());
		
	}
	

}