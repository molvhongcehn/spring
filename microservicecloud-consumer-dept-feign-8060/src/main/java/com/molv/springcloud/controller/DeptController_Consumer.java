package com.molv.springcloud.controller;

import com.molv.springcloud.entities.Dept;
import com.molv.springcloud.service.DeptApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private DeptApiService deptService;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(Dept dept) {//没有RequestBody，则浏览器直接consumer/dept/add?dname=test添加
        //return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", dept, Boolean.class);
        return deptService.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        //return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
        return deptService.get(id);
    }


    @RequestMapping(value = "/consumer/dept/list", method = RequestMethod.GET)
    public List<Dept> list() {
        //return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
        return deptService.list();
    }

    //消费端可以调用服务发现
    /*@RequestMapping(value = "/consumer/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }*/

}
