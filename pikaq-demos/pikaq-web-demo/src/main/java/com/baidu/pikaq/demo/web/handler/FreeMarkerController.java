package com.baidu.pikaq.demo.web.handler;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.math.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.pikaq.demo.service.campaign.bo.Campaign;
import com.baidu.pikaq.demo.service.campaign.service.CampaignMgr;

/**
 * Created by knightliao on 15/1/20.
 */
@Controller
@RequestMapping("/home")
public class FreeMarkerController {

    private static final Logger LOG = Logger.getLogger(FreeMarkerController.class);

    @Autowired
    private CampaignMgr campaignMgr;

    /**
     * Just index
     *
     * @param request
     * @param response
     *
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView Add(HttpServletRequest request, HttpServletResponse response) {

        List<Campaign> campaignList = campaignMgr.findAll();

        return new ModelAndView("index", "campaignList", campaignList);
    }

    /**
     * 添加一个订单：使用强一致性消息
     *
     * @param request
     * @param response
     *
     * @return
     */
    @RequestMapping("/addCampaign")
    public ModelAndView addCampaign(HttpServletRequest request, HttpServletResponse response) {

        long aa = RandomUtils.nextInt(10000000);

        campaignMgr.create("campaign" + String.valueOf(aa), BigDecimal.valueOf(aa));

        List<Campaign> campaignList = campaignMgr.findAll();

        return new ModelAndView("index", "campaignList", campaignList);
    }

    /**
     * 添加一个订单：使用强一致性消息
     *
     * @param request
     * @param response
     *
     * @return
     */
    @RequestMapping("/addCampaignConsumerError")
    public ModelAndView addCampaignConsumerError(HttpServletRequest request, HttpServletResponse response) {

        long aa = RandomUtils.nextInt(10000000);

        campaignMgr.createWithConsumerError("campaign" + String.valueOf(aa), BigDecimal.valueOf(aa));

        List<Campaign> campaignList = campaignMgr.findAll();

        return new ModelAndView("index", "campaignList", campaignList);
    }

    /**
     * 更新一个订单: 使用弱一致性将修改信息传输到另一个地方进行缓存读取
     *
     * @param request
     * @param response
     *
     * @return
     */
    @RequestMapping("/updateCampaign")
    public ModelAndView updateCampaign(HttpServletRequest request, HttpServletResponse response) {

        campaignMgr.update(1L, BigDecimal.valueOf(343434L));

        List<Campaign> campaignList = campaignMgr.findAll();

        return new ModelAndView("index", "campaignList", campaignList);
    }
}
