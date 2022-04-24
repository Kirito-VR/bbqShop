package Shop.Bean;

/**
 * @Author: Cqmax
 * @Date: 2022/4/24 15:28
 * @Version 1.0
 */
public class Good {
    private String good_Id;
    private String good_name;
    private float good_price;

    public void setGood_Id(String good_Id) {
        this.good_Id = good_Id;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public void setGood_price(float good_price) {
        this.good_price = good_price;
    }

    public String getGood_Id() {
        return good_Id;
    }

    public String getGood_name() {
        return good_name;
    }

    public float getGood_price() {
        return good_price;
    }
}
