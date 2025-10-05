package com.shivam.design_patterns;

class Logger{
    private static Logger instance;
    private Logger(){
        System.out.println("Loggger Initialized");
    }

    public static synchronized Logger getInstance(){
        if(instance == null){
            instance =  new Logger();
        }
        return instance;
    }

    public void log(String message){
        System.out.println("{LOG} "+message);
    }

}

public class SingletonDemo {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Logger logger1 = Logger.getInstance();
        Logger logger3 = Logger.getInstance();
        logger.log("Hello First Code From Main");
        logger1.log("Hello Second Code From Main");

        System.out.println(logger1.hashCode());
        System.out.println(logger.hashCode());
        System.out.println(logger3.hashCode());
    }
}
