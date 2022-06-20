import React, {useState} from 'react';
import './Topbar.css';
import {  Link, useNavigate } from 'react-router-dom';
import  {BsPersonFill, BsCartFill, BsFillDoorOpenFill} from "react-icons/bs";



function Topbar({categorySetter}) {


  const navigate = useNavigate();

  function handleClick(){
    navigate("/register")
  }
 
  function handleClick3(){
    navigate("/inicialDash")
  }
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
  const logOut=()=>{
    localStorage.clear();
    navigate("/")
  }



  return (
    <div className="topbar">
      <div className="topbarWrapper">
        <div className="topLeft">
          <div className="title" onClick={handleClick3}>Bookshelf</div>
        </div>
        <div className="componentsWrapper">
          <div className="dropdown">
            <div className="dropdown-menu" onMouseEnter={showDropdown} onMouseLeave={hideDropdown}>
              
              <div className="components">Search by Category</div>
              {state?(<ul className="dropdown-list" onMouseEnter={showDropdown}>
                <ul className="items" onClick={()=>categorySetter("fantasy")} >Fantasy</ul>
                <ul className="items" onClick={()=>categorySetter("horror")} >Horror</ul>
                <ul className="items" onClick={()=>categorySetter("scifi")} >Science Fiction</ul>
              </ul>):
              null}
              
            </div>
          </div>
        </div>

        <div className="componentsWrapper2">
          <div className="dropdown2">
            <div className="dropdown-menu2" onMouseEnter={showDropdown2} onMouseLeave={hideDropdown2}>
              
              <div className="components2"><BsPersonFill style={{position: 'absolute'}} size="35px" color="white"/></div>
              {state2?(<ul className="dropdown-list2" onMouseEnter={showDropdown2}>
                <button className="items" onClick={handleClick}><BsCartFill style={{right: '10px',}}/>Check Card</button>
                <ul className="items"><BsPersonFill />Perfil</ul>
                <ul className="items" onClick={logOut}><BsFillDoorOpenFill  />Sign Out</ul>
              </ul>):
              null}
              
            </div>
          </div>

        </div>
        
      </div>
    </div>
  );
}

export default Topbar;
