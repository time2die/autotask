package com.time2die.autotask.dao;

import lombok.Data;
import org.apache.log4j.Logger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
@Entity
@Data
public class SlackApiKey {
    private static final Logger LOGGER = Logger.getLogger(SlackApiKey.class);

    @Id
    @GeneratedValue
    Long id;

    String key;
}