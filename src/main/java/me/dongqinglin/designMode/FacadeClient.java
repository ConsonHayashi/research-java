package me.dongqinglin.designMode;

public class FacadeClient {
    public static void main(String[] args) {
        Facade facade = new FacadeImpl();
        facade.methodA();
        facade.methodB();
    }
}
interface Facade {
    public void methodA();
    public void methodB();
}

class FacadeImpl implements Facade {
    SubSystemOne one;
    SubSystemTwo two;

    public FacadeImpl() {
        this.one = new SubSystemOne();
        this.two = new SubSystemTwo();
    }

    @Override
    public void methodA() {
        one.method1();
        two.method3();
    }

    @Override
    public void methodB() {
        one.method2();
        two.method2();
    }
}

class SubSystemOne {
    public void method1() {
        System.out.println("运行子系统1,方法一");
    }

    public void method2() {
        System.out.println("运行子系统1,方法二");
    }
}

class SubSystemTwo {
    public void method3() {
        System.out.println("运行子系统2,方法三");
    }

    public void method2() {
        System.out.println("运行子系统2,方法二");
    }
}