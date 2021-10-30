package mins.study.oopp.customer;

public class Customer {

    public void pay(PayMethod payMethod, Integer price) {
        System.out.println("### " + price + " has been paid. (pay method : " + payMethod + ")");
    }
}
