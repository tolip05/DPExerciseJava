package srcc.logger;



public class ErrorLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if ( LogType.ERROR == type){
            System.out.println(type.name() + ": " + message);
        }else {
            super.passToSuccessor(type,message);
        }
    }
}
