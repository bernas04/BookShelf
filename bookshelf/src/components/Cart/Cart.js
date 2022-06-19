import React, { Component } from 'react';
import Topbar from '../TopBar/Topbar';
import book1 from './book1_tqs.jpg';
// import CartItem from './CartItem';
import './CartItem.css';

function Cart()  {
    const books = JSON.parse(localStorage.getItem("orders"));
    localStorage.setItem("orders",  JSON.stringify(books))
    const books2 = []

    function removeItem() {
        alert('Remove Item');
    }
    function checkout() {
        alert('Checkout!');
    }


    books.forEach((book, index) => {
        books2.push(
        <div className="cart-item">

                            <div className= "first">
                            <div><img src={book1} className="bookImage" alt="logo" /> </div>

                            </div>
                            <div className="second">
                                <div className="bookTitle2" key={index}>{book?.title}</div>
                                <div className="bookDescription" key={index}>{book?.description}</div>
                            </div>
                            <div className='third'>
                                <div className="price" key={index}>{book?.price}$
                                </div>
                                <div className="butaozinho">
                                    
                                    <button className="button-3" onClick={removeItem}>Remove</button>

                                </div>
                            
                            </div> 
                        </div>
                        )
    });
        return (
            <div className="inicial-cart">
                <Topbar />
                <div className="main">
                    <div className="cart">
                        <div className="cart-title">Your Basket</div>
                        {books2}
                        <div className="cart-item2">
                            <div className="total-price">
                                Total:32.0$ 
                            </div>
                            <div className="butaozinho2">
                                
                                <button className="button-4" onClick={checkout}>Checkout</button>

                            </div>


                        </div>

                    </div>

                </div>
        
             </div>
            
        );
}

export default Cart;