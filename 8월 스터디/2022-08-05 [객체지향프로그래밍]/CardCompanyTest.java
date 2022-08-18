package card;

public class CardCompanyTest {

	public static void main(String[] args) {

		CardCompany company = CardCompany.getInstance();    // 싱글톤 패턴

		Card c1 = company.createCard();   // 메서드에서 Car 생성
		Card c2 = company.createCard();

		System.out.println(c1.getCardNumber());   // 10001 출력
		System.out.println(c2.getCardNumber()); // 10002 출력
	
	}
}
