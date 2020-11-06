package com.quovantis.recruiting;

import com.quovantis.recruiting.domain.Candidate;
import com.quovantis.recruiting.domain.Offer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RecruitingApplicationTests
{
	@LocalServerPort
	int randomServerPort;

	@Test
	public void testAddCandidateSuccess() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:"+randomServerPort+"/CreateCandidate/";
		URI uri = new URI(baseUrl);
		Candidate candidate= new Candidate("test@email.com","abhinav");

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<Candidate> request = new HttpEntity<>(candidate, headers);

		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

		//Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());
	}
	@Test
	public void testCreateOfferSuccess() throws URISyntaxException
	{
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = "http://localhost:"+randomServerPort+"/CreateOffer/";
		URI uri = new URI(baseUrl);
		Offer offer= new Offer("java","1/11/2020",null);

		HttpHeaders headers = new HttpHeaders();
		headers.set("X-COM-PERSIST", "true");

		HttpEntity<Offer> request = new HttpEntity<>(offer, headers);

		ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

		//Verify request succeed
		Assertions.assertEquals(200, result.getStatusCodeValue());
	}
}