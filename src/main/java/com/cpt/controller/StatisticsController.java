package com.cpt.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cpt.req.StatisticsReq;
import com.cpt.service.StatisticsService;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	
	@Resource
	private StatisticsService statisticsService;
	 /**
     * 统计列表
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public ModelAndView chart(ModelAndView mav,StatisticsReq statisticsReq) {
    	mav.addObject("statistics",statisticsService.getStatistics(statisticsReq));
        mav.setViewName("statistics/statistics-chart");
        return mav;
    }
    /**
     * 统计分析
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/analysis", method = RequestMethod.GET)
    public ModelAndView analysis(ModelAndView mav) {
        mav.setViewName("statistics/statistics-analysis");
        return mav;
    }
    
}
