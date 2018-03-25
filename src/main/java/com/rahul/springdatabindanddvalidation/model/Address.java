package com.rahul.springdatabindanddvalidation.model;

public class Address {
		
		private String city;
		private String state;
		private long pincode;
		
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public long getPincode() {
			return pincode;
		}
		public void setPincode(long pincode) {
			this.pincode = pincode;
		}
		@Override
		public String toString() {
			return "Address [city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
		}
		
		
		
}
