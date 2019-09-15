package com.org.demo.service;

import com.org.demo.dto.MemberDto;
import com.org.demo.model.MemberRequest;

import javassist.NotFoundException;

public interface Member {
	public MemberDto register(MemberRequest member);
	public MemberDto findById(Long id) throws NotFoundException;
}
