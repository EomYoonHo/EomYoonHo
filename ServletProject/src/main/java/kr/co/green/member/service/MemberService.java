package kr.co.green.member.service;

import kr.co.green.member.model.dto.MemberDTO;

public interface MemberService {

	// 회원가입
	public int memberEnroll(MemberDTO memberDTO);

	// login
	public MemberDTO memberLogin(String id, String pwd);

	// 아이디 중복검사
	public boolean duplicateId(String id);

//	회원 정보 조회
	public void selectMember(MemberDTO memberDTO);
//  수정
	public int memberUpdate(MemberDTO memberDTO, String beforeName);
//	탈퇴
	public int memberDelete(MemberDTO memberDTO, String deleteName);

}