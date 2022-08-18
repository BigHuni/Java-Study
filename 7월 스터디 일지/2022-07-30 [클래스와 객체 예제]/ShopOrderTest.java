package classpart;

public class ShopOrderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ShopOrder shoporder = new ShopOrder();
		shoporder.orderNumber = 2022073001;
		shoporder.orderId = "abc123";
		shoporder.orderDate = "2022년 7월 30일";
		shoporder.orderName = "허대훈";
		shoporder.orderGoodsNum = "PD0327-12";
		shoporder.orderAddress = "경기도 용인시 처인구 포곡읍 에버랜드로 199";
		
		System.out.println("주문번호 : " + shoporder.orderNumber);
		System.out.println("주문자 아이디 : " + shoporder.orderId);
		System.out.println("주문 날짜 : " + shoporder.orderDate);
		System.out.println("주문자 이름 : " + shoporder.orderName);
		System.out.println("주문 상품 번호 : " + shoporder.orderGoodsNum);
		System.out.println("배송 주소 : " + shoporder.orderAddress);
	}

}
