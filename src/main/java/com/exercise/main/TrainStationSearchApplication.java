package com.exercise.main;

import java.util.Optional;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exercise.model.TrainStations;
import com.exercise.search.BitapAlgSearch;
import com.exercise.util.converter.TrainStationsConverter;

/**
 * 
 * @author Caio Calo
 * @since 0.0.1
 */
@SpringBootApplication
public class TrainStationSearchApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(TrainStationSearchApplication.class);

	private TrainStations trainStations;

	public static void main(String[] args) {
		SpringApplication.run(TrainStationSearchApplication.class, args);
		TrainStationSearchApplication app = new TrainStationSearchApplication();
		LOGGER.info("Application started");
		app.populateStations();
		app.init();
	}

	private void init() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("TRAIN STATION: ");
			String pattern = scanner.nextLine();
			findPattern(pattern.toLowerCase());
		} catch (Exception e) {
			LOGGER.error("Exception on init method", e);
		}
	}

	private void findPattern(String pattern) {
		Optional.ofNullable(trainStations.getStations()).ifPresentOrElse(stations -> stations.forEach(station -> {
			if (BitapAlgSearch.search(pattern.toCharArray(), station.getName().toCharArray()) != -1) {
				System.out.println(station.getName());
			}
		}), () -> LOGGER.info("Stations aren't populated correctly"));
	}

	private void populateStations() {
		LOGGER.info("Populating stations Set");
		TrainStationsConverter converter = new TrainStationsConverter();
		trainStations = converter.convertFromJson("classpath:stations.json");
		LOGGER.info("Populated stations Set");
	}

}
