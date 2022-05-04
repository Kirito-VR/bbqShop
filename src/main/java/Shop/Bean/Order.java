package Shop.Bean;
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

    public void setOid(String oid) {
        Oid = oid;
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
}


