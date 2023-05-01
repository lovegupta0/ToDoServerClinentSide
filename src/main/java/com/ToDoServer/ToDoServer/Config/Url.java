package com.ToDoServer.ToDoServer.Config;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Url {
    @Autowired
    EurekaClient client;
    public String dataUrl(){
        InstanceInfo serverData=client.getNextServerFromEureka("user-data",false);
        return serverData.getHomePageUrl();
    }

    public String userUrl(){
        InstanceInfo serverUser=client.getNextServerFromEureka("user-server",false);
        return serverUser.getHomePageUrl();
    }
}
