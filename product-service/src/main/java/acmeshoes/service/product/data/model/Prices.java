/**
 * Copyright 2019 Greg Whitaker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
