package edu.avans.hartigehap.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
@Getter
@Setter
@ToString(callSuper = true, includeFieldNames = true, of = {})
@NoArgsConstructor
public class SeasonDiscount extends Discount {

	public SeasonDiscount(String id, double discount, Date periodStart, Date periodEnd) {
		super(id, discount, periodStart, periodEnd);
	}
	
	public Date periodstart;
	public Date periodend;
	public double discount;
	public SeasonDiscount discounts;
	

	@Override
	public double getDiscount() {
		return discounts.discount;
	}
	
	public SeasonDiscount springDiscount(SeasonDiscount discounts) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = "01-03-"+Calendar.getInstance().get(Calendar.YEAR);
		String date2 = "31-05-"+Calendar.getInstance().get(Calendar.YEAR);
		discounts.periodstart = sdf.parse(date);
		discounts.periodend = sdf.parse(date2);
		discounts.discount = 0.9;
		
		return discounts;
	}
	
	public SeasonDiscount winterDiscount(SeasonDiscount discounts) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = "01-12-"+Calendar.getInstance().get(Calendar.YEAR);
		String date2 = "02-28-"+Calendar.getInstance().get(Calendar.YEAR+1);
		discounts.periodstart = sdf.parse(date);
		discounts.periodend = sdf.parse(date2);
		discounts.discount = 0.75;
		
		return discounts;
	}
	
	public SeasonDiscount summerDiscount(SeasonDiscount discounts) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = "01-06-"+Calendar.getInstance().get(Calendar.YEAR);
		String date2 = "31-08-"+Calendar.getInstance().get(Calendar.YEAR);
		discounts.periodstart = sdf.parse(date);
		discounts.periodend = sdf.parse(date2);
		discounts.discount = 0.95;
		
		return discounts;
	}
	
	public SeasonDiscount fallDiscount(SeasonDiscount discounts) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = "01-09-"+Calendar.getInstance().get(Calendar.YEAR);
		String date2 = "30-11-"+Calendar.getInstance().get(Calendar.YEAR);
		discounts.periodstart = sdf.parse(date);
		discounts.periodend = sdf.parse(date2);
		discounts.discount = 0.95;
		
		return discounts;
	}
}
