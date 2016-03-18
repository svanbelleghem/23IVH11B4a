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
public class HolidayDiscount extends Discount{

	public HolidayDiscount(String id, double discount, Date periodStart, Date periodEnd) {
		super(id, discount, periodStart, periodEnd);
	}
	public Date periodstart;
	public Date periodend;
	public double discount;
	public HolidayDiscount discounts;
	
	public HolidayDiscount summerVacation(HolidayDiscount discounts) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = "01-03-"+Calendar.getInstance().get(Calendar.YEAR);
		String date2 = "31-05-"+Calendar.getInstance().get(Calendar.YEAR);
		discounts.periodstart = sdf.parse(date);
		discounts.periodend = sdf.parse(date2);
		discounts.discount = 0.9;
		
		return discounts;
	}
	
}
