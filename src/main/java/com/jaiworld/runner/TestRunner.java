/**
 * 
 */
package com.jaiworld.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author jaideepvish
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/features", glue = {"com/jaiworld/stepdefinitions"})
public class TestRunner {

}
