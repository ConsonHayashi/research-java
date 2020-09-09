package me.dongqinglin.designMode;

public class AdapterClient {
    public static void main(String[] args) {
        Target target = new Adapter();
        target.Request();
    }
}

interface Target {
    public void Request();
}

class Adapter implements Target {
    private Adaptee adaptee = new Adaptee();
    @Override 
    public void Request(){
        adaptee.specificRequest();
    }
}

class Adaptee {
    public void specificRequest(){
        System.out.println("被适配");
    }
}