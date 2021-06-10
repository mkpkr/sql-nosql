package com.mike.sqlvsnosql.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="addresses")
public class Address {
	
	@Id
//	@Column(name = "user_id")
	private Long id;
	
	@OneToOne
//    @MapsId
    @JoinColumn(name = "user_id")
	private User user;
	
	private int aptNo;
	private String line1;
	private String line2;
	
	@Enumerated(EnumType.STRING)
//    @Column(length = 8)
	private Country country;
	private String zip;
	
	
	
	
	

}
