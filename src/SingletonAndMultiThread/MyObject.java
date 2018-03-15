package SingletonAndMultiThread;

//单例---懒汉模式
public class MyObject {
    private MyObject(){}

    public static volatile MyObject instance;

    public static MyObject getInstance(){

        try{
            if (instance != null){

            }else{
                synchronized (MyObject.class){
                    if (instance == null)
                        instance = new MyObject();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return instance;
    }
}
