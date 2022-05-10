package Shop.Bean;
/*
*@Author: wrl
*/
public class Order {
    private String Oid;
    private Double Aprice;
    private String Place;
    private String Info;
    private String transcation_id;

    //无参构造函数
   public Order(){
}

    public Order(String Oid, String Place, Double Aprice, String Info) {
       this.Oid = Oid;
       this.Place = Place;
       this.Aprice = Aprice;
       this.Info = Info;
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


