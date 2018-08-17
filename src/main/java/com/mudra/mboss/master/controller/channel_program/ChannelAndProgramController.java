package com.mudra.mboss.master.controller.channel_program;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/channelmaster/*")
public class ChannelAndProgramController {

	String serverurl = "http://192.168.168.27:8080/mboss";
	
	@RequestMapping(value="addchannelmaster",method=RequestMethod.POST)
	public String addChannelMaster(ModelMap map) {
		map.put("serverurl", serverurl);
		return "/master/channel_program/add_channel";
	}
	
	@RequestMapping(value= {"/"},method=RequestMethod.GET)
	public String channelMasterList(ModelMap map) {
		map.put("serverurl", serverurl);
		return "/master/channel_program/channellist";
	}
	
}
