package com.kh.practice.comp.func;

import java.util.Scanner;

public class RockPaperScissors {

	public void rps() {
		Scanner sc = new Scanner(System.in);
		System.out.print("당신의 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		
		String[] comRps = {"가위","바위","보"};
		
		int win = 0;
		int draw = 0;
		int loss = 0;
		
		while(true) {
			System.out.print("가위바위보 : ");			
			String userRps = sc.nextLine();
			
			if(userRps.equals("exit")) {
				System.out.printf("%d전 %d승 %d무 %d패",(win+draw+loss),win,draw,loss);
				//종료
				return;
			}
			
			if(!(userRps.equals("가위") || userRps.equals("바위") || userRps.equals("보"))) {
				System.out.println("잘못 입력하셨습니다.");
				//다시입력
				continue;
			}
			
			int random = (int)(Math.random() * 3);			
			System.out.println("컴퓨터 : "+comRps[random]);
			System.out.println(name+" : "+userRps);
			
			if(userRps.equals(comRps[random])) {
				System.out.println("비겼습니다.");
				draw++;
			}
			// 사용자가 컴퓨터를 이기는 조건
			// 가위 보 , 보 주먹, 주먹 가위
			// 가위 주먹,보 가위 , 바위 보
			else if(userRps.equals("가위") && comRps[random].equals("보") ||
					userRps.equals("보") && comRps[random].equals("바위") ||
					userRps.equals("바위") && comRps[random].equals("가위")
					) {
				System.out.println("이겼습니다 !");
				win++;
			}else {
				System.out.println("졌습니다.. ㅠ");
				loss++;
			}			
		}
		
		
	}
}
