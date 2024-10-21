package com.kh.chap04_clone.part03_list.run;

import java.util.Arrays;

import com.kh.chap01_list.part01_arrayList.model.vo.Music;

public class ArrayRun {

	private int size;
	public static final int DEFAULT_CAPACITY = 10;
	Music[] mArr;

	public ArrayRun() {
		mArr = new Music[DEFAULT_CAPACITY];// 크기 10짜리 기본 배열
	}

	public ArrayRun(int initialCapacity) {
		mArr = new Music[initialCapacity]; // 내가 지정한 크기를 가진 배열 생성
	}

	public static void main(String[] args) {

		// 크기 3 ArrayList생성
		ArrayRun ar = new ArrayRun(3);
		ar.add(new Music("고백", "장범준"));
		ar.add(new Music("고민중독", "qwer"));
		ar.add(new Music("여수밤바다", "장범준"));
		ar.add(new Music("여수밤바다", "장범준"));
		ar.add(new Music("여수밤바다", "장범준"));
		ar.add(new Music("여수밤바다", "장범준"));
		ar.add(new Music("여수밤바다", "장범준"));
		ar.add(new Music("여수밤바다", "장범준"));

		// ar.add(10000, new Music("여","수"));

		System.out.println(ar);
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		//return mArr[0] == null ?  true : false;
		return size == 0 ?  true : false;
	}

	public Music get(int index) {
		// 제대로된 index인지 체크
		if(index < 0 || index >= size) {
			System.out.println("잘못된 인덱스입니다.");
			//throw new Exception();
			return null;
		}
		
		return mArr[index];
	}

	public Music set(int index, Music m) {
		// index위치에 있는 Music객체의 값을 변경
		// 변경전의 값을 반환
		if(index < 0 || index >= size) {
			System.out.println("잘못된 인덱스입니다.");
			//throw new Exception();
			return null;
		}
		Music returnValue = mArr[index];
		
		mArr[index] = m;
		
		return returnValue;
	}

	public void add(Music m) {
		// 마지막 위치에 m을 추가
//		if(mArr.length == size) {
//			Music[] copy = new Music[size + 1];
//			for(int i =0; i<size; i++) {
//				copy[i] = mArr[i]; // 배열복사
//			}		
//			mArr = copy; // 얕은복사
//		}
		if (mArr.length == size)
			mArr = Arrays.copyOf(mArr, mArr.length + 1);
		
		mArr[size++] = m;
		// size++;
	}

	public void add(int index, Music m) {

		// 1) 인덱스 범위 체크.
		if (!(index >= 0 && index < size)) {
			System.err.println("저장가능한 인덱스 위치가 아닙니다.");
			return;
		}

		// 2) 배열의 저장공간이 꽉 찬 경우 배열의 크기 증가
		if (mArr.length == size)
			mArr = Arrays.copyOf(mArr, mArr.length + 1);

		/*
		 * 3) for문을 활용한 밀어주기 [1, 2 ,3 ,4 ,5] => 3번인덱스에 10을 저장 [1, 2 ,3 ,4 ,5, 0] -> 배열복사
		 * 뒤로 밀기 작업 완료시 [1, 2, 3, 4, 4, 5] [1, 2, 3, 10, 4, 5]
		 */
//		for(int i = size; i > index; i--) {
//			mArr[i] = mArr[i-1];
//		}

		// 3_2) 배열복사를 통한 밀어주기
		// System.arraycopy(원본배열, 윈본에서 복사를 시작할 인덱스, 복사본배열, 복사본배열에서 복사를 시작할 인덱스, 복사할 갯수)
		// [1, 2 ,3 ,4 ,5, 0]
		System.arraycopy(mArr, index, mArr, index + 1, size - index);
		// [1, 2 , 3 ,4 , 4 , 5]

		mArr[index] = m;
		size++;
	}

	public Music remove(int index) {
		if(index < 0 || index >= size) {
			System.out.println("잘못된 인덱스 범위입니다.");
			return null;
		}
		
		Music rValue = mArr[index];
		
		mArr[index] = null;
		
		// 삭제된 인덱스 뒤쪽의 값들을 한칸씩 앞으로 땡겨오기
		// [m1, m2, m3, m4 ,m5] 여기서 2번인덱스(m3)를 삭제
		// [m1, m2, null, m4, m5]
		// [m1, m2, m4, m5, m5]
		// [m1, m2, m4, m5, null]
		for(int i = index; i < size -1; i++) {
			mArr[index] = mArr[index+1];
		}
		mArr[size-1] = null;
		
		size--;
		
		return rValue;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		// 반복문 돌리면서 초기화된 데이터의 toString()호출
		for (int i = 0; i < size; i++) {
			sb.append(mArr[i].toString());
			sb.append(i != (size - 1) ? "," : ""); // 다음값이 있다면 , 없다면 ' '
		}
		sb.append("]");

		return sb.toString();
	}

}
