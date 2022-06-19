import React, { useState } from 'react';
import './InitialBook.css';
import { Card, Row, Col, Container } from "react-bootstrap";
import book1 from './book1_tqs.jpg';
import api from "./api";
import '../SearchBar/./SearchBar.css';
import { BsSearch } from 'react-icons/bs';


function InitiaBook() {
    const  [data_stats, setData] = React.useState([]);
    const books = []
    
    const [title, setTitle] = React.useState("");
    React.useEffect(() => {
            api.get('books/Books/').then(res => {
            setData(res.data);
            console.log("res", res);
        });
    },[]);
    console.log(title);


    console.log(data_stats);
    
    data_stats.forEach((book, index) => {
        
        books.push(
            <>
            {title === "" ? (
            <>
            <div>
            <div className="wrapinho">
            <Card style={{ width: "18rem" }} key={index} className="box">
                <Card.Img key = {index} src={book1} className="bookImage" alt="logo" />
                <Card.Body>
                    <Card.Title><div className="bookTitle" key = {index}>{book?.title}</div></Card.Title>
                    <Card.Text>
                        <div className="bookPrice" key = {index}>{book?.price} $</div>
                        <div className="buttonT">
                            <button className="button-32" >Add to Basket</button>
                        </div>
                    </Card.Text>
                </Card.Body>
            </Card>
            </div>

            </div>
            </>
            ) : (
                <>
            {book?.title.slice(0, title.length) === title && (
            <div>
            <div >
            <Card style={{ width: "18rem" }} key={index} className="box">
                <Card.Img key = {index} src={book1} className="bookImage" alt="logo" />
                <Card.Body>
                    <Card.Title><div className="bookTitle" key = {index}>{book?.title}</div></Card.Title>
                    <Card.Text>
                        <div className="bookPrice" key = {index}>{book?.price} $</div>
                        <div className="buttonT">
                            <button className="button-32" >Add to Basket</button>
                        </div>
                    </Card.Text>
                </Card.Body>
            </Card>
            </div>
            </div>
            )}
            </>
            )}
            </>
        )
    })
  
       

    return (
        <>
        <>
        <div className="searchContainer">
            <div className="wrapper" >

                <div ><input value={title} className="searchInput" type="title" id="title" onChange={event => setTitle(event.target.value)} /></div>
                <div className="lupinha">
                    <BsSearch />
                </div>
            </div>
            
        </div>
        <br></br>
        <br></br>
        
            <div className="row">
                <div className="grid">
                    {books}
           
                </div> 
            </div>  
            

        </>
    </>
          
    )
    
}

export default InitiaBook;