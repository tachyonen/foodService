package com.example.rest;

import java.util.concurrent.atomic.AtomicLong;

public class ProductIkoy {
	private final long id;
	private final String name;
	private final String info;
	private final float prize;
	private final float volume;
	private static final AtomicLong counter = new AtomicLong(100);
	
	
	
	
	public static class ProductIkoyBuilder{
		private long id;
		private String name = "";
		private String info = "";
		private float prize = 0;
		private float volume = 0;
		
	}
}
