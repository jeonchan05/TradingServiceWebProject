package com.final_project.stock.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.web.bind.annotation.RestController;

import com.final_project.stock.redis.RedisMessageListener;

@RestController
public class RedisController {

    private final RedisMessageListener redisMessageListener;
    private final RedisMessageListenerContainer redisMessageListenerContainer;

    @Autowired
    public RedisController(RedisMessageListener redisMessageListener, RedisMessageListenerContainer redisMessageListenerContainer) {
        this.redisMessageListener = redisMessageListener;
        this.redisMessageListenerContainer = redisMessageListenerContainer;
    }
    
    @PostConstruct
    public void postConstruct() {
        startRedisSubscription();
    }

    public void startRedisSubscription() {
        String kospivaluechannel = "kospivalue";
        String kospidatechannel = "kospidate";
        String exchangeusdchannel = "exchangeusd";
        String exchangecnychannel = "exchangecny";
        
        String kospivaluemin = "kospivaluemin";
        String kospidatemin = "kospidatemin";
        String exchangedatemin = "exchangedatemin";
        String exchangeusdmin = "exchangeusdmin";
        String exchangecnymin = "exchangecnymin";
        
        String shin = "price_004170";
        String shinfood = "price_031440";
        String emart = "price_139480";
        
        String shinpredict = "004170action_channel";
        String shinfoodpredict = "031440action_channel";
        String emartpredict = "139480action_channel";
        
        String odrbqty = "odrbqty";
        String trbqty = "trbqty";
        String avalpri = "avalpri";
        String valgalo = "valgalo";
        String garate = "garate";
        
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(kospivaluechannel));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(kospidatechannel));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(exchangeusdchannel));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(exchangecnychannel));
        
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(kospivaluemin));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(kospidatemin));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(exchangedatemin));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(exchangeusdmin));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(exchangecnymin));
        
        
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shin));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinfood));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(emart));
        
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinpredict));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinfoodpredict));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(emartpredict));
        
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(odrbqty));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(trbqty));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(avalpri));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(valgalo));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(garate));
    }
}



