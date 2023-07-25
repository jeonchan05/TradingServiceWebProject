//package com.final_project.stock.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//import com.final_project.stock.dao.ExchangeDao;
//import com.final_project.stock.dao.KospiDao;
//import com.final_project.stock.dto.ExchangeDto;
//import com.final_project.stock.dto.KospiDto;
//
//@RestController
//public class DataSSEController{
//
//		
//    @GetMapping("/date-data")
//    public SseEmitter dateData() {
//        SseEmitter emitter = new SseEmitter();
//
//        new Thread(() -> {
//            while (true) {
//                try {
//                   	ExchangeDao exchangedao = new ExchangeDao();
//            		ExchangeDto exchangedto = exchangedao.searchrecent();
//            		String date = exchangedto.getDate();
//                    emitter.send(date+" 기준");
//
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                    emitter.completeWithError(e);
//                    break;
//                }
//            }
//        }).start();
//
//        return emitter;
//    }
//    
//    @GetMapping("/usd-exchange-data")
//    public SseEmitter usdData() {
//        SseEmitter usdemitter = new SseEmitter();
//
//        new Thread(() -> {
//            while (true) {
//                try {
//                    // Retrieve data from the database
//                   	ExchangeDao exchangedao = new ExchangeDao();
//            		ExchangeDto exchangedto = exchangedao.searchrecent();
//            		String usd = exchangedto.getUSD();
//            		usdemitter.send(usd);
//
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                	usdemitter.completeWithError(e);
//                    break;
//                }
//            }
//        }).start();
//
//        return usdemitter;
//    }
//    
//    @GetMapping("/cny-exchange-data")
//    public SseEmitter exchangeData() {
//        SseEmitter cnyemitter = new SseEmitter();
//
//        new Thread(() -> {
//            while (true) {
//                try {
//                   	ExchangeDao exchangedao = new ExchangeDao();
//            		ExchangeDto exchangedto = exchangedao.searchrecent();
//            		String cny = exchangedto.getCNY();
//            		cnyemitter.send(cny);
//
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                	cnyemitter.completeWithError(e);
//                    break;
//                }
//            }
//        }).start();
//
//        return cnyemitter;
//    }
//    
//    @GetMapping("/kospi-data")
//    public SseEmitter kospidata() {
//        SseEmitter kospiemitter = new SseEmitter();
//
//        new Thread(() -> {
//            while (true) {
//                try {
//                   	KospiDao kospidao = new KospiDao();
//            		KospiDto kospidto = kospidao.searchrecent();
//            		String value = kospidto.getValue();
//            		kospiemitter.send(value);
//            		
//                    Thread.sleep(1000);
//                } catch (Exception e) {
//                	kospiemitter.completeWithError(e);
//                    break;
//                }
//            }
//        }).start();
//
//        return kospiemitter;
//    }
//    
//   
//}
//
//
//
