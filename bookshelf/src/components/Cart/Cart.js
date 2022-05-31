import React, { Component } from 'react';
import Topbar from '../TopBar/Topbar';
import book1 from './book1_tqs.jpg';
// import CartItem from './CartItem';
import './CartItem.css';

function Cart()  {
    
    function removeItem() {
        alert('Remove Item');
    }
    function checkout() {
        alert('Checkout!');
    }

        return (
            <div className="inicial-cart">
                <Topbar />
                <div className="main2">
                    <div className="cart">
                        <div className="cart-title">Your Basket</div>
                        <div className="cart-item">
                            <div className= "first">
                            <div><img src={book1} className="bookImage" alt="logo" /> </div>

                            </div>
                            <div className="second">
                                <div className="bookTitle2">Red Queen</div>
                                <div className="bookAuthor2">Victoria Aveyard</div>
                                <div className="bookDescription">Red Queen tells the story of Mare Barrow, a 17 year old girl who lives in a world where status depends on the colour of your blood. </div>
                            
                            </div>
                            <div className='third'>
                                <div className="price">16.0$
                                </div>
                                <div className="butaozinho">
                                    
                                    <button className="button-3" onClick={removeItem}>Remove</button>

                                </div>
                            
                            </div> 
                        </div>
                        <div className="cart-item">
                            <div className= "first">
                            <div><img src={book1} className="bookImage" alt="logo" /> </div>

                            </div>
                            <div className="second">
                                <div className="bookTitle2">Red Queen</div>
                                <div className="bookAuthor2">Victoria Aveyard</div>
                                <div className="bookDescription">Red Queen tells the story of Mare Barrow, a 17 year old girl who lives in a world where status depends on the colour of your blood. </div>
                            
                            </div>
                            <div className='third'>
                                <div className="price">16.0$
                                </div>
                                <div className="butaozinho">
                                    
                                    <button className="button-3" onClick={removeItem}>Remove</button>

                                </div>
                            
                            </div> 
                        </div>
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