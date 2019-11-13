package acmeshoes.service.product.data.model;

import java.text.DecimalFormat;

public class Prices {
    private final DecimalFormat formatter = new DecimalFormat("#0.00");

    private double list;
    private double msrp;
    private double sale;

    public double getList() {
        return list;
    }

    public void setList(double list) {
        this.list = list;
    }

    public double getMsrp() {
        return msrp;
    }

    public void setMsrp(double msrp) {
        this.msrp = msrp;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public String getFormattedList() {
        return formatter.format(getList());
    }

    public String getFormattedMsrp() {
        return formatter.format(getMsrp());
    }

    public String getFormattedSale() {
        return formatter.format(getSale());
    }
}
