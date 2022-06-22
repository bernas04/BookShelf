// package com.bookshelf.demo.controller;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.test.web.servlet.MockMvc;

// import com.bookshelf.demo.configuration.WebSecurityConfig;
// import com.bookshelf.demo.model.Book;
// import com.bookshelf.demo.services.BookService;

// import org.springframework.http.HttpHeaders;



// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.context.annotation.ComponentScan;
// import org.springframework.http.MediaType;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.context.annotation.FilterType;

// import static org.mockito.Mockito.when;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// import static org.hamcrest.Matchers.is;

// import java.util.ArrayList;
// import java.util.List;

// @WebMvcTest(value = BookController.class, excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebSecurityConfig.class)})
// @AutoConfigureMockMvc(addFilters = false)
// public class BookControllerTest {
//     @Autowired
//     private MockMvc mvc;

//     @MockBean
//     private BookService bookService;



//     @Test
//     public void allBooksTest() throws Exception{
//         List<Book> allBooks = new ArrayList<>();
//         allBooks.add(new Book("The Book of the jungle", "Augusto", "https://www.imdb.com/title/tt3040964/", "Science Fiction", "A boy is raised by a bear in the jungle", 12.0));
//         allBooks.add(new Book("Blue Queen", "Joao Eduardo", "image", "Horror", "A killer goes after teenager", 14.0));

//         when(bookService.getBooks()).thenReturn(allBooks);

//         mvc.perform(get("/api/books/Books").contentType(MediaType.APPLICATION_JSON))
//                             .andExpect(status().isOk())
//                             .andExpect(jsonPath("$.[0].title", is("The Book of the jungle")))
//                             .andExpect(jsonPath("$.[1].author", is("Joao Eduardo")));

//     }

//     // @Test
//     // public void postRider() throws Exception{
//     //     Store r = new Store("BookSHelf", new Address("Rua Mário Sacramento", "Aveiro", "PT", "3800"));
//     //     String exempleBody = "{\"name\":\"BookSHelf\", \"address\":{\"road\":\"Rua Mário Sacramento\", \"city\":\"Aveiro\", \"country\":\"PT\", \"zipcode\":\"3800\"}}";
//     //     HttpHeaders headers = new HttpHeaders();
//     //     headers.setContentType(MediaType.APPLICATION_JSON);
//     //     when(storeService.saveStore(r)).thenReturn(r);

//     //     mvc.perform(post("/api/stores/addStore").contentType(MediaType.APPLICATION_JSON)
//     //                     .accept(MediaType.APPLICATION_JSON)
//     //                     .headers(headers)
//     //                     .content(exempleBody)
//     //                     .contentType(MediaType.APPLICATION_JSON))
//     //                     .andExpect(status().isOk());
//     // }
// }

