package Shop.Bean;

import java.util.Objects;

/**
 * @author ludh
 * @date 2022/5/2 15:57:00
 */
public class Stock {
    private String id;
    private String name;
    private int amount;
    private double cost;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return amount == stock.amount && Double.compare(stock.cost, cost) == 0 && Objects.equals(id, stock.id) && Objects.equals(name, stock.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, amount, cost);
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", cost=" + cost +
                '}';
    }
}
