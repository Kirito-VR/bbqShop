package Shop.Bean;
public class Order {
    private String Oid;
    private Double Aprice;
    private String Place;
    private String Info;
    private String transcation_id;

    public Order(String oid,String place, Double aprice,String info) {
        Oid = oid;
        Aprice = aprice;
        Place = place;
        Info = info;
    }

    //    无参构造函数
    public Order(){

    }

    public Order(String oid) {
        Oid = oid;
    }

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
        return transcation_id;
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
        this.transcation_id = transaction_id;
    }
}
