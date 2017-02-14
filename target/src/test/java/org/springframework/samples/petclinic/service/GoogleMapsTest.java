package org.springframework.samples.petclinic.service;

import org.junit.Test;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class GoogleMapsTest {

	@Test
	public void test() {

		GeoApiContext context = new GeoApiContext().setApiKey("AIzaSyCvcFDeU-VUwZmOq0tOydJYdsMBQJ7txPk");
		GeocodingResult[] results =null;
		try {
			results = GeocodingApi.geocode(context,"1600 Amphitheatre Parkway Mountain View, CA 94043").await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(results[0].formattedAddress);
		System.out.println(results[0].geometry.location.lat+","+results[0].geometry.location.lng);
		
	}

}
