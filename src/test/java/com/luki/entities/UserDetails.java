package com.luki.entities;

// use this instead of hibernate's annotation class
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/*
 * to generate getters and setters,
 * use ALT+SHIFT+R+S
 * 
 * this tutorial is using annotations, xml mapping coming soon
 */

@Entity
@Table (name = "USER_DETAILS")
public class UserDetails {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int userId; 
	private String userName;
	@Temporal (TemporalType.DATE)  /* yang disimpen tanggal aja tanpa timestamp */
	private Date joinedDate;
	@Lob /* kolom nya jadi blob (large objects / ) */
	private String description;
	@ElementCollection
	@JoinTable(
		name="user_address",						// ini untuk kasih nama tabel untuk address nya (default nya namaclass_namahashset -> UserDetails_listOfAddress)
		joinColumns=@JoinColumn(name="user_id")		// ini untuk kasih nama kolom foreign key nya (user id nya)
	)
	@GenericGenerator(								// ini untuk generator primary key address nya yang dipake sama @CollectionId..please note kalau ini import nya dari org.hibernate dan bukan javax.persistence
		name = "hilo-gen", strategy = "hilo"		// hilo ini standard hibernate untuk generator id nya.. (pelajari lagi jenis strategi nya apa lagi)
	)
	@CollectionId(									// untuk bikin id nya.. please note kalau ini import nya dari org.hibernate dan bukan javax.persistence
		columns = { @Column(name="address_id") }, generator = "hilo-gen", type = @Type(type = "long")
	)
	private Collection<Address> listOfAddresses = new ArrayList<Address>( ); // supaya support id nya, dirubah jadi pake ArrayList 
	
	//@Embedded
		//private Address address;
	
	/*public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}*/
	
	public String getDescription() {
		return description;
	}
	/*public Set<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Set<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}*/
	public void setDescription(String description) {
		this.description = description;
	}
	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
}
