package com.hall;

import java.util.ArrayList;

import com.event.Event;
import com.user.User;

public class Hall {
	private User Owner;
	private float width;
	private float length;
	private ArrayList<Event> eventList;
	public User getOwner() {
		return Owner;
	}
	public void setOwner(User owner) {
		Owner = owner;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public ArrayList<Event> getEventList() {
		return eventList;
	}
	public void setEventList(ArrayList<Event> eventList) {
		this.eventList = eventList;
	}
	
	public Hall() {
		
	}
	

	public Hall(User inpOwner, float inpWidth, float inpLength, ArrayList<Event> events) {
		this.Owner = inpOwner;
		this.width = inpWidth;
		this.length = inpLength;
		this.eventList = events;
	}
	
	public void display() {
		if(eventList.size()>0) {
			for(int i = 0 ;i < eventList.size(); i++) {
				System.out.println("Event ID "+eventList.get(i).getId()+"\nEvent Name "+eventList.get(i).getName());
			}
		}
	}
	@Override
	public String toString() {
		return "Hall [Owner=" + Owner + ", width=" + width + ", length=" + length + ", eventList=" + eventList + "]";
	}
}
