package com.example.supermarket.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
        @Id
        String cid;
        String cname,address;
        int phoneno;
		public String getCid() {
			return cid;
		}
		public void setCid(String cid) {
			this.cid = cid;
		}
		public String getCname() {
			return cname;
		}
		public void setCname(String cname) {
			this.cname = cname;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public int getPhoneno() {
			return phoneno;
		}
		public void setPhoneno(int phoneno) {
			this.phoneno = phoneno;
		}

}
