package com.groupthree.bean;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class PersonDetails {
		private int pId;
		private String personName;
		private long personPhoneNo;
		
		public PersonDetails() {
			
		}

		public PersonDetails(int pId, String personName, long personPhoneNo) {
			super();
			this.pId = pId;
			this.personName = personName;
			this.personPhoneNo = personPhoneNo;
		}

		public int getpId() {
			return pId;
		}

		public void setpId(int pId) {
			this.pId = pId;
		}

		public String getPersonName() {
			return personName;
		}

		public void setPersonName(String personName) {
			this.personName = personName;
		}

		public long getPersonPhoneNo() {
			return personPhoneNo;
		}

		public void setPersonPhoneNo(long personPhoneNo) {
			this.personPhoneNo = personPhoneNo;
		}

		@Override
		public String toString() {
			return "PersonDetails [pId=" + pId + ", personName=" + personName + ", personPhoneNo=" + personPhoneNo
					+ "]";
		}
}
