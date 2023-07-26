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
	public RedisController(RedisMessageListener redisMessageListener,
			RedisMessageListenerContainer redisMessageListenerContainer) {
		this.redisMessageListener = redisMessageListener;
		this.redisMessageListenerContainer = redisMessageListenerContainer;
	}

	@PostConstruct
	public void postConstruct() {
		kospiandexchange();
		Stock();
		AccountInfo();
	}

	public void kospiandexchange() {

		String kospivaluechannel = "kospivalue";
		String kospidatechannel = "kospidate";
		String exchangeusdchannel = "exchangeusd";
		String exchangecnychannel = "exchangecny";
		String kospivaluemin = "kospivaluemin";
		String kospidatemin = "kospidatemin";
		String exchangedatemin = "exchangedatemin";
		String exchangeusdmin = "exchangeusdmin";

		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(kospivaluechannel));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(kospidatechannel));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(exchangeusdchannel));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(exchangecnychannel));

		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(kospivaluemin));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(kospidatemin));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(exchangedatemin));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(exchangeusdmin));
	}

	public void Stock() {
        
        
        String shin = "price_004170";
        String shinfood = "price_031440";
        String emart = "price_139480";
        
        String shinpredict = "004170action_channel";
        String shinfoodpredict = "031440action_channel";
        String emartpredict = "139480action_channel";
        
        String shinchart = "004170pv";
        String shinfoodchart ="031440pv";
        String emartchart ="139480pv";
        
        
        
        
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shin));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinfood));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(emart));
        
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinpredict));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinfoodpredict));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(emartpredict));
        
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinchart));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinfoodchart));
        redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(emartchart));
	}

	public void AccountInfo() {
		String odrbqty = "odrbqty";
		String trbqty = "trbqty";
		String avalpri = "avalpri";
		String valgalo = "valgalo";
		String garate = "garate";

		String datetime = "datetime";
		String odrnum = "odrnum";
		String stcode = "stcode";
		String stname = "stname";
		String odrqty = "odrqty";
		String trallqty = "trallqty";
		String trqty = "trqty";
		String trprice = "trprice";
		String odrgubun = "odrgubun";
		String trgubun = "trgubun";

		String test = "my_channel";

		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(odrbqty));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(trbqty));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(avalpri));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(valgalo));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(garate));

		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(datetime));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(odrnum));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(stcode));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(stname));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(odrqty));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(trallqty));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(trqty));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(trprice));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(odrgubun));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(trgubun));

		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(test));
	}
}
