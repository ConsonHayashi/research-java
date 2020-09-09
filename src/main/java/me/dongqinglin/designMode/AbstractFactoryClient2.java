package me.dongqinglin.designMode;


public class AbstractFactoryClient2 {
    public static void main(String[] args) {
        String name = "pedro";
        // Factory factory = new AccessServerFactory();
        // UserDao userDao = factory.createUserDao();
        DataAccess dataAccess = new DataAccess();
        UserDao userDao = dataAccess.createUserDao();
        userDao.insert(name);
        userDao.get(1);
    }
}

class DataAccess {
    private final String packageName = "me.dongqinglin.designMode";
    private  final String databaseName = "SqlServer";

    public UserDao createUserDao(){
        try {
            Class<?> userdaoClass = Class.forName(packageName + "." + databaseName + "UserDao");
            UserDao userdao = (UserDao) userdaoClass.getConstructor().newInstance();
            return userdao;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
//
// interface UserDao {
//     void insert(String name);
//     void get(int index);
// }
//
// class SqlServerUserDao implements UserDao{
//     public SqlServerUserDao() {
//     }
//
//     @Override
//     public void insert(String name) {
//         System.out.println("sql存入数据");
//     }
//
//     @Override
//     public void get(int index) {
//         System.out.println("sql取出数据");
//     }
// }
//
//
// class AccessServerUserDao implements UserDao {
//     public AccessServerUserDao() {
//     }
//
//     @Override
//     public void insert(String name) {
//         System.out.println("access存入数据");
//     }
//
//     @Override
//     public void get(int index) {
//         System.out.println("access取出数据");
//     }
// }