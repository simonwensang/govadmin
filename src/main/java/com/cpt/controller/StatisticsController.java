package com.cpt.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cpt.common.Result;
import com.cpt.model.Statistics;
import com.cpt.req.StatisticsReq;
import com.cpt.service.StatisticsService;
import com.cpt.service.UserService;

@Controller
@RequestMapping("/statistics")
public class StatisticsController {
	@Autowired 
	private UserService userService;
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
    	mav.addObject("user",userService.getUser());
        mav.setViewName("statistics/statistics-chart");
        mav.addObject("cur_module","statistics_list");
        mav.addObject("cur_menu","statistics_chart");
        return mav;
    }
    /**
     * 统计分析
     *
     * @param mav
     * @return
     */
    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView analysis(ModelAndView mav,StatisticsReq statisticsReq) {
    	mav.addObject("result", statisticsService.pageList(statisticsReq));
    	mav.addObject("user",userService.getUser());
        mav.setViewName("statistics/statistics-analysis");
        mav.addObject("cur_module","statistics_list");
        mav.addObject("cur_menu","statistics_view");
        return mav;
    }
    /**
     * 增加或者修改
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/addOrEdit", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> addOrEdit(Statistics statistics) {
    	return statisticsService.addOrEdit(statistics);
    }
    
    /**
     * 删除
     *
     * @param mav
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result<Integer> delete(Integer id) {
    	return statisticsService.delete(id);
    }
}
