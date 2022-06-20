import React, { useState } from 'react';
import './InitialDash.css';
import Topbar from './components/TopBar/Topbar';
import SearchBar from './components/SearchBar/SearchBar';
import InitialBook from './components/InitialBookPage/InitialBook';

function InitialDash() {

  const [selectedCategory, setSelectedCategory] = useState(null)

  return (
    <div className="Dash">
      <Topbar categorySetter={setSelectedCategory} />
      <InitialBook category={selectedCategory} />
     
    </div>
  );
}

export default InitialDash;