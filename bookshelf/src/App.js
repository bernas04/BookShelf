import './App.css';
import {Route, Routes} from "react-router";
import InitialDash from './InitialDash';
import Cart from './components/Cart/Cart';
import Login from './components/LogIn_Register/Login';
import Register from'./components/LogIn_Register/Register';
import ProtectedRoutes from './components/Configuration/ProtectedRoutes';




function App() {

  return (

    <Routes>
      <Route path="/" element={<Login />} />
      <Route path="/register" element={<Register />} />
      <Route element={<ProtectedRoutes/>}>
        <Route path="/inicialDash" element={<InitialDash />} />
        <Route path="/basket" element={<Cart />} />
      </Route>
    </Routes>

    
  );
}

export default App;
