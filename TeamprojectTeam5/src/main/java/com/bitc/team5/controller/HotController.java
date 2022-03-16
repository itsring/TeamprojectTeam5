package com.bitc.team5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitc.team5.dto.HotDto;
import com.bitc.team5.service.hot.HotService;



@Controller
public class HotController {
	
	@Autowired
	private HotService hotService;
	
	///////////////****************관광지 리스트 페이지*****************///////////////////
	@RequestMapping(value="/hotplace")
	public ModelAndView hotplace() throws Exception {
		ModelAndView mv = new ModelAndView("/hot/hotmain");
		
		List<HotDto> hotList = hotService.selectHotList();
		List<HotDto> hotMarketList = hotService.selectMarketList();
		List<HotDto> hotLandList = hotService.selectLandList();
		List<HotDto> hotParkList = hotService.selectParkList();
		List<HotDto> hotWalkList = hotService.selectWalkList();
		
		mv.addObject("hotList", hotList);
		mv.addObject("hotMarketList", hotMarketList);
		mv.addObject("hotLandList", hotLandList);
		mv.addObject("hotParkList", hotParkList);
		mv.addObject("hotWalkList", hotWalkList);
		
		return mv;
	}
	
	
	
	///////////////****************관광지 등록 페이지*****************///////////////////
	//상품등록 페이지
		@RequestMapping(value="/hotinsert")
		public String hotinsert() throws Exception {
		
		return "/hot/hotinsert";
		}
		
		//상품 정보 입력
		@RequestMapping(value="/hotinsert/hotRegister")
		public String proregister(HotDto hotPlace) throws Exception {
			hotService.hotinsert(hotPlace);
		
			return "redirect:/hotplace";
		}
		
	///////////////****************관광지 상세 페이지*****************///////////////////
	@RequestMapping(value="/hotDetail/{seq}", method=RequestMethod.GET)
	public ModelAndView hotDetail(@PathVariable("seq") int seq) throws Exception {
		ModelAndView mv = new ModelAndView("/hot/hotdetails");
		
		HotDto hotDetail = hotService.hotDetailList(seq);
		mv.addObject("hotDetail", hotDetail);
		
		return mv;
	}
	
	///////////////****************관광지 수정 페이지*****************///////////////////
	@RequestMapping(value="/hotupdate/{seq}")
	public ModelAndView hotupdate(@PathVariable("seq") int seq) throws Exception {
		ModelAndView mv = new ModelAndView("/hot/hotupdate");
		
		HotDto hotup = hotService.hotDetailList(seq);
		mv.addObject("hotup", hotup);
		
		return mv;
	}
	
	@RequestMapping(value="/hotplace/hotupdate/{seq}", method=RequestMethod.PUT)
	public String hotUpdateBoard(HotDto hotupdate) throws Exception{
		hotService.hotUpdateBoard(hotupdate);
		
		return "redirect:/hotplace";
	}
	

}
