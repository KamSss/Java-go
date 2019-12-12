public class MyRuntimeException extends RuntimeException {
    private String msg;
    MyRuntimeException(String msg){
        super();
        this.msg = msg;
    };
    public String getMsg(){
        return msg;
    }
}
