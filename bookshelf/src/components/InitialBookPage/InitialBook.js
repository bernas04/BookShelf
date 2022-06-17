import React from 'react';
import './InitialBook.css';
import book1 from './book1_tqs.jpg';
import api from "./api";


function InitiaBook() {
    const  [data_stats, setData] = React.useState([]);
    const books = []
    React.useEffect(() => {
        
            api.get('books/Books/').then(res => {
            setData(res.data);
            console.log(res);
            

        });
    },[data_stats]);


    function sayHello() {
        alert('Johnny you hit me!');
    }
    
    data_stats.forEach((book, index) => {
        books.push(
        
        
            
            <>
            <div>
            <div >
            <div><img key = {index} src={book1} className="bookImage" alt="logo" /> </div>
                <div className="bookTitle" key = {index}>{book?.title}</div>
                <div className="bookPrice" key = {index}>{book?.price} $</div>
                <div className="buttonT">
                <button className="button-32" onClick={sayHello}>Add to Basket</button>
            </div>
            </div>
            </div>
            </>
        )
    })

    return (
       
        <> 
            <div className="row">
            {books}
            </div>  
            

        
    </>
          
    )
    
}

export default InitiaBook;