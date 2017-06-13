package com.example.rest;

import java.nio.file.attribute.AclEntry.Builder;
import java.util.concurrent.atomic.AtomicLong;

public class ProductIkoy {
	private final long id;
	private final String name;
	private final String info;
	private final float prize;
	private final float volume;
	private static final AtomicLong counter = new AtomicLong(100);

	private ProductIkoy(ProductIkoyBuilder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.info = builder.info;
		this.prize = builder.prize;
		this.volume = builder.volume;
	}

	public ProductIkoy() {
		ProductIkoy proIkoy = new ProductIkoy.ProductIkoyBuilder().id().build();
		this.id = proIkoy.getId();
		this.name = proIkoy.getName();
		this.info = proIkoy.getInfo();
		this.prize = proIkoy.getPrize();
		this.volume = proIkoy.getVolume();
	}
	public ProductIkoy(long id, String name, String info, float prize,
			float volume){
		ProductIkoy proIkoy = new ProductIkoy.ProductIkoyBuilder().id()
				.name(name)
				.info(info)
				.prize(prize)
				.volume(volume)
				.build();
		this.id = proIkoy.getId();
		this.name = proIkoy.getName();
		this.info = proIkoy.getInfo();
		this.prize = proIkoy.getPrize();
		this.volume = proIkoy.getVolume();
	}

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

	@Override
	public String toString() {
		return "ID: " + id + "Name: " + name + "\n" + "Info: " + info + "\n" + "Prize: " + prize + "\n" + "Volume: "
				+ volume + "\n";
	}

	public static class ProductIkoyBuilder {
		private long id;
		private String name = "";
		private String info = "";
		private float prize = 0;
		private float volume = 0;

		public ProductIkoyBuilder id() {
			this.id = ProductIkoy.counter.getAndIncrement();
			return this;
		}

		public ProductIkoyBuilder id(long id) {
			this.id = id;
			return this;
		}

		public ProductIkoyBuilder name(String name) {
			this.name = name;
			return this;
		}

		public ProductIkoyBuilder info(String info) {
			this.info = info;
			return this;
		}

		public ProductIkoyBuilder prize(float prize) {
			this.prize = prize;
			return this;
		}

		public ProductIkoyBuilder volume(float volume) {
			this.volume = volume;
			return this;
		}

		public ProductIkoy build() {
			return new ProductIkoy(this);
		}

	}

}
