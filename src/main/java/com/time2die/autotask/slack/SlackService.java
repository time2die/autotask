package com.time2die.autotask.slack;

import com.time2die.autotask.dao.SlackApiKey;
import com.time2die.autotask.dao.repo.SlackApiKeyRepo;
import com.ullink.slack.simpleslackapi.SlackSession;
import com.ullink.slack.simpleslackapi.events.SlackMessageEvent;
import com.ullink.slack.simpleslackapi.events.SlackMessagePosted;
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory;
import com.ullink.slack.simpleslackapi.listeners.SlackMessagePostedListener;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
@Log4j
@Data
public class SlackService {

    private SlackApiKeyRepo slackApiKeyRepo;

    @PostConstruct
    protected void addSlackListener() {
        log.error("in postconstruct");
        try {
            log.error("apileys: "+ slackApiKeyRepo.findAll());
            for (SlackApiKey keyIter : slackApiKeyRepo.findAll()) {
                try {
                    final SlackSession session = SlackSessionFactory.createWebSocketSlackSession(keyIter.getKey()) ;
                    log.error("start listening");
                    session.addMessagePostedListener(postedListener);
                    session.connect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SlackMessagePostedListener postedListener = new SlackMessagePostedListener() {
        @Override
        public void onEvent(SlackMessagePosted event, SlackSession session) {
            logMessages(event);
            session.sendMessage(event.getChannel(),"pong"+ event.getMessageContent()) ;
        }
    };

    private void logMessages(SlackMessageEvent event){

    }

}