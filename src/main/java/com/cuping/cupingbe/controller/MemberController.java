package com.cuping.cupingbe.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cuping.cupingbe.dto.MemberLoginRequestDto;
import com.cuping.cupingbe.dto.MemberSignupRequest;
import com.cuping.cupingbe.dto.MemberResponseDto;
import com.cuping.cupingbe.service.MemberService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;

	@PostMapping("/signup/{type}")
	public MemberResponseDto signup(@PathVariable String type,  @RequestBody  MemberSignupRequest memberSignupRequest){

	return memberService.signup(type,memberSignupRequest);



	}

	@PostMapping("/login")
	public MemberResponseDto login(@RequestBody MemberLoginRequestDto memberLoginRequestDto, HttpServletResponse response) {

		return memberService.login(memberLoginRequestDto,response);

	}

	// @PostMapping("/logout")
	// public ResponseEntity<Void>logout(){
	//
	//
	//
	// }


}
