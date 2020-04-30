package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

public class WeatherStepDefs {
    private String cityName;
    private String country;
    private Response response;

    @Given("show test name")
    public void show_test_name() {
        System.out.println("Hello cucumber!");
    }

    @Given("city {string}")
    public void set_city(String cityName){
        this.cityName = cityName;
    }

    @Given("country {string}")
    public void set_country(String country){
        this.country = country;
    }

    @When("we are requesting weather data")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityName,country);

    }

    @Then("lon is {float}")
    public void check_lon(float lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong lon");
    }

    @Then("lat is {float}")
    public void check_lat(float lat){
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong lat");
    }

    @Then("weather id is {int}")
    public void check_weather_id(int id){
        Assertions.assertEquals(id, response.getWeather().get(0).getId(), "Wrong weather id");
    }

    @Then("weather main is {word}")
    public void check_weather_main(String main){
        Assertions.assertEquals(main, response.getWeather().get(0).getMain(), "Wrong weather main");
    }

    @Then("weather description is {string}")
    public void check_weather_description(String description){
        Assertions.assertEquals(description, response.getWeather().get(0).getDescription(), "Wrong weather description");
    }

    @Then("weather icon is {word}")
    public void check_weather_icon(String icon){
        Assertions.assertEquals(icon, response.getWeather().get(0).getIcon(), "Wrong weather icon");
    }

    @Then("base is {word}")
    public void check_base(String base) {
        Assertions.assertEquals(base, response.getBase(), "Wrong base");
    }

    @Then("main temp is {float}")
    public void check_main_temp(float temp) {
        Assertions.assertEquals(temp, response.getMain().getTemp(), "Wrong temp");
    }

    @Then("main pressure is {int}")
    public void check_main_pressure(int pressure) {
        Assertions.assertEquals(pressure, response.getMain().getPressure(), "Wrong pressure");
    }

    @Then("main humidity is {int}")
    public void check_main_humidity(int humidity) {
        Assertions.assertEquals(humidity, response.getMain().getHumidity(), "Wrong humidity");
    }

    @Then("main temp_min is {float}")
    public void check_main_temp_min(float temp_min) {
        Assertions.assertEquals(temp_min, response.getMain().getTemp_min(), "Wrong temp_min");
    }

    @Then("main temp_max is {float}")
    public void check_main_temp_max(float temp_max) {
        Assertions.assertEquals(temp_max, response.getMain().getTemp_max(), "Wrong temp_max");
    }

    @Then("visibility is {int}")
    public void check_visibility(int visibility) {
        Assertions.assertEquals(visibility, response.getVisibility(), "Wrong visibility");
    }

    @Then("wind speed is {float}")
    public void check_wind_speed(float speed) {
        Assertions.assertEquals(speed, response.getWind().getSpeed(), "Wrong wind speed");
    }

    @Then("wind deg is {int}")
    public void check_wind_deg(int deg) {
        Assertions.assertEquals(deg, response.getWind().getDeg(), "Wrong wind deg");
    }

    @Then("clouds all is {int}")
    public void check_cloud_all(int all) {
        Assertions.assertEquals(all, response.getClouds().getAll(), "All clouds are wrong");
    }

    @Then("dt is {int}")
    public void check_dt(int dt) {
        Assertions.assertEquals(dt, response.getDt(), "Wrong dt");
    }

    @Then("sys type is {int}")
    public void check_sys_type(int type) {
        Assertions.assertEquals(type, response.getSys().getType(), "Wrong sys type");
    }

    @Then("sys id is {int}")
    public void check_sys_id(int id) {
        Assertions.assertEquals(id, response.getSys().getId(), "Wrong sys ID");
    }

    @Then("sys message is {float}")
    public void check_sys_message(float message) {
        Assertions.assertEquals(message, response.getSys().getMessage(), "Wrong sys message");
    }

    @Then("sys country is {word}")
    public void check_sys_country(String country) {
        Assertions.assertEquals(country, response.getSys().getCountry(), "Wrong sys country");
    }

    @Then("sys sunrise is {int}")
    public void check_sys_sunrise(int sunrise) {
        Assertions.assertEquals(sunrise, response.getSys().getSunrise(), "Wrong sunrise");
    }

    @Then("sys sunset is {int}")
    public void check_sys_sunset(int sunset) {
        Assertions.assertEquals(sunset, response.getSys().getSunset(), "Wrong sunset");
    }

    @Then("id is {int}")
    public void check_id(int id) {
        Assertions.assertEquals(id, response.getId(), "Wrong ID");
    }

    @Then("name is {string}")
    public void check_name(String name) {
        Assertions.assertEquals(name, response.getName(), "Wrong name");
    }

    @Then("cod is {int}")
    public void check_cod(int cod) {
        Assertions.assertEquals(cod, response.getCod(), "Wrong cod");
    }

}
