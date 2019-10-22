package com.workmarket.coding.challenge.util;

import java.util.*;
import java.time.*;

public class GeoCodingRateLimiter {

	public class HitCounter 
	{ 
		Queue<Long> q = null;
		public HitCounter() 
		{
			q = new LinkedList<Long>();
		}

		public boolean hit(long timestamp)
		{
			while(!q.isEmpty() && timestamp-q.peek() >= TIME_LIMIT) 
				q.poll();

			if(q.size() < REQUEST_LIMIT) //throttle condition..if more than 5 attempts in 1minute then say POST is unsuccessful
			{
				q.offer(timestamp); 
				return true;
			}

			return false;
		}
	}

	private final int REQUEST_LIMIT = 5;
	private final long TIME_LIMIT = 60000; // want to make it 1 minute, .. 60,000 milliseconds

	private final Map<String, HitCounter> geoCodeHitMap = new HashMap<String, HitCounter>();

	public boolean isValidHit(String client_id) {
		HitCounter h = geoCodeHitMap.get(client_id);

		long curTime = System.currentTimeMillis();

		if(h == null) {
			h = new HitCounter();
			geoCodeHitMap.put(client_id, h);
		} 

		return h.hit(curTime);
	}        

	public static void main(String[] args) {
		GeoCodingRateLimiter limiter = new GeoCodingRateLimiter();
		System.out.println("test1 " + limiter.isValidHit("test1"));
		System.out.println("test1 " +limiter.isValidHit("test1"));
		System.out.println("test1 " +limiter.isValidHit("test1"));
		System.out.println("test1 " +limiter.isValidHit("test1"));
		System.out.println("test2 " +limiter.isValidHit("test2"));
		System.out.println("test2 " +limiter.isValidHit("test2"));
		System.out.println("test2 " +limiter.isValidHit("test2"));
		System.out.println("test2 " +limiter.isValidHit("test2"));
		System.out.println("test1 " +limiter.isValidHit("test1"));
		System.out.println("Sleeping for 1 second");
		try {
			java.lang.Thread.sleep(1000); 
		} catch (InterruptedException ex) {
			System.out.println(ex);
		}
		System.out.println("test1 " + limiter.isValidHit("test1"));
		System.out.println("test1 " +limiter.isValidHit("test1"));
		System.out.println("test1 " +limiter.isValidHit("test1"));
		System.out.println("test1 " +limiter.isValidHit("test1"));
		System.out.println("test2 " +limiter.isValidHit("test2"));
		System.out.println("test2 " +limiter.isValidHit("test2"));
		System.out.println("test2 " +limiter.isValidHit("test2"));
		System.out.println("test2 " +limiter.isValidHit("test2"));
		System.out.println("test1 " +limiter.isValidHit("test1"));
	}

}
