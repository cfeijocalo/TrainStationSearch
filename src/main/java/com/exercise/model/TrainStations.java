package com.exercise.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Caio Calo
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
public class TrainStations implements IModel {

	@Default
	private Set<Station> stations = new HashSet<>();

}
