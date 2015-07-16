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
     * 添加一个订单：使用消息，并 有数据库强一致性功能
     *
     * @param request
     * @param response
     *
     * @return
     */
    @RequestMapping("/addCampaignMessageWithHighConsistency")
    public ModelAndView AddCampaignMessageWithQHighConsistency(HttpServletRequest request,
                                                               HttpServletResponse response) {

        long aa = RandomUtils.nextInt(10000000);

        campaignMgr.create("campaign" + String.valueOf(aa), BigDecimal.valueOf(aa));

        List<Campaign> campaignList = campaignMgr.findAll();

        return new ModelAndView("index", "campaignList", campaignList);
    }

    /**
     * 对订单数据显示进行缓存：使用消息，但 不需要数据库强一致性功能
     *
     * @param request
     * @param response
     *
     * @return
     */
    @RequestMapping("/showCampaignWithoutHighConsistency")
    public ModelAndView showCampaignWithoutQHighConsistency(HttpServletRequest request, HttpServletResponse response) {

        List<Campaign> campaignList = campaignMgr.findAll();

        return new ModelAndView("index", "campaignList", campaignList);
    }
}
