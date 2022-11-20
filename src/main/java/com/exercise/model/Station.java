package com.exercise.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode
public class Station implements IModel {

	private String name;

}
