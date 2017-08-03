package by.alex.allwayticket.controllers;


import by.alex.allwayticket.TestUtil;
import by.alex.allwayticket.dtos.TrainRouteDTO;
import by.alex.allwayticket.dtos.UtilDTO;
import by.alex.allwayticket.entities.Station;
import by.alex.allwayticket.entities.Train;
import by.alex.allwayticket.enums.TypeTrain;
import by.alex.allwayticket.services.TrainService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import static junit.framework.Assert.assertNull;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-DispatcherServlet-context.xml")
@WebAppConfiguration

public class TrainControllerTest {

    private MockMvc mockMvc;


    private TrainService trainServiceMock;

    @Autowired
    private WebApplicationContext webApplicationContext;


    @Before
    public void setUp() {
        trainServiceMock = Mockito.mock(TrainService.class);
        //We have to reset our mock between tests because the mock objects
        //are managed by the Spring container. If we would not reset them,
        //stubbing and verified behavior would "leak" from one test to another.
        Mockito.reset(trainServiceMock);

        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();


    }

    @Test
    public void findTrainsByTwoStations_ShouldReturnFoundTrainRouteDTOEntries() throws Exception {


        mockMvc.perform(get("/trains/route/{from}/{to}", "Minsk", "Vitebsk"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(2)))
                .andExpect(jsonPath("$[0].trainBeginFromStation", is("Minsk")))
                .andExpect(jsonPath("$[0].trainEndToStation", is("Vitebsk")))
                .andExpect(jsonPath("$[0].timeDeparture", is("16:43")))
                .andExpect(jsonPath("$[0].timeArrival", is("20:23")))
                .andExpect(jsonPath("$[1].id", is(10)))
                .andExpect(jsonPath("$[1].trainBeginFromStation", is("Brest")))
                .andExpect(jsonPath("$[1].trainEndToStation", is("Vitebsk")))
                .andExpect(jsonPath("$[1].timeDeparture", is("18:42")))
                .andExpect(jsonPath("$[1].timeArrival", is("23:13")));


    }


    @Test
    public void findTrainsByTwoStationsAndDaysOfWeek_ShouldReturnFoundTrainRouteDTOEntries() throws Exception {

        mockMvc.perform(get("/trains/route/{from}/{to}/{date}", "Mogilev", "Vitebsk", "26-07-2017"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(4)))
                .andExpect(jsonPath("$[0].trainType", is("PASSENGER")))
                .andExpect(jsonPath("$[0].trainBeginFromStation", is("Gomel")))
                .andExpect(jsonPath("$[0].trainEndToStation", is("Vitebsk")))
                .andExpect(jsonPath("$[0].timeDeparture", is("18:22")))
                .andExpect(jsonPath("$[0].timeArrival", is("21:51")));


    }

    @Test
    public void findTrainsByOneStation_ShouldReturnFoundTrainStationDTOEntries() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm");


