package edu.avans.hartigehap.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
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
	public double discount = 1;
	@Column(name = "PeriodStart")
	public Date periodStart;
	@Column(name = "PeriodEnd")
	public Date periodEnd;
	
	public HandmadeDiscount handmadeDiscount;
	public HolidayDiscount holidayDiscount;
	public SeasonDiscount seasonDiscount;
	
	public Discount(String id, double discount, Date periodStart, Date periodEnd){
		super(id);
	}
	
	public double getDiscount(){
		return discount;
	}
	
	public void setHolidayDiscount(HolidayDiscount discount){
		this.holidayDiscount = discount;
	}
	
	public void setSeasonDiscount(SeasonDiscount discount){
		this.seasonDiscount = discount;
	}
	
	public void setHandmadeDiscount(HandmadeDiscount discount){
		this.handmadeDiscount = discount;
	}
	
	public HolidayDiscount getHDiscount(){
		return holidayDiscount;
	}
	
	public SeasonDiscount getSDiscount(){
		return seasonDiscount;
	}
	
	public HandmadeDiscount getHaDiscount(){
		return handmadeDiscount;
	}
	
	public Date getPeriodStart(){
		return periodStart;
	}
	
	public Date getPeriodEnd(){
		return periodEnd;
	}
}
