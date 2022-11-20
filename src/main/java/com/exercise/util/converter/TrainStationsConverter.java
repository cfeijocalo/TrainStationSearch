package com.exercise.util.converter;

import com.exercise.model.TrainStations;
import com.exercise.util.JSONUtils;

/**
 * 
 * @author Caio Calo
 * @since 0.0.1
 */
public class TrainStationsConverter implements IConverter<TrainStations> {

	@Override
	public TrainStations convertFromJson(Object object) {
		return (TrainStations) JSONUtils.getJSON((String) object, TrainStations.class);
	}

}
