import React from 'react';
import './User.css';
import book1 from './book1_tqs.jpg';
import Topbar from '../TopBar/Topbar';
import userImg from './user.jpg';
function User(props) {
    return (
        <>
            <Topbar />

            <div className="main">
                <div className="dash-user">
                    <div className="dashItem-user1">
                        <div><img src={userImg} className="userImage" alt="logo" /> </div>
                        <div className="userName">Mariana Matos</div>
                        <div className="user-email">matos@gmail.com</div>
                        <div className="user-address">Rua da Fonte, Curvos, n21, 4740-496</div>
                    </div>
                    <div className="dashItem-user2">

                        <div className="user-title">Order Status</div>
                        <div className="upcoming-orders">
                            <div className="wrapper-upcomming-orders">
                                <div className="border"></div>
                                <div className= "whole-order">
                                    <div className= "user-first">
                                        <div><img src={book1} className="user-bookImage" alt="logo" /> </div>
                                    </div>    
                                    <div className="user-second">
                                        <div className="user-bookTitle">Red Queen</div>
                                        <div className="user-bookAuthor">Victoria Aveyard</div>
                                            
                                    </div>
                                    <div className="user-third">
                                        <div className="user-bookAuthor">Expected data of arrival:</div>
                                        <div className="user-arrivalData">13/07/2022 at 14h30</div>
                                        <div className="user-button">
                                            <button className="button-5" >Cancel Your Order</button>
                                        </div>
                                    </div>

                                </div>
                                
                            </div>
                        </div>
                        <div className="upcoming-orders">
                            <div className="wrapper-upcomming-orders">
                                <div className="border"></div>
                                <div className= "user-first">
                                    <div><img src={book1} className="user-bookImage" alt="logo" /> </div>
                                </div>    
                                <div className="user-second">
                                    <div className="user-bookTitle">Red Queen</div>
                                    <div className="user-bookAuthor">Victoria Aveyard</div>
                                        
                                </div>
                                <div className="user-third">
                                    <div className="user-bookAuthor">Expected data of arrival:</div>
                                    <div className="user-arrivalData">13/07/2022 at 14h30</div>
                                    <div className="user-button">
                                        <button className="button-5" >Cancel Your Order</button>
                                    </div>
                                   
                                </div>
                            </div>
                        </div>
                        <div className="returing-orders">
                            <div className="user-title2">Returns Status</div>
                                <div className="return-wrapper">
                                <div className="wrapper-upcomming-orders">
                                <div className="border"></div>
                                <div className= "user-first">
                                    <div><img src={book1} className="user-bookImage" alt="logo" /> </div>
                                </div>    
                                <div className="user-second">
                                    <div className="user-bookTitle">Red Queen</div>
                                    <div className="user-bookAuthor">Victoria Aveyard</div>
                                        
                                </div>
                                <div className="user-third">
                                    <div className="user-bookAuthor">The pick up date to return the book is:</div>
                                    <div className="user-arrivalData">19/07/2022 at 17h30</div>
                                </div>
                            </div>

                                </div>
                        </div>
                        
                        
                    </div>
                </div>
                
            </div>


        </>
           
    );
}

export default User;