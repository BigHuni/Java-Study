# 📌 Java Study

## 🔸 2022-08-05 금요일

## [클래스와 객체]

### 1. static & singleton 코딩 예제

<br>

- `static`과 `singleton pattern`

- 문제 : 카드 회사가 있다. 카드 회사는 유일한 객체이고, 이 회사에서는 카드를 발급하면 항상 고유번호가 자동으로 생성된다. 10001부터 시작하여 카드가 생성될 때마다 10002, 10003 식으로 증가된다. 다음 코드가 수행 되도록 Card 클래스와 CardCompany 클래스를 구현하라.

```java
  public class CardCompanyTest {

    public static void main(String[] args) {

      CardCompany company = CardCompany.getInstance();    // 싱글톤 패턴

      Card myCard = company.createCard();   // 메서드에서 Car 생성
      Card yourCard = compapny.createCard();

      System.out.println(myCard.getCardNumber());   // 10001 출력
      System.out.println(yourCard.getCardNumber()); // 10002 출력

    }
  }
```

<br>

- Card 클래스

```java
  package card;

  public class Card {

	private int cardNumber;
	private static int serialNum = 10000;

	Card() {
		serialNum++;
		cardNumber = serialNum;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

}
```

- Card 클래스에 `cardNumber 변수`를 `private`로 int 타입 생성 => 외부에서 함부로 바꾸지 못함

- 고유 번호가 10001 부터 시작해야 하니 기본 `serialNum = 10000` 으로 `static` 설정

- Card 메서드를 호출할 때마다 고유번호 serialNum의 값을 증가시키고, 증가된 값이 카드 번호(유지)

- `cardNumber 변수`의 getter, setter 추가

<br>

- CardCompany 클래스

```java
  package card;

  public class CardCompany {

	private static CardCompany instance = new CardCompany();

	private CardCompany() {}

	public static CardCompany getInstance() {
		if(instance == null)
			instance = new CardCompany();

		return instance;
	}

	public Card createCard() {
		Card card = new Card();

		return card;
	}

}
```

- `카드 회사`가 `유일한 인스턴스`

- 함부로 변경이 되면 안되므로 `private` 설정

- 단 하나의 값을 가져야 하므로 `static`

- `private CardCompany() {}` => `private` 이므로 해당 클래스에서만 생성 가능

- 객체를 생성하지 않고, 해당 인스턴스를 호출하기 위해 `static` 으로 `CardCompany getInstance` 선언

- `Card createCard()` => 카드 회사에서 카드 발급, Card 생성

<br>

## 🔖 Eclipse 실습

![day10](https://user-images.githubusercontent.com/79084294/183197796-49d5b0f2-2136-4162-a5f5-d6232b87b6df.png)

<br>

## 🔖 Eclipse 출력 Console

![day10_console](https://user-images.githubusercontent.com/79084294/183197932-cae6021a-498a-4b72-baa4-127f4d63bd02.png)
