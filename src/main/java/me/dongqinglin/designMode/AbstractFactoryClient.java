package me.dongqinglin.designMode;

public class AbstractFactoryClient {
    public static void main(String[] args) {
        String name = "pedro";
        Factory factory = new AccessServerFactory();
        UserDao userDao = factory.createUserDao();
        userDao.insert(name);
        userDao.get(1);
    }
}

interface Factory {
    UserDao createUserDao();
}

class SqlServerFactory implements Factory {
    @Override
    public SqlServerUserDao createUserDao() {
        return new SqlServerUserDao();
    }
}

class AccessServerFactory implements Factory {
    @Override
    public UserDao createUserDao() {
        return new AccessServerUserDao();
    }
}

interface UserDao {
    void insert(String name);
    void get(int index);
}

class SqlServerUserDao implements UserDao{
    public SqlServerUserDao() {
    }

    @Override
    public void insert(String name) {
        System.out.println("sql存入数据");
    }

    @Override
    public void get(int index) {
        System.out.println("sql取出数据");
    }
}


class AccessServerUserDao implements UserDao {
    public AccessServerUserDao() {
    }

    @Override
    public void insert(String name) {
        System.out.println("access存入数据");
    }

    @Override
    public void get(int index) {
        System.out.println("access取出数据");
    }
}
