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

	@PostConstruct //Application 시작 전 실행하는 어노테이션
	public void postConstruct() {
		kospiandexchange();
		stock();
		AccountInfo();
		ProfitChart();
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
	
	public void stock() {
		String shinpredict = "004170action_channel";
		String shinfoodpredict = "031440action_channel";
		String emartpredict = "139480action_channel";
		
		String price_004170 = "price_004170";
		String price_031440 = "price_031440";
		String price_139480 = "price_139480";
		
		
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinpredict));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinfoodpredict));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(emartpredict));
		
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(price_004170));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(price_031440));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(price_139480));
	}

	public void AccountInfo() {
		
		// 주문체결 내역
		String ordertime = "ordertime"; 		// 주문시간
		String excepttime = "excepttime";		// 체결시간
		String ordernum = "ordernum";			// 주문번호
		String stockname = "stockname";			// 종목명
		String orderprice = "orderprice";		// 주문가
		String exceptprice = "exceptprice";		// 체결가
		String exceptqty = "exceptqty";			// 체결수량
		String gubun = "gubun";					// 주문유형
		
		
		String balanceevaluationamount = "balanceevaluationamount";		// 잔고평가금액
		String investmentincome = "investmentincome";					// 투자손익금액
		String jejus = "jejus";											// 예수금
		String d1jejus = "d1jejus";										// D+! 예수금
		String d2jejus = "d2jejus";										// D+2 예수금
		String profitrate = "profitrate";								// 손익률

		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(ordertime));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(excepttime));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(ordernum));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(stockname));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(orderprice));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(exceptprice));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(exceptqty));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(gubun));
		
		
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(balanceevaluationamount));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(investmentincome));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(jejus));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(d1jejus));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(d2jejus));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(profitrate));
	}
	
	public void ProfitChart() {
		
		String shinpredicttime = "004170timepv";
		String shinfoodpredicttime = "031440timepv";
		String emartpredicttime = "139480timepv";
		
		String datetime = "datetime";
		String shinprofit = "shinprofit";
		String shinfoodprofit = "foodprofit";
		String emartprofit = "emartprofit";
		String profitratechart = "profitratechart";
		
		
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinpredicttime));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinfoodpredicttime));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(emartpredicttime));
		
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(datetime));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinprofit));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(shinfoodprofit));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(emartprofit));
		redisMessageListenerContainer.addMessageListener(redisMessageListener, new ChannelTopic(profitratechart));
	}
}
