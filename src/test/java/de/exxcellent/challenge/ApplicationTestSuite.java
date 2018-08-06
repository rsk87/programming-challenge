/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.exxcellent.challenge;

import de.exxcellent.challenge.domain.WeatherDomainTest;
import de.exxcellent.challenge.repository.WeatherRepositoryTest;
import de.exxcellent.challenge.service.FullApplicationTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 *
 * @author c.kaddatz
 */
@RunWith(Suite.class) 
@SuiteClasses({
    WeatherRepositoryTest.class,
    WeatherDomainTest.class,
    FullApplicationTest.class
})
public class ApplicationTestSuite {
  // the class remains empty,
}
