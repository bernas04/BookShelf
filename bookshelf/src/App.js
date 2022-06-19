import './App.css';
import {Route, Routes} from "react-router";
import InitialDash from './InitialDash';
import Cart from './components/Cart/Cart';
import Login from './components/LogIn_Register/Login';
import Register from'./components/LogIn_Register/Register';


function App() {

  return (
    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/inicialDash" element={<InitialDash />} />
      <Route path="/basket" element={<Cart />} />
      <Route path="/register" element={<Register />} />
    </Routes>
    
  );
}

export default App;
