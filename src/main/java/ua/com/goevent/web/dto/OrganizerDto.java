package ua.com.goevent.web.dto;

public class OrganizerDto {
    private String name;
    private String webpageUrl;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebpageUrl() {
        return webpageUrl;
    }

    public void setWebpageUrl(String webpageUrl) {
        this.webpageUrl = webpageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "OrganizerDto{" +
                "name='" + name + '\'' +
                ", webpageUrl='" + webpageUrl + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
