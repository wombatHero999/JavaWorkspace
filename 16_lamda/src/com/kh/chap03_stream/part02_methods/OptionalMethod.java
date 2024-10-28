package com.kh.chap03_stream.part02_methods;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalMethod {
	/* 
	 * Optional
	 *  - 존재할 수도 있고, 안할수도 있는 객체를 감싸는 객체
	 *  - Optional객체의 반환값을 저장할때는 명시적으로 Optional임을 알 수 있게끔
	 *    maybe+변수명, opt+변수명과 같이 작명한다.
	 * 
	 * Optional 객체 생성방법.
	 * 1. Optional.empty()
	 * 2. Optional.of(obj) 
	 * 3. Optional.ofNullable(obj)
	 * 
	 * Optional 객체 내부 메서들
	 * - get() : 그냥 값을 반환. 만약 값이 없다면 noSuchElement예외가 발생.
	 * - getAs자료형() : 자료형의 값으 반환. 만약 값이 없다면 noSuchElement예외가 발생.
	 * - orElse(T) : get()메소드로 꺼낼값이 존재하지 않을경우 T를 기본값으로 반환.
	 * - orElseGet(Supplier) : get으로 꺼낼 값이 존재하지 않으면 람다식을 통해 구현한 값을 반환
	 * - orElseThrow(Supplier) : get으로 꺼낼값이 존재하지 않을 경우 람다식을 통해 구현한
	 *                           "에러객체"를 반환
	 * - isPresent : 값이 존재하는지 확인하는 메서드
	 * - isPresent(Consumer) : 값이 존재한다면 람다식을 통해 실행할 코드를 구현.
	 * */
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("홍길똥","신사",null,"");
		
//		list.stream()
//			.forEach(str -> {
//				Optional<String> maybeStr = Optional.ofNullable(str); // null일수도 있기에 maybeStr
//				System.out.println(str+" : "+ maybeStr
//											.map(s -> s.length())
//											//.orElse(0)
//											.orElseThrow(() -> new RuntimeException("null"))
//											);
//			});
		
		// Optional 활용
		Member member = new Member();
		member.setEmail("kkk@naver.com");
		
		Order order = new Order();
		order.setMember(member);
		
		System.out.println(getEmailOfMemberFromOrder(order));
	
	}
	
	private static String getEmailOfMemberFromOrder(Order order) {
		// Optional외 조건식으로 예외처리
//		if(order != null) {
//			Member member = order.getMember();
//			if(member != null) {
//				String email = member.getEmail();
//				return email;
//			}
//		}
//		return null; // 값이 존재하지 않는 경우 null반환
//		throw new RuntimeException(); // 값이 존재하지 않는 경우 에러 반환
//		return "이메일이 없습니다.";// 값이 존재하지 않는경우 문자열반환
		return Optional.ofNullable(order)
					   .map(ord -> ord.getMember()) // Order -> Member
					   .map(mem -> mem.getEmail()) // Member -> String
					   .orElse("메일이존재하지 않습니다.");
	}
	
	static class Order{
		Member member;
		int count;
		public Member getMember() {
			return member;
		}
		public void setMember(Member member) {
			this.member = member;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		@Override
		public String toString() {
			return "Order [member=" + member + ", count=" + count + "]";
		}
		
	}
	
	static class Member{
		private String id;
		private String email;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		@Override
		public String toString() {
			return "Member [id=" + id + ", email=" + email + "]";
		}
	}
	
	
	
	
	
	
	
	
	
	
}
