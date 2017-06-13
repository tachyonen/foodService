package com.example.rest;

import java.nio.file.attribute.AclEntry.Builder;
import java.util.concurrent.atomic.AtomicLong;



public class ProductBestWoscht {

	private final long id;
	private final String name;
	private final String info;
	private final float prize;
	private final float volume;
	private static final AtomicLong counter = new AtomicLong(100);
	
	
	
	
	public long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getInfo() {
		return this.info;
	}

	public float getPrize() {
		return this.prize;
	}

	public float getVolume() {
		return this.volume;
	}

	

	private ProductBestWoscht(ProductBestWoschtBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.info = builder.info;
		this.prize = builder.prize;
		this.volume = builder.volume;
	}
	
	public ProductBestWoscht(){
		ProductBestWoscht proBest = new ProductBestWoscht.ProductBestWoschtBuilder()
				.id().build();
		this.id = proBest.getId();
		this.name = proBest.getName();
		this.info = proBest.getInfo();
		this.prize = proBest.getPrize();
		this.volume = proBest.getVolume();
	}
	
	public ProductBestWoscht(long id, String name, String info, float prize,
			float volume){
		ProductBestWoscht proBest = new ProductBestWoscht.ProductBestWoschtBuilder()
				.id()
				.name(name)
				.info(info)
				.prize(prize)
				.volume(volume)
				.build();
		this.id = proBest.getId();
		this.name = proBest.getName();
		this.info = proBest.getInfo();
		this.prize = proBest.getPrize();
		this.volume = proBest.getVolume();
		
		
	}
	
	public static class ProductBestWoschtBuilder{
		private long id;
		private String name = "";
		private String info = "";
		private float prize = 0;
		private float volume = 0;
		
		
		public ProductBestWoschtBuilder id(){
			this.id = ProductBestWoscht.counter.getAndIncrement();
			return this;
		}
		
		public ProductBestWoschtBuilder id(long id){
			this.id = id;
			return this;
		}
		
		public ProductBestWoschtBuilder name( String name){
			this.name = name;
			return this;
		}
		
		public ProductBestWoschtBuilder info(String info){
			this.info = info;
			return this;
		}
		public ProductBestWoschtBuilder prize(float prize){
			this.prize = prize;
			return this;
		}
		public ProductBestWoschtBuilder volume( float volume){
			this.volume = this.volume;
			return this;
		}
		public ProductBestWoscht build(){
			return new ProductBestWoscht(this);
		}
		
		@Override
		public String toString(){
			return "ID: " + id + "\n"
					+ "Name: " + name + "\n"
					+ "Info: " + info + "\n"
					+ "Prize: " + prize + "\n"
					+ "Volume: "+ volume + "\n";
		}
		
	}
}
