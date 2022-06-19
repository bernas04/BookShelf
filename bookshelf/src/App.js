import './App.css';
import {Route, Routes} from "react-router";
import InitialDash from './InitialDash';
import Cart from './components/Cart/Cart';
import Login from './components/Login/Login';


function App() {

  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/index" element={<InitialDash />} />
      <Route path="/basket" element={<Cart />} />
    </Routes>
    
  );
}

export default App;
