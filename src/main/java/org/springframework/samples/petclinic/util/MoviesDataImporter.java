/**
 * 
 */
package org.springframework.samples.petclinic.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Movie;
import org.springframework.samples.petclinic.service.ClinicService;

import com.fasterxml.jackson.databind.cfg.ContextAttributes.Impl;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

/**
 * @author sandeep
 *
 */
public class MoviesDataImporter {

	 @Autowired
	  ClinicService impl;
	/**
	 * 
	 */
	public MoviesDataImporter() {
		// TODO Auto-generated constructor stub
	}

	public static void importMoviesData(File file) throws IOException
	{
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
