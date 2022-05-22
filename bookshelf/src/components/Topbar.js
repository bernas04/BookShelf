import React from 'react';
import './Topbar.css';



const handleLogout = () => {
  localStorage.removeItem('token');
  window.location.href = '/';
};

function Topbar() {
  return (
    <div className="topbar">
      <div className="topbarWrapper">
        <div className="topLeft">
          <div className="title">Bookshelf</div>
        </div>
        <div className="componentsWrapper">
          <div className="components">Search by Category</div>
          <div className="components">Best Sellers</div>
        </div>
        
        <div className="topRigth">
          <div className="icons" onClick={() => handleLogout()}>
            Logout
            {/* <PersonOutlineRoundedIcon /> */}
          </div>
        </div>
      </div>
    </div>
  );
}

export default Topbar;
