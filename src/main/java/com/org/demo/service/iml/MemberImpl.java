package com.org.demo.service.iml;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.demo.dto.MemberDto;
import com.org.demo.entity.MemberEntity;
import com.org.demo.model.MemberRequest;
import com.org.demo.repository.MemberRepository;
import com.org.demo.service.Member;

import javassist.NotFoundException;

@Service
public class MemberImpl implements Member {

	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public MemberDto register(MemberRequest member) {
		MemberEntity memberEntity = new MemberEntity();	
		
		memberEntity.setUserName(member.getUserName());
		memberEntity.setPassword(member.getPassword());
		memberEntity.setFirstName(member.getFirstName());
		memberEntity.setLastName(member.getLastName());
		memberEntity.setAge(Long.valueOf(member.getAge()));
		memberEntity.setPhone(member.getPhone());
		memberEntity.setEmail(member.getEmail());
		memberEntity.setSalary(member.getSalary());
		memberEntity.setAddress(member.getAddress());
		memberEntity.setReferenceCode(member.getReferenceCode());
		memberEntity.setMemberType(member.getMemberType());
		memberEntity.setCreateDate(new Date());
		memberEntity.setUpdateDate(new Date());
		MemberEntity entity = memberRepository.save(memberEntity);
		
		MemberDto memberDto = new MemberDto();
		memberDto.setId(entity.getId());
		memberDto.setReferenceCode(entity.getReferenceCode());
		return memberDto;
	}
	
	@Override
	public MemberDto findById(Long id) throws NotFoundException {
		Optional <MemberEntity> opt = memberRepository.findById(id);
		MemberDto memberDto = new MemberDto();
		if (opt.isPresent()){
			MemberEntity entity = opt.get();
			memberDto.setId(entity.getId());
			memberDto.setUserName(entity.getUserName());
			memberDto.setPassword(entity.getPassword());
			memberDto.setFirstName(entity.getFirstName());
			memberDto.setLastName(entity.getLastName());
			memberDto.setAge(Long.valueOf(entity.getAge()));
			memberDto.setPhone(entity.getPhone());
			memberDto.setEmail(entity.getEmail());
			memberDto.setSalary(entity.getSalary());
			memberDto.setAddress(entity.getAddress());
			memberDto.setReferenceCode(entity.getReferenceCode());
			memberDto.setMemberType(entity.getMemberType());
			memberDto.setCreateDate(entity.getCreateDate());
			memberDto.setUpdateDate(entity.getUpdateDate());
			
		}else {
			throw new NotFoundException("Data Not Found");
		}
		
		return memberDto;
	}
}
