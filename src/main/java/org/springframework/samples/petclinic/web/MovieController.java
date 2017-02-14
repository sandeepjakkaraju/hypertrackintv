/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.samples.petclinic.model.Hall;
import org.springframework.samples.petclinic.model.Movie;
import org.springframework.samples.petclinic.service.ClinicService;
import org.springframework.samples.petclinic.util.MoviesDataImporter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import com.vividsolutions.jts.io.ParseException;

/**
 * @author Juergen Hoeller
 * @author Ken Krebs
 * @author Arjen Poutsma
 */
@Controller
public class MovieController {

	@Autowired
	ClinicService impl;

	@RequestMapping(value = "/getMovies", method = RequestMethod.GET)
	public @ResponseBody List<Movie> initCreationForm(HttpServletRequest request) throws ParseException {

		System.out.println(request.getParameter("term"));
		String inp = request.getParameter("term");
		return impl.getMovies(inp);
	}

	@RequestMapping(value = "/loadMovies", method = RequestMethod.GET)
	public void load(HttpServletRequest request) throws ParseException, IOException {
		{
			BufferedReader bf = new BufferedReader(
					new InputStreamReader(new ClassPathResource("data.csv").getInputStream()));

			String line = bf.readLine();
			System.out.println(line);

			line = bf.readLine();
			while (line != null) {
				String[] cols = line.split(",");

				if (cols.length >= 2) {
					String title = cols[0].trim();
					String add = cols[1].trim();
					if (!add.trim().equals("") && !title.trim().equals("")) {
						// GeoApiContext context = new
						// GeoApiContext().setApiKey("AIzaSyCvcFDeU-VUwZmOq0tOydJYdsMBQJ7txPk");
						GeoApiContext context = new GeoApiContext()
								.setApiKey("AIzaSyBMADpfhEJsWT6Dfkpk7C703Gq-wTjjWt0");

						GeocodingResult[] results = null;
						try {
							results = GeocodingApi.geocode(context, add).await();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						if (results.length > 0) {
							System.out.println(title);
							System.out.println(results[0].formattedAddress);
							System.out
									.println(results[0].geometry.location.lat + "," + results[0].geometry.location.lng);

							List<Movie> ml = impl.getMovies(title);

							Movie m = null;
							Hall mh = null;

							if (ml.size() > 0) {
								m = ml.get(0);
								mh = new Hall(add, "" + results[0].geometry.location.lat,
										"" + results[0].geometry.location.lng);
							} else {
								m = new Movie(title);
								mh = new Hall(add, "" + results[0].geometry.location.lat,
										"" + results[0].geometry.location.lng);
							}

							m.getHalls().add(mh);
							try {
								impl.saveMovie(m);
							} catch (Exception e) {
								e.printStackTrace();
							}

						}
					}
				}
				line = bf.readLine();
			}
		}
	}
}
