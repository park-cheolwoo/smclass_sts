package com.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.java.dao.MemberMapper;
import com.java.dto.MemberDto;

import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired JavaMailSender javaMailSender;
	@Autowired MemberMapper memberMapper;
	
	@Override
	public MemberDto login(MemberDto mdto) {
		System.out.println("MemberServiceImpl id : "+mdto.getId());
		MemberDto memberDto = memberMapper.selectLogin(mdto);
		return memberDto;
	}

//	@Async // 비동기 방식으로 변경
	@Override //text
	public String sendEmail(String email) {
		String pwCode = getCreateKey();
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setFrom("bd8860@naver.com");
		message.setSubject("임시비밀번호 안내");
		message.setText("안녕하세요. 회원가입을 위한 이메일인증 임시 비밀번호를 보냅니다. \n"+
						"[임시 비밀번호 : "+pwCode+" ]");
		javaMailSender.send(message);
		System.out.println("이메일 전송 완료");
		return pwCode;
	}
	
	@Override //html
	public String sendEmail2(String email) {
		String pwCode = getCreateKey();
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			message.setSubject("[ 안내 ] 회원가입 임시 비밀번호를 보내드립니다.","utf-8");
			String hdata = "<tr>\n"
					+ "	<td style='width:700px;height:196px;padding:0;margin:0;vertical-align:top;'>\n"
					+ "		<table width='618' height='194' cellpadding='0' cellspacing='0' align='center' style='margin:0 0 0 40px;border:1px #D9D9D9 solid;'>\n"
					+ "		<tr>\n"
					+ "			<td style='width:618px;height:194px;padding:0;margin:0;vertical-align:top;font-size:0;line-height:0;background:#F9F9F9;'>\n"
					+ "				<p style='width:620px;margin:30px 0 0 0;padding:0;text-align:center;'><img src='https://cafeptthumb-phinf.pstatic.net/MjAyNTAyMThfNzQg/MDAxNzM5ODQxMzE4ODAz.qRIvyHCMO_8nGsq[…]DTemykQq84NQOwg.JPEG/img_txt_password02.jpg?type=w1600' alt='JARDIN에서 비밀번호 찾기를 요청하셨습니다.' /></p>\n"
					+ "				<p style='width:620px;margin:10px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1;'>아래의 PASSWORD는 임시 PASSWORD이므로 홈페이지 로그인 후 다시 수정해 주십시오.</p>\n"
					+ "				<p style='width:620px;margin:28px 0 0 0;padding:0;text-align:center;color:#666666;font-size:12px;line-height:1;'><strong>임시 패스워드 : <span style='color:#F7703C;line-height:1;'>"+pwCode+"</span></strong></p>\n"
					+ "				<p style='width:620px;margin:30px 0 0 0;padding:0;text-align:center;color:#888888;font-size:12px;line-height:1.4;'>쟈뎅샵에서는 고객님께 보다 나은 서비스를 제공하기 위해 항상 노력하고 있습니다.<br/>앞으로 많은 관심 부탁드립니다.</p>\n"
					+ "			</td>\n"
					+ "		</tr>\n"
					+ "		</table>\n"
					+ "	</td>\n"
					+ "</tr>";
			message.setText(hdata,"utf-8","html");
			message.setFrom(new InternetAddress("bd8860@naver.com"));
			message.addRecipient(RecipientType.TO,new InternetAddress(email));
			javaMailSender.send(message);
		}catch(Exception e) {e.printStackTrace();}
		
		return pwCode;
	}

	public String getCreateKey() {
		String pwCode = "";
		char[] charSet = {'0','1','2','3','4','5','6','7','8','9',
						  'A','B','C','D','E','F','G','H','I','J','K',
						  'L','M','N','O','P','Q','R','S','T','U','V',
						  'W','X','Y','Z'};
		
		int idx = 0;
		for(int i=0;i<10;i++) {
			idx = (int)(Math.random()*36);
			pwCode += ""+charSet[idx];
		}
		System.out.println("임시 비밀번호 생성");
		return pwCode;
	}
}
