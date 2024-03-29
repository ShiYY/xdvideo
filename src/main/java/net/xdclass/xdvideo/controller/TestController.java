package net.xdclass.xdvideo.controller;

import com.sun.media.sound.SoftTuning;
import net.xdclass.xdvideo.config.WeChatConfig;
import net.xdclass.xdvideo.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("test")
	public String test(){
		System.out.println("xdclass.net");
		return "hello xdclass.net777";
	}
	
	@Autowired
	private WeChatConfig weChatConfig;
	
	@RequestMapping("test_config")
	public String testConfig(){
		System.out.println(weChatConfig.getAppId());
		return weChatConfig.getAppId();
	}
	
	@Autowired
	private VideoMapper videoMapper;
	
	@RequestMapping("test_db")
	public Object testDB(){
		return videoMapper.getAll();
	}
	
}
