/*
 * Copyright 2012-2013 the original author or authors.
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

package org.asgs.lms.data.jpa.web;

import org.asgs.lms.data.jpa.domain.City;
import org.asgs.lms.data.jpa.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

  @Autowired private CityService cityService;

  @RequestMapping("/")
  @ResponseBody
  @Transactional(readOnly = true)
  public String helloWorld(
      @RequestParam(required = false) String city, @RequestParam(required = false) String country) {
    String prefix =
        String.format("The city of %s in the country %s is located in the state ", city, country);
    City cityObject = this.cityService.getCity(city, country);
    String responseContent = prefix + (cityObject != null ? cityObject.getState() : "Unknown");
    return responseContent;
  }
}
