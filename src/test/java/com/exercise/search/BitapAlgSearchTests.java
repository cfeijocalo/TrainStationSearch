package com.exercise.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.exercise.model.Station;
import com.exercise.model.TrainStations;

/**
 * 
 * @author Caio Calo
 * @since 0.0.1
 */
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@ContextConfiguration(classes = BitapAlgSearch.class)
class BitapAlgSearchTests {

	TrainStations trainStations;

	@BeforeAll
	void init() {
		trainStations = TrainStations.builder().stations(Set.of(
				Station.builder().name("castelo branco").build(),
				Station.builder().name("santos").build(),
				Station.builder().name("santa margarida").build(),
				Station.builder().name("santo tirso").build(),
				Station.builder().name("santo amaro de oeiras").build(),
				Station.builder().name("oeiras").build(),
				Station.builder().name("alegria").build(),
				Station.builder().name("baixa da banheira").build()))
				.build();
	}

	@Test
	void testSearchCompleteWord() {
		assertEquals(1,
				trainStations.getStations().stream().filter(
						station -> BitapAlgSearch.search("alegria".toCharArray(), station.getName().toCharArray()) != -1)
						.count());
	}
	
	@Test
	void testSearchInitWith() {
		assertEquals(4,
				trainStations.getStations().stream().filter(
						station -> BitapAlgSearch.search("sant".toCharArray(), station.getName().toCharArray()) != -1)
						.count());
	}
	
	@Test
	void testSearchWordAppearsMoreThanOneTime() {
		assertEquals(3,
				trainStations.getStations().stream().filter(
						station -> BitapAlgSearch.search("santo".toCharArray(), station.getName().toCharArray()) != -1)
						.count());
		assertEquals(2,
				trainStations.getStations().stream().filter(
						station -> BitapAlgSearch.search("oeiras".toCharArray(), station.getName().toCharArray()) != -1)
						.count());
	}
	
	@Test
	void testSearchAppearOneTime() {
		assertEquals(1,
				trainStations.getStations().stream().filter(
						station -> BitapAlgSearch.search("castelo branco".toCharArray(), station.getName().toCharArray()) != -1)
						.count());
		
		assertEquals(1,
				trainStations.getStations().stream().filter(
						station -> BitapAlgSearch.search("santo amaro".toCharArray(), station.getName().toCharArray()) != -1)
						.count());
	}
	
	@Test
	void testSearchNoneMatch() {
		assertEquals(0,
				trainStations.getStations().stream().filter(
						station -> BitapAlgSearch.search("jujuba".toCharArray(), station.getName().toCharArray()) != -1)
						.count());
	}
}
