package api.dto;

public class SendEmailDTO {


    private String email;

    public SendEmailDTO(String email){

        this.email = email;

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
