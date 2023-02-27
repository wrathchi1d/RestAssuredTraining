package pojo;

public class SuccessfulRegisterResponseEntity {

    private Integer id;
    private String token;

    public SuccessfulRegisterResponseEntity(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public SuccessfulRegisterResponseEntity() {
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
