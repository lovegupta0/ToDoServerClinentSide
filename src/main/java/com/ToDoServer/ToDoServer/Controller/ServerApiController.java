package com.ToDoServer.ToDoServer.Controller;

import com.ToDoServer.ToDoServer.Config.Url;
import com.ToDoServer.ToDoServer.Model.ToDoData;
import com.ToDoServer.ToDoServer.Model.Users;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class ServerApiController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    Url url;

    @GetMapping("/")
    public String working(){
        System.out.println(url.dataUrl());
        System.out.println(url.userUrl());
        return "Main server working";
    }

    @PostMapping("/api/getdata")
    public String getData(@RequestParam(name="email") String email){
        String api=url.dataUrl()+"/api/getdata?email="+email;
        return restTemplate.postForObject(api,"",String.class);
    }
    @PostMapping("/api/adduser")
    public String addUser(@RequestBody Users users){

        String api=url.userUrl()+"/api/add";
        return restTemplate.postForObject(api,users,String.class);

    }
    @PostMapping("/api/check")
    public String check(@RequestParam("email") String email,@RequestParam("password") String password){
        String api=url.userUrl()+"/api/verify?email="+email+"&password="+password;
        return restTemplate.postForObject(api,"",String.class);
    }

    @PostMapping("/api/adddata")
    public String addData(@RequestBody ToDoData data){
        String api=url.dataUrl()+"/api/add";
        return restTemplate.postForObject(api,data,String.class);
    }
    @PostMapping("/api/done")
    public String updateDone(@RequestParam(name="id") int id){
        String api=url.dataUrl()+"/api/updatedone?id="+id;
        return restTemplate.postForObject(api,"", String.class);
    }
    @PostMapping("/api/body")
    public String updateBody(@RequestParam(name="body") String body,@RequestParam(name="id") int id){
        String api=url.dataUrl()+"/api/updatebody?done"+body+"&id="+id;
        return restTemplate.postForObject(api,"", String.class);
    }
    @PostMapping("/api/delete")
    public String deleteData(@RequestParam(name="id") int id){
        String api=url.dataUrl()+"/api/deletedata?id="+id;
        return restTemplate.postForObject(api,"", String.class);
    }
}
