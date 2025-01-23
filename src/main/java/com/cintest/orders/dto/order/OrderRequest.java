//package com.cintest.orders.dto.order;
//import com.cintest.orders.model.Order;
//
//public class OrderRequest {
//    private int units;
//
//    private int bonus;
//
//    private int promo;
//
//    private int totalPrice;
//
//    public OrderRequest() {
//    }
//
//    public int getUnits() {
//        return units;
//    }
//
//    public void setUnits(int units) {
//        this.units = units;
//    }
//
//    public int getBonus() {
//        return bonus;
//    }
//
//    public void setBonus(int bonus) {
//        this.bonus = bonus;
//    }
//
//    public int getPromo() {
//        return promo;
//    }
//
//    public void setPromo(int promo) {
//        this.promo = promo;
//    }
//
//    public int getTotalPrice() {
//        return totalPrice;
//    }
//
//    public void setTotalPrice(int totalPrice) {
//        this.totalPrice = totalPrice;
//    }
//
//    public Order toEntity() {
//        Order order = new Order();
//        order.setUnits(units);
//        order.setBonus(bonus);
//        order.setPromo(promo);
//        order.setTotalPrice(totalPrice);
//        return order;
//    }
//}
