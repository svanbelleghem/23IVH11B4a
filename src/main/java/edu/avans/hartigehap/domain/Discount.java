package edu.avans.hartigehap.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Discount")
// images are stored in a separate database table (optional)
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = true, of = {})
@NoArgsConstructor
public class Discount extends DomainObjectNaturalId {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "Discount")
	public double discount;
	@Column(name = "PeriodStart")
	public Date periodStart;
	@Column(name = "PeriodEnd")
	public Date periodEnd;
	
	public Discount(String id, double discount, Date periodStart, Date periodEnd){
		super(id);
		this.discount = discount;
		this.periodStart = periodStart;
		this.periodEnd = periodEnd;
	}
}
