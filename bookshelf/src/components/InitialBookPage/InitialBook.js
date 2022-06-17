import React from 'react';
import './InitialBook.css';
import { Card, Row, Col, Container } from "react-bootstrap";
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
            <div className="wrapinho">
            <Card style={{ width: "18rem" }} key={index} className="box">
                <Card.Img key = {index} src={book1} className="bookImage" alt="logo" />
                <Card.Body>
                    <Card.Title><div className="bookTitle" key = {index}>{book?.title}</div></Card.Title>
                    <Card.Text>
                        <div className="bookPrice" key = {index}>{book?.price} $</div>
                        <div className="buttonT">
                            <button className="button-32" onClick={sayHello}>Add to Basket</button>
                        </div>
                    </Card.Text>
                </Card.Body>
            </Card>



            </div>
            
           
           
            
            

            </>
            
            
        
        
            
            // <>
            // <div>
            //     <div>
            //         <div><img key = {index} src={book1} className="bookImage" alt="logo" /> </div>
            //             <div className="bookTitle" key = {index}>{book?.title}</div>
            //             <div className="bookPrice" key = {index}>{book?.price} $</div>
            //             <div className="buttonT">
            //             <button className="button-32" onClick={sayHello}>Add to Basket</button>
            //         </div>
            //     </div>
            // </div>
            // </>
        )
    })

    return (
       
        <> 
            <div className="row">
                <div className="grid">
                    {books}
           
                </div> 
            </div>  
            

        
    </>
          
    )
    
}

export default InitiaBook;