        mockMvc.perform(get("/trains/st/{station}", "Minsk"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(4)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].trainBeginFromStation", is("Vitebsk")))
                .andExpect(jsonPath("$[0].trainEndToStation", is("Minsk")))
                .andExpect(jsonPath("$[0].stationSearch", is("Minsk")))
                .andExpect(jsonPath("$[0].timeDeparture", is(nullValue())))
                .andExpect(jsonPath("$[0].timeStop", is(nullValue())))
                .andExpect(jsonPath("$[0].timeArrival", is("10:04")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].trainBeginFromStation", is("Minsk")))
                .andExpect(jsonPath("$[1].trainEndToStation", is("Vitebsk")))
                .andExpect(jsonPath("$[1].stationSearch", is("Minsk")))
                .andExpect(jsonPath("$[1].timeArrival", is(nullValue())))
                .andExpect(jsonPath("$[1].timeStop", is(nullValue())))
                .andExpect(jsonPath("$[1].timeDeparture", is("16:43")))
                .andExpect(jsonPath("$[2].id", is(9)))
                .andExpect(jsonPath("$[2].trainBeginFromStation", is("Vitebsk")))
                .andExpect(jsonPath("$[2].trainEndToStation", is("Brest")))
                .andExpect(jsonPath("$[2].stationSearch", is("Minsk")))
                .andExpect(jsonPath("$[2].timeDeparture", is("03:53")))
                .andExpect(jsonPath("$[2].timeStop", is("00:15")))
                .andExpect(jsonPath("$[2].timeArrival", is("03:38")));


    }




    @Test
    public void findTrainsByStationsAndDaysOfWeek_ShouldReturnFoundTrainStationDTOEntries() throws Exception {



        mockMvc.perform(get("/trains/st/{station}/{date}", "Gomel","29-07-2017"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(3)))
                .andExpect(jsonPath("$[0].trainType", is("PASSENGER")))
                .andExpect(jsonPath("$[0].trainBeginFromStation", is("Vitebsk")))
                .andExpect(jsonPath("$[0].trainEndToStation", is("Gomel")))
                .andExpect(jsonPath("$[0].timeArrival", is("15:58")))
                .andExpect(jsonPath("$[0].timeDeparture", is(nullValue())))
                .andExpect(jsonPath("$[0].timeStop", is(nullValue())))
                .andExpect(jsonPath("$[1].id", is(8)))
                .andExpect(jsonPath("$[1].trainType", is("PASSENGER")))
                .andExpect(jsonPath("$[1].trainBeginFromStation", is("Brest")))
                .andExpect(jsonPath("$[1].trainEndToStation", is("Vitebsk")))
                .andExpect(jsonPath("$[1].timeArrival", is("00:47")))
                .andExpect(jsonPath("$[1].timeDeparture", is("01:20")))
                .andExpect(jsonPath("$[1].timeStop", is("00:33")));



    }

    /*@Test
    public void findById_TodoEntryFound_ShouldReturnFoundTodoEntry() throws Exception {
        Todo found = new TodoBuilder()
                .id(1L)
                .description("Lorem ipsum")
                .title("Foo")
                .build();

        when(trainServiceMock.findById(1L)).thenReturn(found);

        mockMvc.perform(get("/api/todo/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.description", is("Lorem ipsum")))
                .andExpect(jsonPath("$.title", is("Foo")));

        verify(trainServiceMock, times(1)).findById(1L);
        verifyNoMoreInteractions(trainServiceMock);
    }

    @Test
    public void findById_TodoEntryNotFound_ShouldReturnHttpStatusCode404() throws Exception {
        when(trainServiceMock.findById(1L)).thenThrow(new TodoNotFoundException(""));

        mockMvc.perform(get("/api/todo/{id}", 1L))
                .andExpect(status().isNotFound());

        verify(trainServiceMock, times(1)).findById(1L);
        verifyNoMoreInteractions(trainServiceMock);
    }

    @Test
    public void update_EmptyTodoEntry_ShouldReturnValidationErrorForTitle() throws Exception {
        TodoDTO dto = new TodoDTOBuilder()
                .id(1L)
                .build();

        mockMvc.perform(put("/api/todo/{id}", 1L)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.fieldErrors", hasSize(1)))
                .andExpect(jsonPath("$.fieldErrors[0].path", is("title")))
                .andExpect(jsonPath("$.fieldErrors[0].message", is("The title cannot be empty.")));

        verifyZeroInteractions(trainServiceMock);
    }

    @Test
    public void update_TitleAndDescriptionAreTooLong_ShouldReturnValidationErrorsForTitleAndDescription() throws Exception {
        String title = TestUtil.createStringWithLength(Todo.MAX_LENGTH_TITLE + 1);
        String description = TestUtil.createStringWithLength(Todo.MAX_LENGTH_DESCRIPTION + 1);

        TodoDTO dto = new TodoDTOBuilder()
                .id(1L)
                .description(description)
                .title(title)
                .build();

        mockMvc.perform(put("/api/todo/{id}", 1L)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))
        )
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.fieldErrors", hasSize(2)))
                .andExpect(jsonPath("$.fieldErrors[*].path", containsInAnyOrder("title", "description")))
                .andExpect(jsonPath("$.fieldErrors[*].message", containsInAnyOrder(
                        "The maximum length of the description is 500 characters.",
                        "The maximum length of the title is 100 characters."
                )));

        verifyZeroInteractions(trainServiceMock);
    }

    @Test
    public void update_TodoEntryNotFound_ShouldReturnHttpStatusCode404() throws Exception {
        TodoDTO dto = new TodoDTOBuilder()
                .id(3L)
                .description("description")
                .title("title")
                .build();

        when(trainServiceMock.update(any(TodoDTO.class))).thenThrow(new TodoNotFoundException(""));

        mockMvc.perform(put("/api/todo/{id}", 3L)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))
        )
                .andExpect(status().isNotFound());

        ArgumentCaptor<TodoDTO> dtoCaptor = ArgumentCaptor.forClass(TodoDTO.class);
        verify(trainServiceMock, times(1)).update(dtoCaptor.capture());
        verifyNoMoreInteractions(trainServiceMock);

        TodoDTO dtoArgument = dtoCaptor.getValue();
        assertThat(dtoArgument.getId(), is(3L));
        assertThat(dtoArgument.getDescription(), is("description"));
        assertThat(dtoArgument.getTitle(), is("title"));
    }

    @Test
    public void update_TodoEntryFound_ShouldUpdateTodoEntryAndReturnIt() throws Exception {
        TodoDTO dto = new TodoDTOBuilder()
                .id(1L)
                .description("description")
                .title("title")
                .build();

        Todo updated = new TodoBuilder()
                .id(1L)
                .description("description")
                .title("title")
                .build();

        when(trainServiceMock.update(any(TodoDTO.class))).thenReturn(updated);

        mockMvc.perform(put("/api/todo/{id}", 1L)
                .contentType(TestUtil.APPLICATION_JSON_UTF8)
                .content(TestUtil.convertObjectToJsonBytes(dto))
        )
                .andExpect(status().isOk())
                .andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.description", is("description")))
                .andExpect(jsonPath("$.title", is("title")));

        ArgumentCaptor<TodoDTO> dtoCaptor = ArgumentCaptor.forClass(TodoDTO.class);
        verify(trainServiceMock, times(1)).update(dtoCaptor.capture());
        verifyNoMoreInteractions(trainServiceMock);

        TodoDTO dtoArgument = dtoCaptor.getValue();
        assertThat(dtoArgument.getId(), is(1L));
        assertThat(dtoArgument.getDescription(), is("description"));
        assertThat(dtoArgument.getTitle(), is("title"));
    }*/
}

