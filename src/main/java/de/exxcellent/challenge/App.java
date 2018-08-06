package de.exxcellent.challenge;

import de.exxcellent.challenge.domain.exception.FootballDomainException;
import de.exxcellent.challenge.domain.exception.WeatherDomainException;
import de.exxcellent.challenge.repository.impl.FootballFileRepositoryImpl;
import de.exxcellent.challenge.repository.impl.WeatherFileRepositoryImpl;
import de.exxcellent.challenge.service.IFootballApplicationService;
import de.exxcellent.challenge.service.IWeatherApplicationService;
import de.exxcellent.challenge.service.impl.FootballApplicationServiceImpl;
import de.exxcellent.challenge.service.impl.WeatherApplicationServiceImpl;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {
    
    private static final String WEATHER_CSV_FILE_NAME = "de/exxcellent/challenge/weather.csv";
    private static final String FOOTBALL_CSV_FILE_NAME = "de/exxcellent/challenge/football.csv";
    private static final String DEFAULT_CSV_DELIMITER = ",";

    public static void main(String... args) throws WeatherDomainException, FootballDomainException {
        
        IWeatherApplicationService weatherService = new WeatherApplicationServiceImpl(new WeatherFileRepositoryImpl(WEATHER_CSV_FILE_NAME, DEFAULT_CSV_DELIMITER));
        IFootballApplicationService footballService = new FootballApplicationServiceImpl(new FootballFileRepositoryImpl(FOOTBALL_CSV_FILE_NAME, DEFAULT_CSV_DELIMITER));

        String dayWithSmallestTempSpread = weatherService.getDayWithSmallestTempSpread();     // Your day analysis function call …
        String teamWithSmallesGoalSpread = footballService.getTeamWithSmallestGoalDistance(); // Your goal analysis function call …

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallesGoalSpread);
    }
}
