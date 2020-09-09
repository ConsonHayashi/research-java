package me.dongqinglin.designMode;

public class StrategyClient {
    public static void main(String[] args) {
        try {
            double cash = 1011;
            Strategy strategy = new StrategyImpl1(0.9);
            double result = strategy.calcTotalPrice(cash);
            strategy = new StrategyImpl2(1000, 100);
            double result2 = strategy.calcTotalPrice(cash);
            System.out.println(result + " and " + result2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

interface Strategy {
    double calcTotalPrice(double cash) throws Exception;
}

class StrategyImpl1 implements Strategy {
    private double priceTimes;

    public StrategyImpl1(double priceTimes) {
        this.priceTimes = priceTimes;
    }

    @Override
    public double calcTotalPrice(double cash) throws Exception {
         if (priceTimes < 1.0) {
             return cash * priceTimes;
         }else {
             throw new Exception("出错，打折不可能超过原价格的100%。");
         }
    }
}

class StrategyImpl2 implements Strategy {
    private double moreThan;
    private double sub;

    public StrategyImpl2(double moreThan, double sub) {
        this.moreThan = moreThan;
        this.sub = sub;
    }

    @Override
    public double calcTotalPrice(double cash) {
        if (cash > moreThan) {
            return cash - sub;
        }else {
            return cash;
        }
    }
}