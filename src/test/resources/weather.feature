Feature: Weather

  Scenario: Check correct Weather data
    Given show test name


  Scenario: Checking coordinates for city
    Given city "London"
    And country "UK"

    When we are requesting weather data

    Then lon is -0.13
    And lat is 51.51

    And weather id is 300
    And weather main is Drizzle
    And weather description is "light intensity drizzle"
    And weather icon is 09d

    And base is stations

    And main temp is 280.32
    And main pressure is 1012
    And main humidity is 81
    And main temp_min is 279.15
    And main temp_max is 281.15

    And visibility is 10000

    And wind speed is 4.1
    And wind deg is 80

    And clouds all is 90

    And dt is 1485789600

    And sys type is 1
    And sys id is 5091
    And sys message is 0.0103
    And sys country is GB
    And sys sunrise is 1485762037
    And sys sunset is 1485794875

    And id is 2643743
    And name is "London"
    And cod is 200

