package Shop.Bean;

import java.util.Objects;
/*
*@Author: wrl
*/
public class Order {
    private String Oid;
    private Double Aprice;
    private String Place;
    private String Info;
    private String transaction_id;


    public String getOid() {
        return Oid;
    }

    public void setOid(String Oid) {
        this.Oid = Oid;
    }

    public Double getAprice() {
        return Aprice;
    }

    public String getPlace() {
        return Place;
    }

    public String getInfo() {
        return Info;
    }

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setAprice(Double aprice) {
        Aprice = aprice;
    }

    public void setPlace(String place) {
        Place = place;
    }

    public void setInfo(String info) {
        Info = info;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Oid='" + Oid + '\'' +
                ", Aprice=" + Aprice +
                ", Place='" + Place + '\'' +
                ", Info='" + Info + '\'' +
                ", transaction_id='" + transaction_id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(Oid, order.Oid) && Objects.equals(Aprice, order.Aprice) && Objects.equals(Place, order.Place) && Objects.equals(Info, order.Info) && Objects.equals(transaction_id, order.transaction_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Oid, Aprice, Place, Info, transaction_id);
    }
}


