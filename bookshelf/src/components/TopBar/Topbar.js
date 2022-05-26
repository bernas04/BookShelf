import React, {useState} from 'react';
import './Topbar.css';
import { BsAlignBottom, BsPersonFill } from "react-icons/bs";



const handleLogout = () => {
  localStorage.removeItem('token');
  window.location.href = '/';
};

function Topbar() {
  const [state, setstate] = useState(false);
  const [state2, setstate2] = useState(false);

  const showDropdown=()=>{
    setstate(true);
  }
  const hideDropdown=()=>{
    setstate(false);
  }
  const showDropdown2=()=>{
    setstate2(true);
  }
  const hideDropdown2=()=>{
    setstate2(false);
  }

  return (
    <div className="topbar">
      <div className="topbarWrapper">
        <div className="topLeft">
          <div className="title">Bookshelf</div>
        </div>
        <div className="componentsWrapper">
          <div className="dropdown">
            <div className="dropdown-menu" onMouseEnter={showDropdown} onMouseLeave={hideDropdown}>
              
              <div className="components">Search by Category</div>
              {state?(<ul className="dropdown-list" onMouseEnter={showDropdown}>
                <ul className="items">Drama</ul>
                <ul className="items">Romance</ul>
                <ul className="items">Fiction</ul>
                <ul className="items">Manga</ul>

              </ul>):
              null}
              
            </div>
          </div>
          
          <div className="components2">Best Sellers</div>
        </div>


        <div className="dropdown">
            <div className="dropdown-menu" onMouseEnter={showDropdown2} onMouseLeave={hideDropdown2}>
              
              <div className="components"><BsPersonFill style={{position: 'absolute'}} size="35px" color="white"/></div>
              {state2?(<ul className="dropdown-list" onMouseEnter={showDropdown2}>
                <ul className="items">Drama</ul>
                <ul className="items">Romance</ul>
                <ul className="items">Fiction</ul>
                <ul className="items">Manga</ul>

              </ul>):
              null}
              
            </div>
          </div>
        
        {/* <div className="topRigth">
          <div className="icons" onClick={() => handleLogout()}>
            Logout
            <PersonOutlineRoundedIcon />
          </div>
        </div> */}
      </div>
    </div>
  );
}

export default Topbar;
