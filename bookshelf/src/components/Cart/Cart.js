import React, { Component } from 'react';
import Topbar from '../TopBar/Topbar';
import book1 from './book1_tqs.jpg';
// import CartItem from './CartItem';
import api from "./api";
import './CartItem.css';

function Cart() {
    const books = JSON.parse(localStorage.getItem("orders"));
    localStorage.setItem("orders", JSON.stringify(books))
    const books2 = []
    const [data_stats, setData] = React.useState([]);
    const [price, setPrice] = React.useState([]);
    var book_id = null;
    const user_id = JSON.parse(localStorage.getItem("info")).id;
    React.useEffect(() => {
        api.get(`cartProducts/books/${user_id}/`).then(res => {
            setData(res.data);
            console.log("res", res);
        });
    }, []);
    React.useEffect(() => {
        api.get(`cartProducts/totalPrice/${user_id}/`).then(res => {
            setPrice(res.data);
            console.log("res", res);
        });
    }, []);
    
    function removeItem(index) {
        api.post(`cartProducts/removeBook/${index}`)
        book_id = index;
        console.log("BOOK_ID", index);
        alert('Remove Item');
    }
    function checkout() {
        alert('Checkout!');
    }


    data_stats.forEach((book, index) => {
        books2.push(
            <div className="cart-item">

                <div className="first">
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

                        <button className="button-3" onClick={()=>removeItem(index)}>Remove</button>

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
                            {price}
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