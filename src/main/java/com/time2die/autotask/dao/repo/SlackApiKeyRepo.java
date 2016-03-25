package com.time2die.autotask.dao.repo;

import com.time2die.autotask.dao.SlackApiKey;
import org.apache.log4j.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Aleksandr Karpov AV.Karpov@bssys.com
 */
@Repository
public interface SlackApiKeyRepo extends JpaRepository<SlackApiKey,Long> {
}