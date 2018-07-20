package sample.mybatis.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.mybatis.domain.City;
import sample.mybatis.mapper.CityMapper;

@RestController
@RequestMapping("/test")
public class Controller {

  @Autowired
  private CityMapper cityMapper;
  @PostMapping("/findCity")
  public City[] findCity(@RequestBody City city) {
    City[] r;
    for(City c:this.cityMapper.findByState(city.getState())) {
      System.out.println(c);
    }
    r=this.cityMapper.findByState(city.getState());
    return r;
  }
}