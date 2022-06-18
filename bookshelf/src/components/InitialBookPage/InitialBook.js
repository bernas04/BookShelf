import React, { useState } from 'react';
import './InitialBook.css';
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
    },[data_stats]);
    console.log(title);


    console.log(data_stats);
    
    data_stats.forEach((book, index) => {
        
        books.push(
            <>
            {title === "" ? (
            <>
            <div>
            <div >
            <div><img key = {index} src={book1} className="bookImage" alt="logo" /> </div>
                <div className="bookTitle" key = {index}>{book?.title}</div>
                <div className="bookPrice" key = {index}>{book?.price} $</div>
                <div className="buttonT">
                <button className="button-32" >Add to Basket</button>
            </div>
            </div>
            </div>
            </>
            ) : (
                <>
            {book?.title.slice(0, title.length) === title && (
            <div>
            <div >
            <div><img key = {index} src={book1} className="bookImage" alt="logo" /> </div>
                <div className="bookTitle" key = {index}>{book?.title}</div>
                <div className="bookPrice" key = {index}>{book?.price} $</div>
                <div className="buttonT">
                <button className="button-32" key={index} >Add to Basket</button>
            </div>
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
                    <button type="submit" className="btn btn-primary" >
                    <BsSearch />
                    </button>
                </div>
            </div>
            
        </div>
        <br></br>
        <br></br>
        
            <div className="row">
            {books}
            </div>  
            

        </>
    </>
          
    )
    
}

export default InitiaBook;