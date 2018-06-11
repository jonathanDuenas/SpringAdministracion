package com.capas.uca.controller;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener{
	 
	private static int as;
	private static ArrayList<Integer> ids = new ArrayList<>();
 
    public static int getTotalActiveSession() {
    	System.out.println(as+ "");
        return as;
    } 

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		int id = Integer.parseInt((String) event.getSession().getAttribute("id"));
		ids.add(id);
		int count=0;
		for(int i = 0; i<ids.size(); i++){
			int e = ids.get(i);
			if(e == id){
				count++;
			}
		}
		if(count>1){
			event.getSession().invalidate();
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println(as+ " remove");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println(as+ " replace");
		int id = Integer.parseInt((String) event.getSession().getAttribute("id"));
		int count=0;
		for(int e: ids){
			if(e == id){
				count++;
			}
		}
		if(count>1){
			event.getSession().invalidate();
		}
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		as++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		 as--;
	     System.out.println(as+ " Salio");
	     ids.remove(ids.indexOf(Integer.parseInt((String) event.getSession().getAttribute("id"))));
	}
}
