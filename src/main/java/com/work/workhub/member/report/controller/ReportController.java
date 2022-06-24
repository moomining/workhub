package com.work.workhub.member.report.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.work.workhub.member.report.model.dto.ReportDTO;
import com.work.workhub.member.report.model.service.ReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("report")
public class ReportController {
	
	private ReportService reportService;
	private MessageSource message;
	
	@Autowired
	public ReportController(ReportService reportService, MessageSource message) {
		this.reportService = reportService;
		this.message = message;
	}
	
	@GetMapping("intro")
	public void reportIntro() {
		
	}
	
	@GetMapping("create")
	public void registReport() {
		
	}

	@PostMapping("create")
	public String registReport(@ModelAttribute ReportDTO report, RedirectAttributes rttr, Locale locale, @RequestParam int memberNo, @RequestParam int depNo) throws Exception {
		log.info("memberNo : {}", memberNo);
		log.info("depNo : {}", depNo);
		
		log.info("등록요청 : {}", report);
		
		reportService.registReport(report);
		
		rttr.addFlashAttribute("successMessage", message.getMessage("registReport", null, locale));
		
		return "redirect:/report/create";
	}
}