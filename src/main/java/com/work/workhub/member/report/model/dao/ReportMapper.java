package com.work.workhub.member.report.model.dao;

import org.apache.ibatis.annotations.Mapper;

import com.work.workhub.member.report.model.dto.ReportDTO;

@Mapper
public interface ReportMapper {
	int registReport(ReportDTO report);
}
