package com.feg.betting.model;

import javax.persistence.AttributeConverter;

public class SportAttributeConverter implements AttributeConverter<Sport, Integer>{

	@Override
	public Integer convertToDatabaseColumn(Sport attribute) {
		if (attribute == null)
			return null;
		return attribute.getCode();
	}

	@Override
	public Sport convertToEntityAttribute(Integer dbData) {
		if (dbData == null)
			return null;
		return Sport.valueOf(dbData);
	}

}
