package srcc.logger;



public class EventLogger extends Logger {

    @Override
    public void handle(LogType type, String message) {
        if ( LogType.EVEN == type){
            System.out.println(type.name() + ": " + message);
        }else {
            super.passToSuccessor(type,message);
        }
    }
}
