package ua.com.goevent.web.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrganizerDTO {

    @Size(max = 50)
    private String name;

    @URL
    private String webpageUrl;

    @NotNull
    @Email
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
        return "OrganizerDTO{" +
                "name='" + name + '\'' +
                ", webpageUrl='" + webpageUrl + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
