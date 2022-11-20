package com.exercise.util.converter;

import com.exercise.model.IModel;

/**
 * @author Caio Calo
 * @since 0.0.1
 */
public interface IConverter<T extends IModel> {

	T convertFromJson(Object object);

}
