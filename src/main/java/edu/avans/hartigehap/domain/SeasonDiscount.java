package edu.avans.hartigehap.domain;

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

	private static final long serialVersionUID = 1L;
	
	public SeasonDiscount(String id, double discount, Date periodStart, Date periodEnd) {
		super(id, discount, periodStart, periodEnd);
	}
}
