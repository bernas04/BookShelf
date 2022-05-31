import React from 'react';
import './User.css';
import Topbar from '../TopBar/Topbar';
import userImg from './user.jpg';
function User(props) {
    return (
        <>
            <Topbar />

            <div className="main">
                <div className="dash-user">
                    <div className="dashItem-user1">
                        <div className="user-image">
                        <div><img src={userImg} className="userImage" alt="logo" /> </div>
                        </div>
                    </div>
                    <div className="dashItem-user2">
                        
                    </div>
                </div>
                
            </div>


        </>
           
    );
}

export default User;