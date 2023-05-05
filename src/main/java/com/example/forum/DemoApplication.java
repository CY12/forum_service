package com.example.forum;

import com.example.forum.entity.httpbean.HttpHero;
import com.example.forum.utils.HttpUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws UnsupportedEncodingException {
		SpringApplication.run(DemoApplication.class, args);
		HttpUtils httpUtils = new HttpUtils();
//		httpUtils.getHttp("https://game.gtimg.cn/images/lol/act/img/js/heroList/hero_list.js", HttpHero.class);
//		httpUtils.initHeroData();
		httpUtils.initEquipment();
//		httpUtils.addKey();

	}

}
