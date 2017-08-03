package by.alex.allwayticket.controllers;


import by.alex.allwayticket.TestUtil;
import by.alex.allwayticket.services.StationService;
import by.alex.allwayticket.services.TrainService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-DispatcherServlet-context.xml")
@WebAppConfiguration
public class StationControllerTest {


        private MockMvc mockMvc;


        private StationService stationServiceMock;

        @Autowired
        private WebApplicationContext webApplicationContext;


        @Before
        public void setUp() {
            stationServiceMock = Mockito.mock(StationService.class);
            //We have to reset our mock between tests because the mock objects
            //are managed by the Spring container. If we would not reset them,
            //stubbing and verified behavior would "leak" from one test to another.
            Mockito.reset(stationServiceMock);

            mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();


        }

        @Test
        public void findStationByTrainId_ShouldReturnFoundStationDTOEntries() throws Exception {



            mockMvc.perform(get("/stations/{trainId}", 5))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                    .andExpect(jsonPath("$", hasSize(2)))
                    .andExpect(jsonPath("$[0].position", is(1)))
                    .andExpect(jsonPath("$[0].name", is("Grodno")))
                    .andExpect(jsonPath("$[0].timeDeparture", is("19:57")))
                    .andExpect(jsonPath("$[0].timeStop", is(nullValue())))
                    .andExpect(jsonPath("$[0].timeArrival", is(nullValue())))
                    .andExpect(jsonPath("$[1].position", is(2)))
                    .andExpect(jsonPath("$[1].name", is("Brest")))
                    .andExpect(jsonPath("$[1].timeDeparture", is(nullValue())))
                    .andExpect(jsonPath("$[1].timeArrival", is("08:40")))
                    .andExpect(jsonPath("$[1].timeStop", is(nullValue())));


        }



}
