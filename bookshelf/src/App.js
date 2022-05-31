import './App.css';
import {Route, Routes} from "react-router";
import InitialDash from './InitialDash';
import Cart from './components/Cart/Cart';
import User from './components/User/User';


function App() {

  return (
    <div style={{"background-color": "#e3e4e0", "height": "100vh"}}>
      <Routes>
        <Route path="/" element={<InitialDash />} />
        <Route path="/basket" element={<Cart />} />
        <Route path="/profile" element={<User />} />
      </Routes>
    </div>
    
  );
}

export default App;
