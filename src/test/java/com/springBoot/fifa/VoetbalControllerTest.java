package com.springBoot.fifa;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import domain.Stadium;
import domain.WedstrijdTicket;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class VoetbalControllerTest {

	@Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    
    private Stadium testStadium;
    
    @Mock
    private WedstrijdTicket mockWedstrijdTicket;

    @BeforeAll
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        testStadium = new Stadium("Al Thumama Stadium");
    }

    @Test
    public void test_StadiumForm() throws Exception {

        mockMvc.perform(get("/fifa"))
                .andExpect(view().name("stadiumForm"))
                .andExpect(model().attributeExists("stadium"));
    }
    
    @Test
    public void test_WedstrijdLijst() throws Exception {

        mockMvc.perform(post("/fifa")
        			.flashAttr("stadium", testStadium)
        		)
                .andExpect(view().name("wedstrijdLijst"))
                .andExpect(model().attributeExists("stadium"))
                .andExpect(model().attributeExists("wedstrijdList"));
    }
    
    @Test
    public void test_TicketForm_Get() throws Exception {

        mockMvc.perform(get("/fifa/8")
        			.flashAttr("stadium", testStadium)
        		)
                .andExpect(view().name("ticketForm"))
                .andExpect(model().attributeExists("stadium"))
                .andExpect(model().attributeExists("aankoop"))
                .andExpect(model().attributeExists("wedstrijdTicket"));
    }
    
    //TODO: add methodsource w/ correct arguments
    @ParameterizedTest
    @MethodSource("correctParams")
    public void test_TicketForm_Post_Correct(String email, String aantalTickets, String voetbalCode1, String voetbalCode2) throws Exception {

        mockMvc.perform(post("/fifa/4")
    			.flashAttr("stadium", testStadium)
    			.param("email", email)
    			.param("aantalTickets", aantalTickets)
    			.param("voetbalCode1", voetbalCode1)
    			.param("voetbalCode2", voetbalCode2)
    		)
            .andExpect(view().name("redirect:/fifa?ticketsAangekocht=" + aantalTickets));
    }
    
  //TODO: add methodsource w/ incorrect arguments
    @ParameterizedTest
    @MethodSource("incorrectParams")
    public void test_TicketForm_Post_Incorrect(String email, String aantalTickets, String voetbalCode1, String voetbalCode2) throws Exception {

        mockMvc.perform(post("/fifa/5")
    			.flashAttr("stadium", testStadium)
    			.param("email", email)
    			.param("aantalTickets", aantalTickets)
    			.param("voetbalCode1", voetbalCode1)
    			.param("voetbalCode2", voetbalCode2)
    		)
            .andExpect(view().name("ticketForm"));
    }
    
    private static Stream<Arguments> correctParams() {
		return Stream.of(
				Arguments.of("@", "1", "10", "20"),
				Arguments.of("test@test", "3", "-10", "20"),
				Arguments.of("test.test@test.test", "15", "-20", "-10"),
				Arguments.of("test123@", "25", "-1", "0")
		);
	}
    
    private static Stream<Arguments> incorrectParams() {
		return Stream.of(
				Arguments.of("", "1", "10", "20"),
				Arguments.of("@", "", "10", "20"),
				Arguments.of("@", "1", "", "20"),
				Arguments.of("@", "1", "10", ""),
				Arguments.of("a", "1", "10", "20"),
				Arguments.of("@", "a", "10", "20"),
				Arguments.of("@", "1", "a", "20"),
				Arguments.of("@", "1", "10", "a"),
				Arguments.of("@", "0", "10", "20"),
				Arguments.of("@", "-5", "10", "20"),
				Arguments.of("@", "26", "10", "20"),
				Arguments.of("@", "1", "20", "10"),
				Arguments.of("@", "1", "10", "10"),
				Arguments.of("@", "1", "10", "-20"),
				Arguments.of("@", "1", "-10", "-20")
		);
	}
    
}