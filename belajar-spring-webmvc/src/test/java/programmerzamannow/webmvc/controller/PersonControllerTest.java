package programmerzamannow.webmvc.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void createPerson() throws Exception{
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("firstName", "Eko")
                        .param("MiddleName", "Kurniawan")
                        .param("lastName", "Khaneddy")
                        .param("email", "eko.example.com")
                        .param("phone", "082314")
                        .param("address.street", "Jalan mangga")
                        .param("address.city", "Jakarta")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "21862")
                        .param("hobbies[0]", "reading")
                        .param("hobbies[1]", "gaming")
                        .param("socialMedias[0].name", "facebook")
                        .param("socialMedias[0].location", "facebook/")
                        .param("socialMedias[1].name", "Instagram")
                        .param("socialMedias[1].location", "Instagram/")
        ).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Success create person Eko Kurniawan Khaneddy with email eko.example.com with phone 082314 with address Jalan mangga with city Jakarta with country Indonesia with postalCode 21862"))
        );
    }

    @Test
    void createPersonValidationError() throws Exception {
        mockMvc.perform(
                post("/person")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("middleName", "Kurniawan")
                        .param("lastName", "Khannedy")
                        .param("address.street", "Jalan Belum Jadi")
                        .param("address.city", "Jakarta")
                        .param("address.country", "Indonesia")
                        .param("address.postalCode", "11111")
                        .param("hobbies[0]", "Coding")
                        .param("hobbies[1]", "Reading")
                        .param("hobbies[2]", "Gaming")
                        .param("socialMedias[0].name", "Facebook")
                        .param("socialMedias[0].location", "facebook.com/ProgrammerZamanNow")
                        .param("socialMedias[1].name", "Instagram")
                        .param("socialMedias[1].location", "instagram.com/ProgrammerZamanNow")
        ).andExpectAll(
                status().isBadRequest(),
                content().string(Matchers.containsString("You send invalid data"))
        );
    }
}
