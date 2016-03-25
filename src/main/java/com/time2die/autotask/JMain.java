package com.time2die.autotask;

import com.time2die.autotask.dao.SlackApiKey;
import com.time2die.autotask.dao.repo.SlackApiKeyRepo;
import com.time2die.autotask.slack.SlackService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Objects;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */

@SpringBootApplication
@Log4j
@Configuration
public class JMain {
    public static void main(String [] args){
        SpringApplication.run(JMain.class) ;
    }

    @Bean
    public Object init(SlackApiKeyRepo slackApiKeyRepo){
        if(slackApiKeyRepo.findAll().isEmpty()){
            SlackApiKey init = new SlackApiKey() ;
            init.setKey("xoxb-28589750389-szpZfPk2iZ4TQEwiUPWhVpJA");
        }

        return new Object() ;
    }

    @Bean
    public SlackService slackService(SlackApiKeyRepo slackApiKeyRepo, Object init){
        SlackService returnValue = new SlackService() ;
        returnValue.setSlackApiKeyRepo(slackApiKeyRepo);
        return  returnValue ;
    }
}