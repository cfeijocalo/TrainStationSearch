package com.exercise.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.google.gson.Gson;

/**
 * 
 * @author Caio Calo
 * @since 0.0.1
 */
public class JSONUtils {

	public static final Logger LOGGER = LoggerFactory.getLogger(JSONUtils.class);

	private JSONUtils() {
	}

	public static Object getJSON(String pathToFile, Class<?> clazz) {
		try (InputStream file = new FileInputStream(ResourceUtils.getFile(pathToFile))) {
			Gson gson = new Gson();
			return gson.fromJson(new InputStreamReader(file), clazz);
		} catch (Exception e) {
			LOGGER.error("Exception on getJSON method", e);
		}
		return null;
	}

}
