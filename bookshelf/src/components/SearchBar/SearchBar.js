import React from 'react';
import './SearchBar.css';
import { BsSearch } from 'react-icons/bs';

function SearchBar() {
    const getInputValue = ()=>{
        // para receber o valor
    };
    return (


        <div className="searchContainer">
            <div className="wrapper">

                <div className="lupinha"><BsSearch /></div>
                <div><input className="searchInput" type="text" onChange={getInputValue} /></div>
             </div>
        </div>
    );
}

export default SearchBar;


