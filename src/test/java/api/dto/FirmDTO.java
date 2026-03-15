package api.dto;

public class FirmDTO {

    private String name;
    private String bulstat;
    private String town;
    private String address;
    private String email;


    public FirmDTO(String name,String bulstat,String town,String address,String email){
        this.name = name;
        this.bulstat = bulstat;
        this.town = town;
        this.address = address;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTown() {
        return town;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getBulstat() {
        return bulstat;
    }

    public void setBulstat(String bulstat) {
        this.bulstat = bulstat;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


