package com.final_project.stock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.final_project.stock.dao.ExchangeDao;
import com.final_project.stock.dao.KospiDao;
import com.final_project.stock.dao.StockProfitDao;
import com.final_project.stock.dto.ExchangeDto;
import com.final_project.stock.dto.KospiDto;
import com.final_project.stock.dto.StockProfitDto;
import com.final_project.stock.dto.TotalProfitDto;

@RestController
public class DataRestController {

	@Autowired
    private KospiDao kospiDao;
	
	@Autowired
	private ExchangeDao exchangeDao;
	
	@Autowired
	private StockProfitDao stockProfitDao;

    @GetMapping("/api/kospichart")
    public List<KospiDto> getKospiChart() throws Exception {
    	return kospiDao.searchKospiChart();
    }
    
    @GetMapping("/api/exchangechart")
    public List<ExchangeDto> getExchangeChart() throws Exception {
    	return exchangeDao.searchExchangeChart();
    }
    
    @GetMapping("/api/stockprofitshin")
    public List<StockProfitDto> getstockprofitshin() throws Exception {
    	return stockProfitDao.searchShinProfitChart();
    }
    
    @GetMapping("/api/stockprofitshinfood")
    public List<StockProfitDto> getstockprofitshinfood() throws Exception {
    	return stockProfitDao.searchShinFoodProfitChart();
    }
    
    @GetMapping("/api/stockprofitemart")
    public List<StockProfitDto> getstockprofitemart() throws Exception {
    	return stockProfitDao.searchEmartProfitChart();
    }
    
    @GetMapping("/api/totalprofit")
    public List<TotalProfitDto> gettotalprofit() throws Exception {
    	return stockProfitDao.totalProfitChart();
    }
    
    
}
