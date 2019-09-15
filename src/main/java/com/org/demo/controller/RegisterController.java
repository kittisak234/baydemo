package com.org.demo.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.demo.core.exception.DataNotFoundException;
import com.org.demo.core.exception.GeneralException;
import com.org.demo.core.exception.MemberTypeClassifyException;
import com.org.demo.core.utils.DateHelper;
import com.org.demo.core.utils.Enum;
import com.org.demo.dto.MemberDto;
import com.org.demo.model.MemberRequest;
import com.org.demo.model.MemberResponse;
import com.org.demo.service.Member;

import javassist.NotFoundException;;

@RequestMapping("/api")
@RestController
public class RegisterController {
	
	@Autowired
	Member memberService;
	
	@PostMapping(value = "/v1/demo/member", consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<MemberResponse> registerMember(@Valid @RequestBody MemberRequest member) throws GeneralException {
		MemberResponse memberResponse = new MemberResponse();
		
		try {
			//salary set decimal 2 scale
			BigDecimal salary = new BigDecimal(member.getSalary()).setScale(2, BigDecimal.ROUND_HALF_EVEN);
			
			//check salary condition
			if(salary.compareTo(new BigDecimal(Enum.MemberTypeClassifyCondition.Condition.Condition1.getValue())) > 0) { 
				member.setMemberType(Enum.MemberTypeClassify.Type.Platinum.getValue());
				
			} else if(salary.compareTo(new BigDecimal(Enum.MemberTypeClassifyCondition.Condition.Condition2.getValue())) >= 0 && salary.compareTo(new BigDecimal(Enum.MemberTypeClassifyCondition.Condition.Condition1.getValue())) <= 0) {
				member.setMemberType(Enum.MemberTypeClassify.Type.Gold.getValue());
			} else if(salary.compareTo(new BigDecimal(Enum.MemberTypeClassifyCondition.Condition.Condition3.getValue())) >= 0 && salary.compareTo(new BigDecimal(Enum.MemberTypeClassifyCondition.Condition.Condition2.getValue())) <= 0 ) {
				member.setMemberType(Enum.MemberTypeClassify.Type.Silver.getValue());
			}else if(salary.compareTo(new BigDecimal(Enum.MemberTypeClassifyCondition.Condition.Condition3.getValue())) <= 0) {
				throw new MemberTypeClassifyException(Enum.DemoResponse.responseCode.FAIL_CODE_00001.getKey(),Enum.DemoResponse.responseCode.FAIL_CODE_00001.getValue());
			}
			
			//sub string phone to last four digits
			String lastFourDigits = member.getPhone().substring(member.getPhone().length() - 4);
			
			//create reference code by now date concat with phone last four digits
			String referenceCode = new SimpleDateFormat(DateHelper.YYYYMMDD).format(new Date())+lastFourDigits;
			member.setReferenceCode(referenceCode);
			member.setSalary(salary.toString());
			
			//call register service to save data
			MemberDto memberDto = memberService.register(member);
			
			//create response
			memberResponse.setId(String.valueOf(memberDto.getId()));
			memberResponse.setReferenceCode(memberDto.getReferenceCode());
			memberResponse.setCode(Enum.DemoResponse.responseCode.SUCCESS.getKey());
			memberResponse.setStatus(Enum.DemoResponse.responseCode.SUCCESS.getValue());
		} catch(Exception e) {
			throw new GeneralException(e);
		}
		return ResponseEntity.ok().body(memberResponse);
	}
	
	@GetMapping(value = "/v1/demo/member/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<MemberResponse> getMember(@PathVariable("id") Long id) throws DataNotFoundException, GeneralException {
		MemberResponse memberResponse = new MemberResponse();
		try {
			MemberDto memberDto = memberService.findById(id);
			memberResponse.setId(String.valueOf(memberDto.getId()));
			memberResponse.setReferenceCode(memberDto.getReferenceCode());
			memberResponse.setUserName(memberDto.getUserName());
			memberResponse.setPassword(memberDto.getPassword());
			memberResponse.setFirstName(memberDto.getFirstName());
			memberResponse.setLastName(memberDto.getLastName());
			memberResponse.setAge(String.valueOf(memberDto.getAge()));
			memberResponse.setPhone(memberDto.getPhone());
			memberResponse.setEmail(memberDto.getEmail());
			memberResponse.setSalary(memberDto.getSalary());
			memberResponse.setAddress(memberDto.getAddress());
			memberResponse.setMemberType(memberDto.getMemberType());
			memberResponse.setReferenceCode(memberDto.getReferenceCode());
			memberResponse.setCode(Enum.DemoResponse.responseCode.SUCCESS.getKey());
			memberResponse.setStatus(Enum.DemoResponse.responseCode.SUCCESS.getValue());
		} catch(NotFoundException e) {
			throw new DataNotFoundException(Enum.DemoResponse.responseCode.FAIL_CODE_00002.getKey(),Enum.DemoResponse.responseCode.FAIL_CODE_00002.getValue());
			
		} catch(Exception e) {
			throw new GeneralException(e);
		}
		return ResponseEntity.ok().body(memberResponse);
	}
}
