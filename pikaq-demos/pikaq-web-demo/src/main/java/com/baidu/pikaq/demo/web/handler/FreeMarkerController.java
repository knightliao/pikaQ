package com.baidu.pikaq.demo.web.handler;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    @RequestMapping("/index")
    public ModelAndView Add(HttpServletRequest request, HttpServletResponse response) {

        List<Campaign> campaignList = campaignMgr.findAll();

        return new ModelAndView("index", "campaignList", campaignList);
    }
}
