# wm-coding-challenge
GeoCoding
README.TXT
Name: Victor Obiahu
WM Coding Challenge
Date: October 22nd 2019

PROMPT

Write a production-ready Spring Boot app that supports a rate-limited, POST endpoint to geocode an address. 
Requirements 
The endpoint should accept an address, call the google maps API to determine its latitude and longitude coordinates, and return the result in a JSON format. 
The google maps API call will be protected by a rate-limiter. You will implement this limiter, capping the number of retries to a maximum of 5. If an address cannot 
be geolocated, or the maximum number of retries has been exceeded, indicate in the response that geolocation was unsuccessful. 


Google Maps API: https://maps.googleapis.com/maps/api/geocode/json?address=<address string> 

API Key: AIzaSyD2WijYaqFSa9skqpqXIyy1Sy2yiFdyX6s

Classes:
I wrote the ChallengeApplication class to run the Spring Boot Project
I also wrote the ApiKeyConfiguration.java class to extract the apiKey from the applications.properties file
The GeoCodingController worked to serve as the POST Method which accepted addresses and returned results as JSON

Wrote a GeoCodingRateLimiter class with a rate limiter function that mirrored the rolling window algorithm and used Queues, set the limit to 5 and included a time 
frame of 1 minute to mirror specifications
There was also a main method to test the API Rate Limiter locally which passed

I tried leveraging Spring Cloud Netflix Zuul which is an open source gateway that wraps Netflix Zuul because rate limiting is not provided out of the box.

I tried handling configuration according in the application.yml file

GeoCoding.java and GeoCodingOutput.java worked with handling address input and formatting options

Ran out of time to write exhaustive test cases for this
Application should be run first on ChallengeApplication.java for SpringBoot to hit the googleMaps API
GeoCodingRateLimiter.java can be run as a regular Java App for local tests
