package pojo;

public class UnsuccessfulRegisterResponseEntity {

    private String error;

    public UnsuccessfulRegisterResponseEntity(String error) {
        this.error = error;
    }

    public UnsuccessfulRegisterResponseEntity() {
    }

    public String getError() {
        return error;
    }
}
